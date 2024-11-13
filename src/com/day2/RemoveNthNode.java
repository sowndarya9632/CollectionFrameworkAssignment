package com.day2;
class ListNode3 {
    int val;
    ListNode3 next;
    
    ListNode3(int val) {
        this.val = val;
        this.next = null;
    } 
} 
public class RemoveNthNode {

    public ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        ListNode3 dummy = new ListNode3(0);
        dummy.next = head;
        ListNode3 first = dummy;
        ListNode3 second = dummy;

        // Move first pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the Nth node from the end
        second.next = second.next.next;

        return dummy.next; // Return the new head
    }

    // Helper function to create a linked list from an array
    public static ListNode3 createLinkedList(int[] arr) {
        ListNode3 dummy = new ListNode3(0);
        ListNode3 current = dummy;
        for (int num : arr) {
            current.next = new ListNode3(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printLinkedList(ListNode3 head) {
        ListNode3 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
    	RemoveNthNode solution = new RemoveNthNode();

        // Example usage
        ListNode3 head = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original List:");
        printLinkedList(head);

        int n = 2;
        ListNode3 newHead = solution.removeNthFromEnd(head, n);
        System.out.println("List after removing " + n + "th node from the end:");
        printLinkedList(newHead);
    }
}


	
