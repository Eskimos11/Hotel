package com.senla.services;



import com.senla.api.dao.IHistoryDao;
import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IHistoryService;
import com.senla.dao.GuestDao;

import com.senla.exceptions.DaoExceptions;
import com.senla.exceptions.ServiceExceptions;
import com.senla.model.*;

import com.senla.util.sorters.HistoryCheckOutDateComparator;
import com.senla.util.sorters.SortingGuestsByName;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
@Log4j
@Service
public class HistoryService implements IHistoryService {

    private final GuestDao guestDao ;
    private final IRoomDao roomDao ;
    private final IHistoryDao historyDao ;
    private final IMaintenanceDao maintenanceDao;


    public HistoryService(GuestDao guestDao, IRoomDao roomDao, IHistoryDao historyDao, IMaintenanceDao maintenanceDao) {
        this.guestDao = guestDao;
        this.roomDao = roomDao;
        this.historyDao = historyDao;
        this.maintenanceDao = maintenanceDao;
    }

    @Transactional
    @Override
    public History checkInGuest(Integer roomId, Integer guestId, LocalDate checkInDate, LocalDate checkOutDate) {
        try {
            Room room = roomDao.getById(roomId);
            Guest guest = guestDao.getById(guestId);
            History history = new History();
            history.setGuest(guest);
            history.setRoom(room);
            history.setCheckInDate(checkInDate);
            history.setCheckOutDate(checkOutDate);
            history.setGuestCheckIn(true);
            room.setStatus(RoomStatus.SERVICED);
            room.setEmpty(false);
            historyDao.save(history);
            return history;
        } catch (DaoExceptions e) {
            log.error("CheckIn failed", e);
            throw new ServiceExceptions("CheckIn failed", e);
        }
    }

    @Transactional
    @Override
    public History evictGuest(Integer historyId) {
        try {
            History history = historyDao.getById(historyId);
            history.setGuestCheckIn(false);
            history.getRoom().setEmpty(true);
            history.getRoom().setStatus(RoomStatus.EMPTY);
            return history;
        } catch (DaoExceptions e) {
            log.error("evictGuest failed", e);
            throw new ServiceExceptions("evictGuest failed", e);
        }
    }
    @Transactional
    @Override
    public History addServicesToGuest(Integer historyId, Integer maintenanceId) {
        try {
            History history = historyDao.getById(historyId);
            Maintenance maintenance = maintenanceDao.getById(maintenanceId);
            history.getMaintenances().add(maintenance);
            historyDao.update(history);
            return history;
        } catch (DaoExceptions e) {
            log.error("evictGuest", e);
            throw new ServiceExceptions("evictGuest", e);
        }
    }

    @Override
    public List<History> guestList() {
        List<History> guestList = new ArrayList<>();
        for (History history : historyDao.getAll()) {
            if (history.isGuestCheckIn() == true) {
                System.out.println(history.getGuest() + " and " + history.getRoom());
                guestList.add(history);
            }
        }
        return guestList;
    }

    @Override
    public List<History> getSortedGuestsByLastName() {
        List<History> historyList = historyDao.getAll();
        historyList.sort(new SortingGuestsByName());
        return historyList.stream().filter(History::isGuestCheckIn).collect(Collectors.toList());
    }

    @Override
    public List<History> historiesSortedByCheckOutDate() {
        List<History> histories = historyDao.getAll();
        histories.sort(new HistoryCheckOutDateComparator());
        return histories.stream().filter(History::isGuestCheckIn).collect(Collectors.toList());
    }

    @Override
    public int numberOfGuests() {
        List<History> histories = historyDao.getAll().stream()
                .filter(History::isGuestCheckIn)
                .collect(Collectors.toList());
        return histories.size();
    }

    @Override
    public History getHistory(Integer Id) {
        History history = historyDao.getById(Id);
        return history;
    }

    @Override
    public List<Room> showEmptyRoomsOnDate(LocalDate date) {
        try {
            List<History> histories = historyDao.getAll();
            return histories.stream().filter(o1 -> o1.getCheckOutDate().isBefore(date)).map(History::getRoom).collect(Collectors.toList());
        } catch (DaoExceptions e) {
            log.error("showEmptyRoomsOnDate failed", e);
            throw new ServiceExceptions("showEmptyRoomsOnDate failed", e);
        }
    }

    @Override
    public int guestPaymentAmount(Integer historyId) {
        try {
            History history = historyDao.getById(historyId);
            int priceForService = 0;
            int serviceInvoice = 0;
            List<Maintenance> historyList = getListMaintenanceGuest(historyId);
            for (Maintenance maintenance : historyList) {
                priceForService = maintenance.getPrice();
                serviceInvoice = serviceInvoice + priceForService;
            }
            int day = getDaysBetweenDate(history.getCheckInDate(), history.getCheckOutDate());
            int totalAmount = history.getRoom().getPrice() * day + serviceInvoice;
            return totalAmount;
        } catch (DaoExceptions e) {
            log.error("guestPaymentAmount failed", e);
            throw new ServiceExceptions("guestPaymentAmount failed", e);
        }
    }


    @Override
    public List<History> getThreeLastGuest(Integer roomId) {
        try {
            List<History> histories = historyDao.getAll().stream().filter(h1 -> h1.getRoom().getId().equals(roomId)).collect(Collectors.toList());
            List<History> threeLastHistories = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                threeLastHistories.add(histories.get(histories.size() - i));
            }
            return threeLastHistories;
        } catch (DaoExceptions e) {
            log.error("getThreeGuest failed", e);
            throw new ServiceExceptions("getThreeGuest failed", e);
        }
    }

    @Override
    public List<Maintenance> getListMaintenanceGuest(Integer historyId) {
        try {
            List<Maintenance> listMaintenanceGuest = historyDao.getById(historyId).getMaintenances();
            return listMaintenanceGuest;
        } catch (DaoExceptions e) {
            log.error("getListMaintenanceGuest failed", e);
            throw new ServiceExceptions("getListMaintenanceGuest failed", e);
        }
    }

    @Override
    public List<Maintenance> getGuestMaintenanceSortByPrise(Integer historyId) {
        try {
            List<Maintenance> maintenances = historyDao.getById(historyId).getMaintenances();
            maintenances.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
            return maintenances;
        } catch (DaoExceptions e) {
            log.error("getGuestMaintenanceSortByPrise failed", e);
            throw new ServiceExceptions("getGuestMaintenanceSortByPrise failed", e);
        }
    }

    @Override
    public List<History> getAllHistoryId() {
        List<History> historyList = historyDao.getAll();
        return historyList;
    }

    @Override
    public int getDaysBetweenDate(LocalDate start, LocalDate end) {
        Period period = Period.between(start, end);
        return period.getDays();
    }

    @Override
    public List<History> historyList() {
        List<History> historyList = historyDao.getAll();
        return historyList;
    }
}

