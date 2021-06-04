package com.senla.util;

import java.util.List;


public class Printer {

    public static void print(String message) {
        System.out.println(message);
    }

    public static <T> void printList(List<T> name){
        for (int i=0; i<name.size(); i++){
            System.out.println(name.get(i));
        }
    }

}

