package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
@Log4j
public class EmptyRoomsOnDateActions  implements IAction {

    public HotelFacade facade;

    public EmptyRoomsOnDateActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the date " + "Example 2021-03-20");
            LocalDate date = LocalDate.parse(scanner.next());
            List<Room> roomList = facade.showEmptyRoomsOnDate(date);
            Printer.printList(roomList);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}