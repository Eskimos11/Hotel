package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;


import java.util.List;

public class HistoryListActions implements IAction {

    public HotelFacade facade;

    public HistoryListActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
      List<History> historyList = facade.historyList();
      Printer.printList(historyList);

    }
}
