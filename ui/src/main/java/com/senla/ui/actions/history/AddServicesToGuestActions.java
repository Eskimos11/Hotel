package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;

@Log4j
public class AddServicesToGuestActions implements IAction {

    public HotelFacade facade;

    public AddServicesToGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your order number");
            Integer idHistory = scanner.nextInt();
            System.out.println("Enter Service Id");
            Integer idMaintenance = scanner.nextInt();
            History history = facade.addServicesToGuest(idHistory, idMaintenance);
            System.out.println(history);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
