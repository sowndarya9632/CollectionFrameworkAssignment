package com.day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Set;

public class IntersectionOfMultipleSet {
	public static Set<Integer> intersectSets(List<Set<Integer>> sets) {//list of set integer
		if (sets == null || sets.isEmpty()) {
			return new HashSet<>(); // Return an empty set if input is null or empty
		}

		// Start with the first set
		HashSet<Integer> intersection = new HashSet<>(sets.get(0));

		// Iterate through the remaining sets
		for (int i = 1; i < sets.size(); i++) {
			intersection.retainAll(sets.get(i)); // Retain same elements in current set
		}

		return intersection; // Return the final intersection
	}

	public static void main(String[] args) {
		// example of hashset
		Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3));
		Set<Integer> set2 = new HashSet<>(List.of(2, 3, 4));
		Set<Integer> set3 = new HashSet<>(List.of(3, 4, 5));

		List<Set<Integer>> listOfSets = List.of(set1, set2, set3);
		Set<Integer> intersection = intersectSets(listOfSets);
		System.out.println("Intersection (HashSet): " + intersection); // Output: [3]

		// Example with TreeSet
		Set<Integer> treeSet1 = new java.util.TreeSet<>(List.of(1, 2, 3));
		Set<Integer> treeSet2 = new java.util.TreeSet<>(List.of(2, 3, 4));
		Set<Integer> treeSet3 = new java.util.TreeSet<>(List.of(3, 4, 5));

		List<Set<Integer>> treeSetList = List.of(treeSet1, treeSet2, treeSet3);
		Set<Integer> treeSetIntersection = intersectSets(treeSetList);
		System.out.println("Intersection (TreeSet): " + treeSetIntersection); // Output: [3]

		// Example with LinkedHashSet
		Set<Integer> linkedHashSet1 = new java.util.LinkedHashSet<>(List.of(1, 2, 3));
		Set<Integer> linkedHashSet2 = new java.util.LinkedHashSet<>(List.of(2, 3, 4));
		Set<Integer> linkedHashSet3 = new java.util.LinkedHashSet<>(List.of(3, 4, 5));

		List<Set<Integer>> linkedHashSetList = List.of(linkedHashSet1, linkedHashSet2, linkedHashSet3);
		Set<Integer> linkedHashSetIntersection = intersectSets(linkedHashSetList);
		System.out.println("Intersection (LinkedHashSet): " + linkedHashSetIntersection);
	}

}
