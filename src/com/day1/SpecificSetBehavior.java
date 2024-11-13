package com.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SpecificSetBehavior {

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
	        
	        Map<String, Set<Integer>> sets = createSets(inputList);
	        
	        // Output results
	        System.out.println("HashSet: " + sets.get("HashSet"));
	        System.out.println("LinkedHashSet: " + sets.get("LinkedHashSet"));
	        System.out.println("TreeSet: " + sets.get("TreeSet"));
	        
	        scanner.close();
	    }

	    public static Map<String, Set<Integer>> createSets(List<Integer> list) {
	        Set<Integer> hashSet = new HashSet<>(list); // Unique elements, no specific order
	        Set<Integer> linkedHashSet = new LinkedHashSet<>(list); // Unique elements, insertion order
	        Set<Integer> treeSet = new TreeSet<>(list); // Unique elements, sorted order

	        Map<String, Set<Integer>> result = new HashMap<>();
	        result.put("HashSet", hashSet);
	        result.put("LinkedHashSet", linkedHashSet);
	        result.put("TreeSet", treeSet);
	        return result;
	}

}
