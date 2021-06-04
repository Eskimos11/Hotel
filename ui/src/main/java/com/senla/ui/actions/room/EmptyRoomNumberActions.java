package com.senla.ui.actions.room;

import com.senla.facade.HotelFacade;
import com.senla.ui.actions.IAction;

public class EmptyRoomNumberActions implements IAction {

    public HotelFacade facade;

    public EmptyRoomNumberActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        int emptyNumberRoom = facade.getEmptyRoomNumber();
        System.out.println("Number of free rooms ---> " + emptyNumberRoom);
    }
}
