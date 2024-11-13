package com.day4;

class Node {
	int data;
	Node next;
	Node prev;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class Deque {
	private Node front;
	private Node rear;

	public Deque() {
		front = null;
		rear = null;
	}

// Add an element at the front of the deque
	public void addFront(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = rear = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
	}

// Add an element at the rear of the deque
	public void addRear(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = rear = newNode;
		} else {
			newNode.prev = rear;
			rear.next = newNode;
			rear = newNode;
		}
	}

// Remove an element from the front of the deque
	public int removeFront() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");
		}
		int data = front.data;
		front = front.next;
		if (front != null) {
			front.prev = null;
		} else {
			rear = null; // If deque becomes empty
		}
		return data;
	}

// Remove an element from the rear of the deque
	public int removeRear() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");
		}
		int data = rear.data;
		rear = rear.prev;
		if (rear != null) {
			rear.next = null;
		} else {
			front = null; // If deque becomes empty
		}
		return data;
	}

// Check if the deque is empty
	public boolean isEmpty() {
		return front == null;
	}

// Get the front element without removing it
	public int peekFront() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");
		}
		return front.data;
	}

// Get the rear element without removing it
	public int peekRear() {
		if (isEmpty()) {
			throw new IllegalStateException("Deque is empty");
		}
		return rear.data;
	}

// Example usage
	public static void main(String[] args) {
		Deque deque = new Deque();

		// Adding elements
		deque.addRear(1);
		deque.addRear(2);
		deque.addFront(0);
		System.out.println("Front element: " + deque.peekFront()); // Output: 0
		System.out.println("Rear element: " + deque.peekRear()); // Output: 2

		// Removing elements
		System.out.println("Removed from front: " + deque.removeFront()); // Output: 0
		System.out.println("Removed from rear: " + deque.removeRear()); // Output: 2

		System.out.println("Front element after removal: " + deque.peekFront()); // Output: 1
	}
}
