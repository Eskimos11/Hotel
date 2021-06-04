package com.senla.ui.actions.guest;

import com.senla.facade.HotelFacade;
import com.senla.model.Guest;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;

import java.util.List;


public class GuestListActions  implements IAction {

    public HotelFacade facade;

    public GuestListActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
      List<Guest> guestList = facade.guestList();
      Printer.printList(guestList);
    }

}