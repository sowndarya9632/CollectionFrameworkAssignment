package com.day6;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
	private TreeMap<String, String> contacts;//1.string==>name   2.string==>phonenumber

	public PhoneBook() {
		contacts = new TreeMap<>();
	}

	// Add a contact
	public void addContact(String name, String phoneNumber) {
		contacts.put(name, phoneNumber);
		System.out.println("Contact added: " + name + " - " + phoneNumber);
	}

	// Remove a contact
	public void removeContact(String name) {
		if (contacts.remove(name) != null) {
			System.out.println("Contact removed: " + name);
		} else {
			System.out.println("Contact not found: " + name);
		}
	}

	// Search for a contact
	public void searchContact(String name) {
		String phoneNumber = contacts.get(name);
		if (phoneNumber != null) {
			System.out.println("Found contact: " + name + " - " + phoneNumber);
		} else {
			System.out.println("Contact not found: " + name);
		}
	}

	// Display all contacts
	public void displayContacts() {
		if (contacts.isEmpty()) {
			System.out.println("Phone book is empty.");
		} else {
			System.out.println("Phone Book Contacts:");
			for (Map.Entry<String, String> entry : contacts.entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		Scanner scanner = new Scanner(System.in);
		String command;

		System.out.println("Phone Book Commands: add, remove, search, display, exit");

		while (true) {
			System.out.print("Enter command: ");
			command = scanner.nextLine();

			if (command.equalsIgnoreCase("exit")) {
				break;
			}

			switch (command.toLowerCase()) {
			case "add":
				System.out.print("Enter name: ");
				String nameToAdd = scanner.nextLine();
				System.out.print("Enter phone number: ");
				String numberToAdd = scanner.nextLine();
				phoneBook.addContact(nameToAdd, numberToAdd);
				break;

			case "remove":
				System.out.print("Enter name to remove: ");
				String nameToRemove = scanner.nextLine();
				phoneBook.removeContact(nameToRemove);
				break;

			case "search":
				System.out.print("Enter name to search: ");
				String nameToSearch = scanner.nextLine();
				phoneBook.searchContact(nameToSearch);
				break;

			case "display":
				phoneBook.displayContacts();
				break;

			default:
				System.out.println("Unknown command. Please try again.");
			}
		}

		scanner.close();
	}
}
