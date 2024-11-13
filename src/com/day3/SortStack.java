  package com.day3;

import java.util.Stack;

public class SortStack {

	// Function to sort the stack
	public static void sort(Stack<Integer> stack) {
		// Base case: if the stack is empty or has one element
		if (stack.isEmpty()) {
			return;
		}

		// Step 1: Pop the top element
		int top = stack.pop();

		// Step 2: Recursively sort the remaining stack
		sort(stack);

		// Step 3: Insert the popped element in sorted order
		insertInSortedOrder(stack, top);
	}

	// Helper function to insert an element in sorted order
	private static void insertInSortedOrder(Stack<Integer> stack, int item) {
		// Base case: if the stack is empty or the item is greater than the top
		if (stack.isEmpty() || item > stack.peek()) {
			stack.push(item);
			return;
		}

		// Step 1: Pop the top element
		int temp = stack.pop();

		// Step 2: Recursively insert the item in the remaining stack
		insertInSortedOrder(stack, item);

		// Step 3: Push the popped element back to the stack
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);

		System.out.println("Original Stack: " + stack);

		sort(stack);

		System.out.println("Sorted Stack: " + stack);
	}
}
