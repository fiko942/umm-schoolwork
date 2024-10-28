package com.fiko942.moduatasksatu;

public class Employee {
    public String name;
    public int id;
    public double salary;
    public String departement;
    public static final double BONUS_RATE = 0.1;

    public Employee(String name, int id, double salary, String departement) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.departement = departement;
    }

    public void setName(String name) {this.name = name;}
    public void setId(int id) {this.id = id;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setDepartemen(String departemen) {this.departement = departemen;}
    public void applyBonus(double bonus) {salary += calculateBonus(bonus);}

    /**
     * Prints the details of the employee including employee ID, name, salary, and departement.
     */
    public void printDetails() {
        System.out.printf("Employee ID: %d%n", id);
        System.out.printf("Name: %s%n", name);
        System.out.printf("Salary: %.2f%n", salary);
        System.out.printf("Departement: %s%n", departement);
    }

    /**
     * Applies a standard bonus to the employee's salary based on a predefined bonus rate.
     * The new salary after the bonus is applied is printed to the console.
     */
    public void applyBonus() {
        this.salary += this.salary * Employee.BONUS_RATE;
        System.out.println("Bonus applied! New salary: " + this.salary);
    }


    /**
     * Updates the departement of the employee to the given value and prints the
     * updated value to the console.
     * @param newDepartement the new departement value
     */
    public void updateDepartement(String newDepartement) {
        this.departement = newDepartement;
        System.out.println("Departement updated to: " + this.departement);
    }

    public double calculateBonus(double bonus) { return bonus; }
}