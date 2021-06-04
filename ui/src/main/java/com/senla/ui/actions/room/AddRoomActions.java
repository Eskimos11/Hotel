package com.senla.ui.actions.room;


import com.senla.facade.HotelFacade;
import com.senla.model.Room;
import com.senla.model.RoomStars;
import com.senla.model.RoomStatus;
import com.senla.ui.actions.IAction;
import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class AddRoomActions implements IAction {


    public HotelFacade facade;

    public AddRoomActions(HotelFacade facade) {
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
    RoomStars integerToStar(Integer input) {
        RoomStars roomStar = null;
        switch (input) {
            case 1:
                roomStar = RoomStars.STANDARD;
                break;
            case 2:
                roomStar = RoomStars.JUNIOR_SUITE;
                break;
            case 3:
                roomStar = RoomStars.LUX;
                break;
            case 4:
                roomStar = RoomStars.PRESIDENT_LUX;
                break;
            default:
                Printer.print("Wrong input. Please, input a number from 1 to 4.");
        }
        return roomStar;
    }

    @Override
    public void execute() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the room number");
            Integer param1 = scanner.nextInt();
            System.out.println("Enter the price per room");
            Integer param2 = scanner.nextInt();
            System.out.println("Enter the number of rooms");
            Integer param3= scanner.nextInt();
            System.out.println("Input the Room status, where 1 = EMPTY, 2 = SERVICED.");
            Integer status = scanner.nextInt();
            RoomStatus param4= integerToStatus(status);

            System.out.println("Input the Room rate from 1 to 4..");
            Integer stars= scanner.nextInt();
            RoomStars param5 = integerToStar(stars);
            Room room = facade.addRoom(param1,param2,param3,param4,param5);
            System.out.println(room);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}


