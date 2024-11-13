package com.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindFirstDuplicate {

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
		        Integer firstNonDuplicate = findFirstNonDuplicate(inputList);
		        
		        // Printing the output
		        System.out.println("First non-duplicate element: " + firstNonDuplicate);
	}
	 public static Integer findFirstNonDuplicate(List<Integer> list) {
	        Set<Integer> seen = new LinkedHashSet<>(); //add non duplicate
	        Set<Integer> duplicates = new HashSet<>(); // add duplicate

	        // First pass: identify duplicates and non-duplicates
	        for (Integer num : list) {
	            if (!seen.add(num)) {// add elements to seen if already present i.e 
	                duplicates.add(num);  //then add to duplicates.usually already first
	                                       ///it show false but then i want add dulpicates i.e(!)
	            }
	        }

	        // Second pass: find the first non-duplicate
	        for (Integer num : seen) {// take the number from non duplicate seen
	            if (!duplicates.contains(num)) {// then if num is not in duplicate set it return that
	                return num; // Return the first non-duplicate element
	            }
	        }

	        // Return null if no non-duplicate found
	        return null;
	    }
	 /* int[] frequency = new int[256];  // Array to count occurrences of each character

        // Step 1: Traverse the string to count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            frequency[c]++;  // Increment the count of the character
        }

        // Step 2: Traverse the string again to find the first character with a frequency of 1
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (frequency[c] == 1) {
                return c;  // Return the first non-duplicate character
            }
        }*/
	
}

 