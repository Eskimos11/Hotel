package com.senla.ui.actions.maintenance;

import com.senla.facade.HotelFacade;
import com.senla.model.Maintenance;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class ChangeMaintenanceActions implements IAction {

    public HotelFacade facade;

    public ChangeMaintenanceActions(HotelFacade facade) {
        this.facade = facade;
    }

    @Override
    public void execute() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the service ID");
        Integer id = scanner.nextInt();
        System.out.println("Enter a new name for the service");
        String name = scanner.next();
        System.out.println("Enter a new price for the service");
        Integer price = scanner.nextInt();

        Maintenance maintenance = facade.changeMaintenance(id,price,name);
        System.out.println(maintenance);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}
