package com.day2;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionOfLinkedLists {
    public ListNode1 getIntersectionNode(ListNode1 listA, ListNode1 listB) {
        if (listA == null || listB == null) {
            return null;
        }

        ListNode1 pointerA = listA;
        ListNode1 pointerB = listB;

        // Traverse the lists
        while (pointerA != pointerB) {
            // If pointerA reaches the end, switch to headB
            pointerA = (pointerA == null) ? listB : pointerA.next;
            // If pointerB reaches the end, switch to headA
            pointerB = (pointerB == null) ? listA : pointerB.next;
        }

        // Either both pointers meet at the intersection or both are null
        return pointerA; 
    }

    // Helper function to create a linked list from an array
    public static ListNode1 createLinkedList(int[] arr) {
        ListNode1 dummy = new ListNode1(0);
        ListNode1 current = dummy;
        for (int num : arr) {
            current.next = new ListNode1(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printLinkedList(ListNode1 head) {
        ListNode1 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        IntersectionOfLinkedLists solution = new IntersectionOfLinkedLists();

        // Create two intersecting linked lists
        ListNode1 common = createLinkedList(new int[]{8, 4, 5}); // Common part
        ListNode1 listA = createLinkedList(new int[]{4, 1});
        ListNode1 listB = createLinkedList(new int[]{5, 0, 1});

        // Connect the common part
        ListNode1 lastA = listA;
        while (lastA.next != null) {
            lastA = lastA.next;
        }
        lastA.next = common;

        ListNode1 lastB = listB;
        while (lastB.next != null) {
            lastB = lastB.next;
        }
        lastB.next = common;

        System.out.println("List A:");
        printLinkedList(listA);
        System.out.println("List B:");
        printLinkedList(listB);

        ListNode1 intersectionNode = solution.getIntersectionNode(listA, listB);
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
