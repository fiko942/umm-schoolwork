package com.fiko942.proglanmodulethreetaskone;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("=== Nota Pemesanan Makanan ===");
        for (MenuItem item : items) {
            System.out.println(item);
        }
        System.out.println("---------------------------");
        System.out.printf("Total: Rp %.2f%n", calculateTotal());
    }
}
