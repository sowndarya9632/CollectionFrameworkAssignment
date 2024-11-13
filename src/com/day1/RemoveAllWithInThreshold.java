package com.day1;

import java.util.TreeSet;

public class RemoveAllWithInThreshold {
	public static void removeLessThan(TreeSet<Integer> set, int threshold) {
        // Using the higher method to find the first element >= threshold
        Integer element = set.higher(threshold);
        // If there's no element >= threshold, clear the set
        if (element == null) {
            set.clear();
            return;
        }
        // Remove all elements less than the threshold
        set.headSet(threshold, false).clear();
        //headset==>remove less than threshold
        //false==> it dont include that threshold
        //clear ==>it remove element from original element
    }     


	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);

		System.out.println("Original TreeSet: " + treeSet);

		int threshold = 3;
		removeLessThan(treeSet, threshold);

		System.out.println("TreeSet after removing elements less than " + threshold + ": " + treeSet);
	}

	
}
