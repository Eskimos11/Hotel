package com.senla.ui.actions.maintenance;

import com.senla.facade.HotelFacade;
import com.senla.model.Maintenance;
import com.senla.ui.actions.IAction;
import lombok.extern.log4j.Log4j;


import java.util.Scanner;
@Log4j
public class DeleteMaintenanceActions  implements IAction {


    public HotelFacade facade;

    public DeleteMaintenanceActions(HotelFacade facade) {
        this.facade = facade;
    }
    @Override
    public void execute() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the service I");
        Integer id = scanner.nextInt();
        Maintenance maintenance = facade.deleteMaintenance(id);
        System.out.println("Service deleted ");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}