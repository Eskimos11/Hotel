package com.senla.ui.actions.guest;



import com.senla.facade.HotelFacade;
import com.senla.model.Guest;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;

import java.util.Scanner;
@Log4j
public class GuestSearch implements IAction {

    public HotelFacade facade;

    public GuestSearch(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter id guest");
            Integer id = scanner.nextInt();
            Guest guest = facade.getGuest(id);
            System.out.println(guest);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}