package com.senla.ui.actions.sorters.room;

import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;


import java.util.List;

public class EmptyByCapacity implements IAction {

    public HotelFacade facade;

    public EmptyByCapacity(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        List<Room> rooms = facade.getSortEmptyRoomsByCapacity();
        Printer.printList(rooms);
    }
}
