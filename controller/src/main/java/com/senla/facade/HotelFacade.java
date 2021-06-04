package com.senla.facade;



import com.senla.api.IFacade;


import com.senla.api.dao.IGuestDao;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IHistoryService;
import com.senla.api.service.IMaintenanceService;
import com.senla.api.service.IRoomService;


import com.senla.dao.GuestDao;
import com.senla.model.*;

import com.senla.services.GuestService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j
@Service
public class HotelFacade implements IFacade {

    private final IGuestService guestService ;

    private final IRoomService roomService;

    private final IMaintenanceService maintenanceService;

    private final IHistoryService historyService ;



    public HotelFacade(IGuestService guestService, IRoomService roomService, IMaintenanceService maintenanceService, IHistoryService historyService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.maintenanceService = maintenanceService;
        this.historyService = historyService;
    }



    //==============================Room====================================
    @Override
    public Room addRoom(Integer number, Integer price, Integer capacity, RoomStatus status, RoomStars stars) {
        Room room = roomService.addRoom(number, price, capacity, status, stars);
        return room;
    }


    @Override
    public int getEmptyRoomNumber() {
        int roomNumber = roomService.getEmptyRoomsNumber();
        return roomNumber;

    }

    @Override
    public List<Room> getSortRoomsByPrice() {
        List<Room> rooms = roomService.getSortRoomsByPrice();
        return rooms;
    }

    @Override
    public List<Room> getSortRoomsByCapacity() {
        List<Room> rooms = roomService.getSortRoomsByCapacity();
        return rooms;
    }

    @Override
    public List<Room> getSortRoomsByStars() {
        List<Room> rooms = roomService.getSortRoomsByStars();
        return rooms;
    }

    @Override
    public Room changeRoomStatus(Integer id, RoomStatus status) {
        Room room = roomService.changeRoomStatus(id, status);
        return room;
    }
    public Room changePriceOnRoom(Integer id, Integer price){
        Room room = roomService.changePriceOnRoom(id, price);
        return room;
    }

    @Override
    public List<Room> getSortEmptyRoomsByCapacity() {
        List<Room> rooms = roomService.getSortEmptyRoomsByCapacity();
        return rooms;
    }

    @Override
    public List<Room> getSortEmptyRoomsByStars() {
        List<Room> rooms = roomService.getSortEmptyRoomsByStars();
        return rooms;
    }

    @Override
    public List<Room> getSortEmptyRoomPrise() {
        List<Room> rooms = roomService.getSortEmptyRoomsPrise();
        return rooms;
    }

    @Override
    public List<Room> roomList() {
        List<Room> roomList = roomService.roomList();
        return roomList;
    }
    @Override
    public Room getRoom(Integer id){
        Room room = roomService.getRoom(id);
        return room;
    }

    //====================Maintenance=========================
    @Override
    public Maintenance addMaintenance(String name, Integer prise) {
        Maintenance maintenance = maintenanceService.addMaintenance(name,prise);
        return maintenance;
    }

    @Override
    public Maintenance deleteMaintenance(Integer id) {
        Maintenance maintenance = maintenanceService.deleteMaintenance(id);
        return maintenance;
    }

    @Override
    public Maintenance getMaintenance(Integer id) {
        Maintenance maintenance = maintenanceService.getMaintenance(id);
        return maintenance;
    }

    @Override
    public List<Maintenance> maintenanceList() {
        List<Maintenance> maintenanceList = maintenanceService.maintenanceList();
        return maintenanceList;
    }
    @Override
    public Maintenance changeMaintenance(Integer id, Integer price, String name){
        Maintenance maintenance = maintenanceService.changeMaintenance(id,price,name);
        return maintenance;
    }

    //====================Guest=========================
    @Override
    public Guest addGuest(String lastName) {
        Guest guest = guestService.addGuest(lastName);
        return guest;
    }

    @Override
    public Guest deleteGuest(Integer id) {
        Guest guest = guestService.deleteGuest(id);
        return guest;
    }

    @Override
    public List<Guest> guestList() {
        List<Guest> guestList = guestService.guestList();
        return guestList;
    }
    @Override
    public Guest getGuest(Integer id) {
        Guest guest = guestService.getGuest(id);
        return guest;
    }
    @Override
    public Guest changeGuest(Integer id,String lastname){
        Guest guest = guestService.changeGuest(id,lastname);
        return guest;
    }

    //====================History=========================
    @Override
    public History checkInGuest(Integer roomId, Integer guestId, LocalDate checkInDate, LocalDate checkOut) {
        History history = historyService.checkInGuest(roomId, guestId, checkInDate, checkOut);
        return history;
    }

    @Override
    public History evictGuest(Integer id) {
        History history = historyService.evictGuest(id);
        return history;
    }

    @Override
    public History addServicesToGuest(Integer idHistory, Integer idMaintenance) {
        History history = historyService.addServicesToGuest(idHistory, idMaintenance);
        return history;
    }

    @Override
    public List<History> getSortedGuestByLastName() {
        List<History> histories = historyService.getSortedGuestsByLastName();
        return histories;
    }

    @Override
    public List<History> getHistoriesSortedByCheckOutDate() {
        List<History> histories = historyService.historiesSortedByCheckOutDate();
        return histories;
    }

    @Override
    public int numberGuest() {
        int history = historyService.numberOfGuests();
        return history;
    }

    @Override
    public List<Room> showEmptyRoomsOnDate(LocalDate date) {
        List<Room> EmptyRoomsOnDate = historyService.showEmptyRoomsOnDate(date);
        return EmptyRoomsOnDate;
    }

    @Override
    public History getHistory(Integer id) {
        History history = historyService.getHistory(id);
        return history;
    }

    @Override
    public List<Maintenance> maintenanceGuest(Integer id) {
        List<Maintenance> maintenanceList = historyService.getHistory(id).getMaintenances();
        return maintenanceList;
    }

    @Override
    public int guestPaymentAmount(Integer id) {
        int history = historyService.guestPaymentAmount(id);
        return history;
    }

    @Override
    public List<History> getThreeLastGuest(Integer roomId) {
        List<History> histories = historyService.getThreeLastGuest(roomId);
        return histories;
    }

    @Override
    public List<History> historyList() {
        List<History> historyList = historyService.historyList();
        return historyList;
    }
    //---------------------------------------------------------------------------

//    public void exit() {
//        SerializationHandler.serialize(guestDao.getAll(), maintenanceDao.getAll(), roomDao.getAll(), historyDao.getAll());
//    }
//
//    public void start() {
//        try {
//            List<Room> r = SerializationHandler.deserialize(Room.class);
//            List<Guest> g = SerializationHandler.deserialize(Guest.class);
//            List<History> h = SerializationHandler.deserialize(History.class);
//            List<Maintenance> m = SerializationHandler.deserialize(Maintenance.class);
//            roomDao.saveAll(r);
//            guestDao.saveAll(g);
//            historyDao.saveAll(h);
//            maintenanceDao.saveAll(m);
//        } catch (Exception e) {
//            log.error("File not found ", e);
//        }
//    }
}


