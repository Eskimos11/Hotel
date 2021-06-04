package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;

import java.util.Scanner;
@Log4j
public class EvictGuestActions implements IAction {

    public HotelFacade facade;

    public EvictGuestActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Order Id");
            Integer id = scanner.nextInt();
            History history = facade.evictGuest(id);
            System.out.println(history);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}