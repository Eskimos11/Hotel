package com.senla.ui.actions.maintenance;


import com.senla.facade.HotelFacade;
import com.senla.model.Maintenance;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class AddMaintenanceActions implements IAction {

    public HotelFacade facade;

    public AddMaintenanceActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter service name");
            String param1 = scanner.next();
            System.out.println("Enter the price for the service");
            Integer param2 = scanner.nextInt();
            Maintenance maintenance = facade.addMaintenance(param1,param2);
            System.out.println(maintenance);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}