package com.senla.services;


import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.service.IMaintenanceService;
import com.senla.dao.GuestDao;
import com.senla.dao.MaintenanceDao;

import com.senla.exceptions.DaoExceptions;
import com.senla.exceptions.ServiceExceptions;
import com.senla.model.Maintenance;
import com.senla.util.IdGenerator;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.List;

@Log4j
@Service
public class MaintenanceService implements IMaintenanceService {


    private final MaintenanceDao maintenanceDao;

    public MaintenanceService(MaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }
    @Transactional
    @Override
    public Maintenance addMaintenance(String name, Integer prise) {
        try {
            Maintenance maintenance = new Maintenance(name,prise);
            maintenanceDao.save(maintenance);
            return maintenance;
        } catch (DaoExceptions e) {
            log.error("addMaintenance failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }
    @Transactional
    @Override
    public Maintenance deleteMaintenance(Integer id) {
        try {
            Maintenance maintenance = maintenanceDao.getById(id);
            maintenanceDao.delete(maintenance);
            return maintenance;
        } catch (DaoExceptions e) {
            log.error("deleteMaintenance failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }

    @Transactional
    @Override
    public Maintenance changeMaintenance(Integer id, Integer price, String name) {//изменить название
        try {
        Maintenance maintenance = maintenanceDao.getById(id);
        maintenance.setName(name);
        maintenance.setPrice(price);
        maintenanceDao.update(maintenance);
        return maintenance;
        } catch (DaoExceptions e) {
            log.error("changeMaintenance failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }


    @Override
    public Maintenance getMaintenance(Integer id) {
        try {
            Maintenance maintenance = maintenanceDao.getById(id);
            return maintenance;
        } catch (DaoExceptions e) {
            log.error("getMaintenance failed", e);
            throw new ServiceExceptions("getMaintenance failed", e);
        }
    }

    @Override
    public List<Maintenance> maintenanceList() {
        List<Maintenance> maintenanceList = maintenanceDao.getAll();
        return maintenanceList;
    }


}