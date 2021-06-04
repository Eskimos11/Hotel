package com.senla.dao;




import com.senla.api.dao.IGuestDao;
import com.senla.model.Guest;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;


@Repository
public class GuestDao extends AbstractDao<Guest> implements IGuestDao {

    @Override
    protected Class<Guest> getClazz(){
        return Guest.class;
    }

    @Override
    public void saveAll(List<Guest> entity) {

    }

}



