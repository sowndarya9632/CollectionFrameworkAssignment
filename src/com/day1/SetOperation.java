package com.day1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperation {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);

		        // Create example sets
		        System.out.println("Enter elements for SetA (comma-separated):");
		        Set<Integer> setA = inputSet(scanner);

		        System.out.println("Enter elements for SetB (comma-separated):");
		        Set<Integer> setB = inputSet(scanner);

		        // Check if setA is a subset of setB
		        System.out.println("Is SetA a subset of SetB? " + isSubset(setA, setB));

		        // Test with LinkedHashSet
		        System.out.println("Enter elements for LinkedSetA (comma-separated):");
		        Set<Integer> linkedSetA = inputSet(scanner);

		        System.out.println("Enter elements for LinkedSetB (comma-separated):");
		        Set<Integer> linkedSetB = inputSet(scanner);
		        System.out.println("Is LinkedSetA a subset of LinkedSetB? " + isSubset(linkedSetA, linkedSetB));

		        // Test with TreeSet
		        System.out.println("Enter elements for TreeSetA (comma-separated):");
		        Set<Integer> treeSetA = inputSet(scanner);

		        System.out.println("Enter elements for TreeSetB (comma-separated):");
		        Set<Integer> treeSetB = inputSet(scanner);
		        System.out.println("Is TreeSetA a subset of TreeSetB? " + isSubset(treeSetA, treeSetB));

		        scanner.close();
		    }

		    public static  <T> boolean isSubset(Set<T> setA, Set<T> setB) {
		        return setB.containsAll(setA);
		    }

		    public static Set<Integer> inputSet(Scanner scanner) {
		        String input = scanner.nextLine();
		        Set<Integer> set = new HashSet<>();
		        String[] numbers = input.split(",");

		        for (String number : numbers) {
		            try {
		                set.add(Integer.parseInt(number)); 
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid input: " + number);
		            }
		        }
		        return set;
		    

	}

}
