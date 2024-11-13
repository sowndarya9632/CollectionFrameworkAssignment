package com.day2;

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}

public class DetectCycle {  
		    public ListNode detectCycle(ListNode head) {
		        if (head == null) {
		            return null;
		        }

		        ListNode slow = head;
		        ListNode fast = head;

		        // Step 1: Detect if a cycle exists
		        while (fast != null && fast.next != null) {
		            slow = slow.next;
		            fast = fast.next.next;

		            if (slow == fast) { // Cycle detected
		                break;
		            }
		        }

		        // If no cycle exists
		        if (fast == null || fast.next == null) {
		            return null;
		        }

		        // Step 2: Find the starting node of the cycle
		        slow = head;
		        while (slow != fast) {
		            slow = slow.next;
		            fast = fast.next;
		        }

		        return slow; // Starting node of the cycle
		    }

		    public static void main(String[] args) {
		        // Creating a linked list with a cycle for demonstration
		        ListNode node1 = new ListNode(1);
		        ListNode node2 = new ListNode(2);
		        ListNode node3 = new ListNode(3);
		        ListNode node4 = new ListNode(4);

		        // Linking nodes
		        node1.next = node2;
		        node2.next = node3;
		        node3.next = node4;
		        node4.next = node2; // Creates a cycle here

		        DetectCycle cycleDetector = new DetectCycle();
		        ListNode cycleStart = cycleDetector.detectCycle(node1);
		        
		        if (cycleStart != null) {
		            System.out.println("Cycle detected at node with value: " + cycleStart.value);
		        } else {
		            System.out.println("No cycle detected.");
		        }
		    }

      }
 

   
