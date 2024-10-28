package com.fiko942.proglanmodulethreetaskone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek restoran
        Restaurant restaurant = new Restaurant();

        // Menambahkan item menu
        restaurant.addMenuItem(new MenuItem("Nasi Goreng", 25000));
        restaurant.addMenuItem(new MenuItem("Mie Ayam", 20000));
        restaurant.addMenuItem(new MenuItem("Ayam Penyet", 30000));

        // Menampilkan menu
        restaurant.showMenu();

        // Membuat pesanan
        Order order = new Order();

        // Menginput item pesanan
        System.out.print("Masukkan nomor item yang ingin dipesan (pisahkan dengan spasi, ketik -1 untuk selesai): ");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == -1) {
                break;
            } else if (choice > 0 && choice <= restaurant.menu.size()) {
                order.addItem(restaurant.getMenuItem(choice - 1));
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        // Mencetak nota
        order.printReceipt();
        scanner.close();
    }
}