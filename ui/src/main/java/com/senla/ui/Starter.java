package com.senla.ui;

import com.senla.api.IFacade;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IRoomService;
import com.senla.configuration.ContextConfiguration;
import com.senla.facade.HotelFacade;
import com.senla.model.Guest;
import com.senla.model.History;
import com.senla.model.RoomStars;

import com.senla.ui.menu.MenuController;
import com.senla.util.Printer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Starter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
//        IFacade facade = context.getBean("hotelFacade", IFacade.class);
//        facade.getGuest(43);
//        facade.checkInGuest(41,40,  LocalDate.parse("2021-03-20"),LocalDate.parse("2021-03-25"));
//        facade.addServicesToGuest(42,24);
//
//        Printer.printList(guestList);
//        IGuestService guestService = context.getBean("guestService", IGuestService.class);
//        System.out.println( facade.getGuest(2));
//        System.out.println(guestService.getGuest(2));
//        guestService.getGuest(2);
//        facade.getGuest(2);
//        System.out.println( guestService.getGuest(2));

        MenuController menuController = context.getBean("menuController", MenuController.class);
        menuController.run();
        context.close();
    }
}


