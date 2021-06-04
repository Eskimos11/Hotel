package com.senla.ui.actions.room;

import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class ChangeRoomPrise implements IAction {


    public HotelFacade facade;

    public ChangeRoomPrise(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the room Id");
            Integer id = scanner.nextInt();
            System.out.println("Enter a new price per room");
            Integer price = scanner.nextInt();
            Room room = facade.changePriceOnRoom(id,price);
            System.out.println(room);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
