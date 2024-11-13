package com.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class MaintainInsertion {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        List<String> inputList = new ArrayList<>();
	        
	        System.out.println("Enter strings (type 'done' to finish):");
	        
	        while (true) {
	            String input = scanner.next();
	            if (input.equalsIgnoreCase("done")) {
	                break;
	            }
	            inputList.add(input);
	        }
	        
	        // Getting the LinkedHashSet from the input list
	        LinkedHashSet<String> resultSet = removeDuplicates(inputList);
	        
	        // Printing the output
	        System.out.println("Unique strings (in order of entry): " + resultSet);
	        
	        scanner.close();
	    }

	    public static LinkedHashSet<String> removeDuplicates(List<String> list) {
	        // Create a LinkedHashSet to maintain insertion order and remove duplicates
	        return new LinkedHashSet<>(list);
	}

}
