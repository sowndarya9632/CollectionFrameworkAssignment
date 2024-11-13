package com.day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortHashMapByValues {
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("John", 32);
		hashMap.put("Alice", 27);
		hashMap.put("Bob", 35);
		hashMap.put("Emma", 25);

		System.out.println("Original HashMap:");
		printHashMap(hashMap);

		// Sort HashMap by values in ascending order
		//A LinkedHashMap is created to maintain the order of insertion after sorting.

		Map<String, Integer> sortedHashMapAsc = new LinkedHashMap<>();
		
		//The entries of hashMap are converted into a List for sorting.

		List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		}
		);
		for (Map.Entry<String, Integer> entry : list) {
			sortedHashMapAsc.put(entry.getKey(), entry.getValue());
		}
		System.out.println("\nSorted HashMap (Ascending):");
		System.out.println(sortedHashMapAsc);
		//printHashMap(sortedHashMapAsc);
	}
		
	// Method to print HashMap
	public static void printHashMap(Map<String, Integer> hashMap) {
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
