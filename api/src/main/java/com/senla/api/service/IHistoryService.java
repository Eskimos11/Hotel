package com.senla.api.service;



import com.senla.model.History;
import com.senla.model.Maintenance;
import com.senla.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IHistoryService {


    List<Room> showEmptyRoomsOnDate(LocalDate date);

    History checkInGuest(Integer roomId, Integer guestId , LocalDate checkInDate, LocalDate checkOutDate);

    History evictGuest(Integer historyId);

    History getHistory(Integer historyId);

    List<History> guestList();

    int numberOfGuests();

    int getDaysBetweenDate(LocalDate start, LocalDate end);

    History addServicesToGuest(Integer historyId, Integer maintenanceId );

    int guestPaymentAmount(Integer historyId);

    List<History> getThreeLastGuest(Integer roomId );

    List<History> getSortedGuestsByLastName();

    List<History> historiesSortedByCheckOutDate();

    List<History> getAllHistoryId();

    List<Maintenance> getGuestMaintenanceSortByPrise(Integer historyId);

    List<Maintenance> getListMaintenanceGuest(Integer historyId);

    List<History> historyList();

}
