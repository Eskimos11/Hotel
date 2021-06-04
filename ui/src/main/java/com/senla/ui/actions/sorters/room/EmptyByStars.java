package com.senla.ui.actions.sorters.room;

import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;


import java.util.List;

public class EmptyByStars implements IAction {

    public HotelFacade facade;

    public EmptyByStars(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {

        List<Room> rooms = facade.getSortEmptyRoomsByStars();
        Printer.printList(rooms);

    }
}