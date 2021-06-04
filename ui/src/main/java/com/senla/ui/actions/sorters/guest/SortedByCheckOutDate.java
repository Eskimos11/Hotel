package com.senla.ui.actions.sorters.guest;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;


import java.util.List;

public class SortedByCheckOutDate implements IAction {

    public HotelFacade facade;

    public SortedByCheckOutDate(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        List<History> histories = facade.getHistoriesSortedByCheckOutDate();
        Printer.printList(histories);
    }
}