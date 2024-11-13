package com.day2;

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2(int val) {
		this.val = val;
		this.next = null;
	}
}

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode2 head) {
		if (head == null || head.next == null) {
			return true; // An empty list or a single node is a palindrome
		}

		// Step 1: Find the middle of the linked list
		ListNode2 slow = head;
		ListNode2 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the list
		ListNode2 prev = null;
		ListNode2 current = slow;

		while (current != null) {
			ListNode2 nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}

		// Step 3: Compare the two halves
		ListNode2 firstHalf = head;
		ListNode2 secondHalf = prev; // The head of the reversed second half

		while (secondHalf != null) {
			if (firstHalf.val != secondHalf.val) {
				return false; // Not a palindrome
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		return true; // It's a palindrome
	}

	// Helper function to create a linked list from an array
	public static ListNode2 createLinkedList(int[] arr) {
		ListNode2 dummy = new ListNode2(0);
		ListNode2 current = dummy;
		for (int num : arr) {
			current.next = new ListNode2(num);
			current = current.next;
		}
		return dummy.next;
	}

	// Helper function to print the linked list
	public static void printLinkedList(ListNode2 head) {
		ListNode2 current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		PalindromeLinkedList solution = new PalindromeLinkedList();

		// Example test cases
		ListNode2 list1 = createLinkedList(new int[] { 1, 2, 3, 2, 1 });
		ListNode2 list2 = createLinkedList(new int[] { 1, 2, 3, 4, 5 });

		System.out.println("List 1 is palindrome: " + solution.isPalindrome(list1)); // true
		System.out.println("List 2 is palindrome: " + solution.isPalindrome(list2)); // false
	}
}
