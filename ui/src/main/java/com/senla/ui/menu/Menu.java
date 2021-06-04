package com.senla.ui.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Menu {

    private String name;
    private List<MenuItem> menuItems = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        if(menuItems == null)
            menuItems = new ArrayList<>();

        return menuItems;
    }

    public void addMenuItem(MenuItem item){
        menuItems.add(item);
    }
}