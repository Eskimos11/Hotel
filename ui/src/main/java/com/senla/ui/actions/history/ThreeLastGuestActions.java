package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;


import java.util.List;
import java.util.Scanner;

@Log4j
public class ThreeLastGuestActions implements IAction {

    public HotelFacade facade;

    public ThreeLastGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the room ID");
        Integer roomId = scanner.nextInt();
        List<History> historyList = facade.getThreeLastGuest(roomId);
        Printer.printList(historyList);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
