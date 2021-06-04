package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.ui.actions.IAction;

public class NumberGuestActions implements IAction {


    public HotelFacade facade;

    public NumberGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        int number = facade.numberGuest();
        System.out.println("Number of guests - " + number);
    }
}
