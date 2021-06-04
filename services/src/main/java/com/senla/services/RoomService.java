package com.senla.services;

import com.senla.api.service.IRoomService;
import com.senla.dao.GuestDao;
import com.senla.dao.RoomDao;

import com.senla.exceptions.DaoExceptions;
import com.senla.exceptions.ServiceExceptions;
import com.senla.model.Room;
import com.senla.model.RoomStars;
import com.senla.model.RoomStatus;
import com.senla.util.IdGenerator;
import com.senla.util.PropertiesHandler;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;


@Log4j
@Service
public class RoomService implements IRoomService {


    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Transactional
    @Override
    public Room addRoom(Integer number, Integer price, Integer capacity, RoomStatus status, RoomStars stars) {
        try {
            Room room = new Room(number, price, capacity, status, stars);
            roomDao.save(room);
            return room;
        } catch (DaoExceptions e) {
            log.error("addRoom failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        } finally {

        }
    }

    @Override
    public boolean isRoomStatus() {

        Boolean isAllowed = PropertiesHandler.getProperty("server.room.change_status.enable")
                .map(Boolean::valueOf)
                .orElse(false);
        return true;
    }

    @Transactional
    @Override
    public Room changeRoomStatus(Integer id, RoomStatus status) {
        try {
            Room room = roomDao.getById(id);
            room.setStatus(status);
            roomDao.update(room);
            return room;
        } catch (DaoExceptions e) {
            log.error("changeRoomStatus failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }

    @Transactional
    @Override
    public Room changePriceOnRoom(Integer id, Integer price) {
        try {
            Room room = roomDao.getById(id);
            room.setPrice(price);
            roomDao.update(room);
            return room;
        } catch (DaoExceptions e) {
            log.error("changePriceOnRoom failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }

    @Override
    public Room printDetailsOfRoom(Room room) {
        return room;
    }

    @Override
    public List<Room> getSortRoomsByCapacity() {
        List<Room> rooms = roomDao.getAll();
        rooms.sort((Comparator.comparingInt(Room::getCapacity)));
        return rooms;
    }

    @Override
    public List<Room> getSortRoomsByPrice() {
        List<Room> rooms = roomDao.getAll();
        rooms.sort(Comparator.comparingInt(Room::getPrice));
        return rooms;
    }

    @Override
    public List<Room> getSortRoomsByStars() {
        List<Room> rooms = roomDao.getAll();
//        rooms.sort((o1, o2) -> (o1.getStars()) - o2.getStars()));
        return rooms;
    }

    @Override
    public List<Room> getSortEmptyRoomsPrise() { //Долж
        return getSortRoomsByPrice().stream().filter(Room::isEmpty).collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortEmptyRoomsByCapacity() { //Долж
        return getSortRoomsByCapacity().stream().filter(Room::isEmpty).collect(Collectors.toList());
    }

    @Override
    public List<Room> getSortEmptyRoomsByStars() { //Долж
        return getSortRoomsByStars().stream().filter(Room::isEmpty).collect(Collectors.toList());
    }

    @Override
    public int getEmptyRoomsNumber() {
        List<Room> roomEmpty = new ArrayList<>();
        List<Room> rooms = roomDao.getAll();
        for (Room room : rooms) {
            if (room.getStatus() == RoomStatus.EMPTY)
                roomEmpty.add(room);
        }
        return roomEmpty.size();
    }

    @Override
    public Room getRoom(Integer id) {
        Room room = roomDao.getById(id);
        return room;
    }


    @Override
    public List<Room> roomList() {
        List<Room> roomList = roomDao.getAll();
        return roomList;
    }

    @Override
    public Room getRoomNumber(int number) {
        for (Room room : roomDao.getAll()) {
            if (room.getNumber() == number)
                return room;
        }
        return null;
    }
}






