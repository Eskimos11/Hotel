package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;

import java.util.Scanner;
@Log4j
public class GuestPaymentAmountActions implements IAction {

    public HotelFacade facade;

    public GuestPaymentAmountActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order Id");
        Integer id = scanner.nextInt();
        Integer history = facade.guestPaymentAmount(id);
        System.out.println( history + "$");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}