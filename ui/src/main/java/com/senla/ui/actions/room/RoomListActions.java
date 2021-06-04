package com.senla.ui.actions.room;

import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;

import java.util.List;


public class RoomListActions implements IAction {

    public HotelFacade facade;

    public RoomListActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
      List<Room> roomList = facade.roomList();
      Printer.printList(roomList);
    }
}
