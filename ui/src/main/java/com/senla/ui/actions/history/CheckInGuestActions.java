package com.senla.ui.actions.history;

import com.senla.facade.HotelFacade;
import com.senla.model.History;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.util.Scanner;
@Log4j
public class CheckInGuestActions implements IAction {

    public HotelFacade facade;

    public CheckInGuestActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the room ID");
        Integer idRoom = scanner.nextInt();
        System.out.println("Enter Guest Id");
        Integer idGuest= scanner.nextInt();
        System.out.println("Enter the check-in date " + "Example 2021-03-20" );
        LocalDate checkInDate = LocalDate.parse(scanner.next());
        System.out.println("Enter check out date " + "Example 2021-03-25");
        LocalDate checkoutDate = LocalDate.parse(scanner.next());
        History history = facade.checkInGuest(idRoom,idGuest,checkInDate,checkoutDate);
        System.out.println(history);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
