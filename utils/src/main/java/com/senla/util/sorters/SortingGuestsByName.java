package com.senla.util.sorters;


import com.senla.model.History;

import java.util.Comparator;

public class SortingGuestsByName implements Comparator<History> {

    @Override
    public int compare(History o1, History o2) {
       return   o1.getGuest().getLastname().compareTo(o2.getGuest().getLastname());

    }
}