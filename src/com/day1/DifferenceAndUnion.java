package com.day1;

import java.util.Set;
import java.util.TreeSet;

public class DifferenceAndUnion {
	public static Set<PersonClass> union(Set<PersonClass> set1, Set<PersonClass> set2) {
		Set<PersonClass> result = new TreeSet<>(set1);
		result.addAll(set2);
		return result;
	}

	public static Set<PersonClass> difference(Set<PersonClass> set1, Set<PersonClass> set2) {
		Set<PersonClass> result = new TreeSet<>(set1);
		result.removeAll(set2);
		return result;
	}

	public static void main(String[] args) {
		Set<PersonClass> set1 = new TreeSet<>();
		set1.add(new PersonClass("Alice", 30));
		set1.add(new PersonClass("Bob", 25));

		Set<PersonClass> set2 = new TreeSet<>();
		set2.add(new PersonClass("Bob", 25));
		set2.add(new PersonClass("Charlie", 35));

		Set<PersonClass> unionSet = union(set1, set2);
		Set<PersonClass> differenceSet = difference(set1, set2);

		System.out.println("Union: " + unionSet);
		System.out.println("Difference: " + differenceSet);
	}

}
