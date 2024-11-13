package com.day2;

class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLists {
    public ListNode4 mergeTwoLists(ListNode4 l1, ListNode4 l2) {
        // Create a dummy node to simplify the merge process
        ListNode4 dummy = new ListNode4(0);
        ListNode4 current = dummy;

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1; // Link the smaller node
                l1 = l1.next;      // Move l1 pointer
            } else {
                current.next = l2; // Link the smaller node
                l2 = l2.next;      // Move l2 pointer
            }
            current = current.next; // Move the current pointer
        }

        // If there are remaining nodes in l1 or l2, attach them
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list starting from the next of the dummy node
        return dummy.next;
    }

    // Helper method to create a linked list from an array
    public static ListNode4 createLinkedList(int[] values) {
        ListNode4 dummy = new ListNode4(0);
        ListNode4 current = dummy;
        for (int value : values) {
            current.next = new ListNode4(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNode4 head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        MergeSortedLists merger = new MergeSortedLists();
        
        ListNode4 l1 = createLinkedList(new int[]{1, 3, 5});
        ListNode4 l2 = createLinkedList(new int[]{2, 4, 6});
        
        ListNode4 mergedList = merger.mergeTwoLists(l1, l2);
    }
}

