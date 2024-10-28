package com.fiko942.moduatasksatu;

public class Main {
    
    /**
     * Main entry point for the application.
     * Creates an employee, applies a bonus to them, and prints their details.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 12345, 5000, "Engineering");
        emp.applyBonus(500);
        emp.printDetails();
    }
}
