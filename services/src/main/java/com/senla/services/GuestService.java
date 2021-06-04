package com.senla.services;


import com.senla.api.dao.IGuestDao;
import com.senla.api.service.IGuestService;


import com.senla.exceptions.DaoExceptions;
import com.senla.exceptions.ServiceExceptions;
import com.senla.model.Guest;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
public class GuestService implements IGuestService {

    private final IGuestDao guestDao;

    public GuestService(IGuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Transactional
    @Override
    public Guest addGuest(String lastName) {
        try {
            Guest guest = new Guest();
            guest.setLastname(lastName);
            guestDao.save(guest);
            return guest;
        } catch (DaoExceptions e) {
            log.error("addGuest failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }

    @Transactional
    @Override
    public Guest deleteGuest(Integer id) {
        try {
            Guest guest = guestDao.getById(id);
            guestDao.delete(guest);
            return guest;
        } catch (DaoExceptions e) {
            log.error("deleteGuest failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);

        }
    }

    @Override
    public Guest getGuest(Integer id) {
        Guest guest = guestDao.getById(id);
        return guest;
    }

    @Override
    @Transactional
    public Guest changeGuest(Integer id, String lastname) {
        try {
            Guest guest = guestDao.getById(id);
            guest.setLastname(lastname);
            guestDao.update(guest);
            return guest;
        } catch (Exception e) {
            log.error("changeGuest failed", e);
            throw new ServiceExceptions("deleteGuest failed", e);
        }
    }

    @Override
    public List<Guest> guestList() {
        List<Guest> guestList = guestDao.getAll();
        return guestList;
    }
}

