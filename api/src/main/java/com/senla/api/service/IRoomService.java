package com.senla.api.service;




import com.senla.model.Room;
import com.senla.model.RoomStars;
import com.senla.model.RoomStatus;

import java.util.List;

public interface IRoomService {

     Room changeRoomStatus(Integer id, RoomStatus status);

     Room changePriceOnRoom(Integer id, Integer price);

     Room addRoom(Integer number, Integer prise, Integer capacity, RoomStatus status , RoomStars stars);

     List<Room> getSortRoomsByCapacity();

     List<Room> getSortRoomsByPrice();

     List<Room> getSortRoomsByStars();

     List<Room> getSortEmptyRoomsByCapacity();

     List<Room>  getSortEmptyRoomsPrise();

     List<Room> getSortEmptyRoomsByStars();

     int getEmptyRoomsNumber();

     Room printDetailsOfRoom(Room room);

     Room getRoom(Integer number);

     Room getRoomNumber(int number);

     List<Room> roomList();



     boolean isRoomStatus();

}
