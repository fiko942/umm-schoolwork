package com.fiko942.moduatasksatu;

public class Project {
    public String projectName;
    public String projectDeadline;
    public Employee projectLeader;
    public double budget;

    public Project(String projectName, String projectDeadline, Employee projectLeader, double budget) {
        this.projectName = projectName;
        this.projectDeadline = projectDeadline;
        this.projectLeader = projectLeader;
        this.budget = budget;
    }

    /**
     * Prints the details of the project including project name, deadline, and budget.
     * Also calls the printDetails method of the project leader to print their details.
     */
    public void printDetails() {
        System.out.printf("Project Name: %s%n", projectName);
        System.out.printf("Project Deadline: %s%n", projectDeadline);
        System.out.printf("Budget: %.2f%n", budget);
        projectLeader.printDetails();
    }


    /**
     * Updates the budget of the project to the given value and prints the
     * updated value to the console.
     * @param budget the new budget value
     */
    public void updateBudget(double budget) {
        this.budget = budget;
        System.out.println("Budget updated: " + this.budget);
    }
}


class Client {
    public String clientName;
    public String clientEmail;
    public Project project;

    public Client(String name, String email, Project project) {
        this.clientName = name;
        this.clientEmail = email;
        this.project = project;
    }

    /**
     * Prints the details of the client including client name, email, and project details.
     * Project details include project name, deadline, budget, and project leader details.
     */
    public void printClientDetails() {
        System.out.println("Client Name: " + clientName);
        System.out.println("Client Email: " + clientEmail);
        project.printDetails();
    }
}

class MainApp {
    /**
     * Main entry point for the application.
     * Creates an employee, project, and client. Prints the client's details,
     * applies a bonus to the employee, updates the employee's department, and
     * updates the project's budget.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 12345, 75000, "Engineering");
        Project proj = new Project("AI Development", "2024-12-31", emp, 1000000);
        Client _client = new Client("Acme Corp", null, proj);
        _client.printClientDetails();
        emp.applyBonus();
        emp.updateDepartement("Research and Development");
        proj.updateBudget(12000000);
    }
}