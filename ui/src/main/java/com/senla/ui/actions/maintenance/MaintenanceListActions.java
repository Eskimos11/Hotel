package com.senla.ui.actions.maintenance;

import com.senla.facade.HotelFacade;
import com.senla.model.Maintenance;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;


import java.util.List;

public class MaintenanceListActions implements IAction {

    public HotelFacade facade;

    public MaintenanceListActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
       List<Maintenance> maintenanceList = facade.maintenanceList();
        Printer.printList(maintenanceList);
    }
}
