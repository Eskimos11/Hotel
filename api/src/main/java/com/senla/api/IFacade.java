package com.senla.api;



import com.senla.model.*;

import java.time.LocalDate;
import java.util.List;

public interface IFacade {
    //==============================Room====================================

    Room addRoom(Integer number, Integer prise, Integer capacity, RoomStatus status, RoomStars stars);


    int getEmptyRoomNumber();

    List<Room> getSortRoomsByPrice();

    List<Room> getSortRoomsByCapacity();

    List<Room> getSortRoomsByStars();

    Room changeRoomStatus(Integer id, RoomStatus status);

     Room changePriceOnRoom(Integer id, Integer price);

    List<Room> getSortEmptyRoomsByCapacity();

    List<Room> getSortEmptyRoomsByStars();

    List<Room> getSortEmptyRoomPrise();

    List<Room> roomList();

    Room getRoom(Integer id);

    //====================Maintenance=========================
    Maintenance addMaintenance(String name, Integer prise);

    Maintenance deleteMaintenance(Integer id);

    Maintenance getMaintenance(Integer id);

    List<Maintenance> maintenanceList();

    Maintenance changeMaintenance(Integer id, Integer price, String name);

    //====================Guest=========================
    Guest addGuest(String lastName);

    Guest deleteGuest(Integer id);

    List<Guest> guestList();

    Guest getGuest(Integer id);

    Guest changeGuest(Integer id,String lastname);

    //====================History=========================
    History checkInGuest(Integer roomId, Integer guestId, LocalDate checkInDate, LocalDate checkOut);

    History evictGuest(Integer id);

    History addServicesToGuest(Integer idHistory, Integer idMaintenance);

    List<History> getSortedGuestByLastName();

    List<History> getHistoriesSortedByCheckOutDate();

    int numberGuest();

    List<Room> showEmptyRoomsOnDate(LocalDate date);

    History getHistory(Integer id);

    List<Maintenance> maintenanceGuest(Integer id);

    int guestPaymentAmount(Integer id);

    List<History> getThreeLastGuest(Integer roomId);

    List<History> historyList();


}
