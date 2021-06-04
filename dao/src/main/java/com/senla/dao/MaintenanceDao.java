package com.senla.dao;



import com.senla.api.dao.IMaintenanceDao;
import com.senla.model.Maintenance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class MaintenanceDao extends AbstractDao<Maintenance> implements IMaintenanceDao {

    @Override
    public void saveAll(List<Maintenance> entity) {

    }

    @Override
    protected Class<Maintenance> getClazz() {
        return Maintenance.class;
    }
}
