package com.day6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    private String name;
    private String id;
    private String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department;
    }
}

public class EmployeeRecords {
    private HashMap<String, Employee> employeeMap;

    public EmployeeRecords() {
        employeeMap = new HashMap<>();
    }

    // Add an employee
    public void addEmployee(String name, String id, String department) {
        Employee employee = new Employee(name, id, department);
        employeeMap.put(id, employee);
        System.out.println("Employee added: " + employee);
    }

    // Search for an employee by ID
    public void searchEmployeeById(String id) {
        Employee employee = employeeMap.get(id);
        if (employee != null) {
            System.out.println("Employee found: " + employee);
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    public static void main(String[] args) {
        EmployeeRecords records = new EmployeeRecords();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Employee Records Commands: add, search, exit");
        
        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    records.addEmployee(name, id, department);
                    break;

                case "search":
                    System.out.print("Enter ID to search: ");
                    String idToSearch = scanner.nextLine();
                    records.searchEmployeeById(idToSearch);
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }
}

