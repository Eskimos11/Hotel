package com.senla.ui.menu;



import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder,Navigator navigator) {
        this.builder = builder;
        builder.buildMenu();
        this.navigator = navigator;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index = -1;
        while (!index.equals(0)) {
            index = scanner.nextInt();
            if (index == 0) {
                break;
            }
            navigator.navigate(index);
            navigator.printMenu();
        }
    }
}