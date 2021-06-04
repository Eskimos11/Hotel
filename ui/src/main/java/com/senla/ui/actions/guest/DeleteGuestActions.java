package com.senla.ui.actions.guest;

import com.senla.facade.HotelFacade;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class DeleteGuestActions implements IAction {

    public HotelFacade facade;

    public DeleteGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest ID ");
        Integer id = scanner.nextInt();
        facade.deleteGuest(id);
        System.out.println("Guest removed from the list");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}