package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.Maintenance;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;


import java.util.List;
import java.util.Scanner;
@Log4j
public class MaintenanceGuestListActions implements IAction {

    public HotelFacade facade;

    public MaintenanceGuestListActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order Id");
        Integer id = scanner.nextInt();
        List<Maintenance> maintenanceList = facade.maintenanceList();
        Printer.printList(maintenanceList);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}