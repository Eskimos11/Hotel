package com.senla.ui.menu;

import com.senla.ui.actions.IAction;

public class MenuItem {

    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }
    public MenuItem(String title, IAction action) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public void doAction(){
        action.execute();
    }

    public Menu getNextMenu(){
        return nextMenu;
    }
}