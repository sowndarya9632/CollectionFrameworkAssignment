package com.day3;

import java.util.Stack;

public class ReverseStack {

	// Function to reverse the stack
	public static void reverse(Stack<Integer> stack) {
		// Base case: if the stack is empty
		if (stack.isEmpty()) {
			return;
		}

		// Step 1: Pop the top element
		int top = stack.pop();

		// Step 2: Reverse the remaining stack
		reverse(stack);

		// Step 3: Insert the popped element at the bottom
		insertAtBottom(stack, top);
	}

	// Helper function to insert an element at the bottom of the stack
	private static void insertAtBottom(Stack<Integer> stack, int item) {
		// Base case: if the stack is empty, push the item
		if (stack.isEmpty()) {
			stack.push(item);
			return;
		}

		// Step 1: Pop all elements
		int top = stack.pop();

		// Step 2: Insert the item at the bottom of the remaining stack
		insertAtBottom(stack, item);

		// Step 3: Push the popped element back to the stack
		stack.push(top);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println("Original Stack: " + stack);

		reverse(stack);

		System.out.println("Reversed Stack: " + stack);
	}
}
