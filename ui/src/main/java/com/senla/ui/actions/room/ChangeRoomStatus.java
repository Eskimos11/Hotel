package com.senla.ui.actions.room;


import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.model.RoomStatus;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class  ChangeRoomStatus implements IAction {


    public HotelFacade facade;

    public ChangeRoomStatus(HotelFacade facade) {
        this.facade = facade;
    }

    RoomStatus integerToStatus(Integer input) {
        RoomStatus roomStatus = null;

        switch (input) {
            case 1:
                roomStatus = RoomStatus.EMPTY;
                break;
            case 2:
                roomStatus = RoomStatus.SERVICED;
                break;
            default:
                Printer.print("Wrong input. Please, input a number from 1 to 2.");
        }
        return roomStatus;
    }
    @Override
    public void execute() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the room ID");
            Integer id = scanner.nextInt();
            System.out.println("Input the Room status, where 1 = EMPTY, 2 = SERVICED.");
            Integer st = scanner.nextInt();
            RoomStatus status= integerToStatus(st);
            Room room = facade.changeRoomStatus(id,status);
            System.out.println(room);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}

