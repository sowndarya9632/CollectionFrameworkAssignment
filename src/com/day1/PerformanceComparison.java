package com.day1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PerformanceComparison {
	private static final int DATA_SIZE = 100000; // Change this for larger datasets

	public static void main(String[] args) {
		compareSets();
	}

	private static void compareSets() {
		// Initialize sets
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		// Measure performance for each set
		measureSetPerformance("HashSet", hashSet);
		measureSetPerformance("LinkedHashSet", linkedHashSet);
		measureSetPerformance("TreeSet", treeSet);
	}

	private static void measureSetPerformance(String setType, Set<Integer> set) {
		long startTime, endTime;

		// Add operation
		startTime = System.nanoTime();
		for (int i = 0; i < DATA_SIZE; i++) {
			set.add(i);
		}
		endTime = System.nanoTime();
		System.out.println(setType + " - Add: " + (endTime - startTime) + " ns");

		// Contains operation
		startTime = System.nanoTime();
		for (int i = 0; i < DATA_SIZE; i++) {
			set.contains(i);
		}
		endTime = System.nanoTime();
		System.out.println(setType + " - Contains: " + (endTime - startTime) + " ns");

		// Remove operation
		startTime = System.nanoTime();
		for (int i = 0; i < DATA_SIZE; i++) {
			set.remove(i);
		}
		endTime = System.nanoTime();
		System.out.println(setType + " - Remove: " + (endTime - startTime) + " ns");
	}
}
