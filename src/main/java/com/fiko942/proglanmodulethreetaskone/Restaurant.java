package com.fiko942.proglanmodulethreetaskone;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void showMenu() {
        System.out.println("=== Menu Restoran ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public MenuItem getMenuItem(int index) {
        return menu.get(index);
    }
}
