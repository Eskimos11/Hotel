package com.senla.api.service;

import com.senla.model.Guest;

import java.util.List;

public interface IGuestService {

    Guest addGuest(String lastName);

    List<Guest> guestList ();

    Guest deleteGuest(Integer id);

    Guest getGuest(Integer id);

    Guest changeGuest(Integer id,String lastname);

}
