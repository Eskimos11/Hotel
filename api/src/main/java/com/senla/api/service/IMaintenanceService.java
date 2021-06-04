package com.senla.api.service;



import com.senla.model.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance addMaintenance(String name, Integer prise);

    Maintenance deleteMaintenance(Integer id);

    Maintenance changeMaintenance(Integer id, Integer price, String name);

    Maintenance getMaintenance(Integer id);

    List<Maintenance> maintenanceList();

}

