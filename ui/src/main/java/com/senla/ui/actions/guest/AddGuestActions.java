package com.senla.ui.actions.guest;


import com.senla.facade.HotelFacade;
import com.senla.model.Guest;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;


import java.util.Scanner;

@Log4j
@Component
public class AddGuestActions implements IAction {


    public HotelFacade facade;

    public AddGuestActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter last name");
            String name = scanner.next();
            Guest guest = facade.addGuest(name);
            System.out.println(guest);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);

        }
    }
}