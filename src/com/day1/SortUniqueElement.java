package com.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SortUniqueElement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputList = new ArrayList<>();

		System.out.println("Enter integers (type 'done' to finish):");

		while (true) {
			if (scanner.hasNextInt()) {
				inputList.add(scanner.nextInt());
			} else if (scanner.next().equalsIgnoreCase("done")) {
				break;
			} else {
				System.out.println("Please enter a valid integer or 'done' to finish.");
			}
		}
		  TreeSet<Integer> resultSet = UniqueElements(inputList);
        
        // Printing the output
        System.out.println("Unique strings (in order of entry): " + resultSet);
        
        scanner.close();
    }

    public static TreeSet<Integer> UniqueElements(List<Integer> list) {
        // Create a LinkedHashSet to maintain insertion order and remove duplicates
        return new TreeSet<>(list);
}
		
	}


