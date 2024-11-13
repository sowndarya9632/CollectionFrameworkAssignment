package com.day3;

import java.util.Stack;

public class NextGreaterElement {
    
    // Method to find the next greater element for each element in the array
    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize all elements in result to -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;//stack empty
        }

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current element is greater than the element
            // corresponding to the index at the top of the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {//first stack empty
                int index = stack.pop();
                result[index] = nums[i]; // Update the result with the next greater element
            }
            stack.push(i); // Push the current index onto the stack
        }

        return result; // Return the array with next greater elements
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreater(nums);

        // Print the result
        System.out.print("Next greater elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
