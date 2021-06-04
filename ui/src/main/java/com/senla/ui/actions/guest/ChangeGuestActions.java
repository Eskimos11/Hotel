package com.senla.ui.actions.guest;


import com.senla.exceptions.ServiceExceptions;
import com.senla.facade.HotelFacade;
import com.senla.model.Guest;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;

import java.util.Scanner;

@Log4j
public class ChangeGuestActions implements IAction {

    public HotelFacade facade;

    public ChangeGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() throws ServiceExceptions {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest ID");
        Integer id = scanner.nextInt();
        System.out.println("Enter guest lastname");
        String lastname = scanner.next();
        Guest guest = facade.changeGuest(id,lastname);
        System.out.println(guest);

    }
}