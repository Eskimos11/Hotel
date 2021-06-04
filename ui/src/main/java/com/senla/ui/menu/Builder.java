package com.senla.ui.menu;



import com.senla.facade.HotelFacade;
import com.senla.ui.actions.guest.*;
import com.senla.ui.actions.history.*;
import com.senla.ui.actions.maintenance.AddMaintenanceActions;
import com.senla.ui.actions.maintenance.ChangeMaintenanceActions;
import com.senla.ui.actions.maintenance.DeleteMaintenanceActions;
import com.senla.ui.actions.maintenance.MaintenanceListActions;
import com.senla.ui.actions.room.*;
import com.senla.ui.actions.sorters.guest.SortedByCheckOutDate;
import com.senla.ui.actions.sorters.guest.SortedGuestsByLastName;
import com.senla.ui.actions.sorters.room.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class Builder {

    private HotelFacade facade;
    private Menu rootMenu;

    @Autowired
    public Builder(HotelFacade facade, Menu rootMenu) {
        this.facade = facade;
        this.rootMenu = rootMenu;
    }


    public void buildMenu(){
        rootMenu = new Menu();
        rootMenu.setName("Общее меню");
        rootMenu.addMenuItem(new MenuItem("Room Menu", () ->{ }, createRoomMenu()));
        rootMenu.addMenuItem(new MenuItem("Guest Menu", ()-> { },createGuestMenu ()));
        rootMenu.addMenuItem(new MenuItem("Service Menu", ()-> { }, createServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("History Menu", ()-> { }, createHistoryMenu()));
        rootMenu.addMenuItem(new MenuItem("Sorters Menu", () ->{ }, createSorters()));

    }


    public Menu getRootMenu() {
        return rootMenu;
    }


    private Menu createRoomMenu(){
        var roomMenu = new Menu();
        roomMenu.setName("Room Menu");
        roomMenu.addMenuItem(new MenuItem("Add room", new AddRoomActions(facade) , roomMenu));
        roomMenu.addMenuItem(new MenuItem("Show room", new PrintRoomsAction(facade) , roomMenu));

//        if(roomService.isRoomStatus()){
//            roomMenu.addMenuItem(new MenuItem("Change room status ", new ChangeRoomStatus(facade), roomMenu));
//        }

        roomMenu.addMenuItem(new MenuItem("Change room price ", new ChangeRoomPrise(facade), roomMenu));
        roomMenu.addMenuItem(new MenuItem("List of rooms ", new RoomListActions(facade), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Number of free rooms", new EmptyRoomNumberActions(facade), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Back ",()-> {}, rootMenu));
        return roomMenu;
    }

    private Menu createSorters(){
        var sortersMenu = new Menu();
        sortersMenu.setName("Sorters");
        sortersMenu.addMenuItem(new MenuItem("Sort rooms by price", new ByPrise(facade) , sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort rooms by capacity"  ,new ByCapacity(facade) , sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort rooms by starts", new ByStars(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort empty rooms by price ", new EmptyByPrise(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort empty rooms by capacity ", new EmptyByCapacity(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort empty rooms by stars ", new EmptyByStars(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort guests by name ", new SortedGuestsByLastName(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Sort rooms by release date ", new SortedByCheckOutDate(facade), sortersMenu));
        sortersMenu.addMenuItem(new MenuItem("Back",()-> {}, rootMenu));
        return sortersMenu;
    }
    private Menu createServiceMenu(){
        var serviceMenu = new Menu();
        serviceMenu.setName("Service Menu");
        serviceMenu.addMenuItem(new MenuItem("Add service" , new AddMaintenanceActions(facade),serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Delete service" , new DeleteMaintenanceActions(facade),serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Change the Service", new ChangeMaintenanceActions(facade),serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("List of services", new MaintenanceListActions(facade),serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Back", ()-> {}, rootMenu ));
        return serviceMenu;
    }

    private Menu createGuestMenu(){
        var guestMenu = new Menu();
        guestMenu.setName("Guest Menu");
        guestMenu.addMenuItem(new MenuItem("Add guest", new AddGuestActions(facade),guestMenu));
        guestMenu.addMenuItem(new MenuItem("Remove from guest list", new DeleteGuestActions(facade),guestMenu));
        guestMenu.addMenuItem(new MenuItem("Guest list", new GuestListActions(facade),guestMenu));
        guestMenu.addMenuItem(new MenuItem("Get Guest", new GuestSearch(facade),guestMenu));
        guestMenu.addMenuItem(new MenuItem("Change the last name of the guest ", new ChangeGuestActions(facade), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Back", ()-> {}, rootMenu ));
        return guestMenu;
    }

    private Menu createHistoryMenu(){
        var historyMenu = new Menu();
        historyMenu.setName("Заказ");
        historyMenu.addMenuItem(new MenuItem("Create order", new CheckInGuestActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Evict a guest", new EvictGuestActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Add service to guest", new AddServicesToGuestActions(facade),historyMenu));
        historyMenu.addMenuItem(new MenuItem("Find out the number of guests", new NumberGuestActions(facade) , historyMenu));
        historyMenu.addMenuItem(new MenuItem("Available numbers for the date", new EmptyRoomsOnDateActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("View order", new GetHistoryAction(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Bill guest", new GuestPaymentAmountActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("The last three visitors to the room", new ThreeLastGuestActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Order list", new HistoryListActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Guest services list", new MaintenanceGuestListActions(facade), historyMenu));
        historyMenu.addMenuItem(new MenuItem("Back", ()-> {}, rootMenu ));
        return historyMenu;
    }
}