package com.day4;

class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Adds an item to the queue. Returns true if successful.
    public boolean enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return false; // Queue is full
        }
        queue[rear] = item;
        rear = (rear + 1) % capacity; // Wrap around
        size++;
        return true;
    }

    // Removes an item from the queue. Returns the item or -1 if empty.
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Queue is empty
        }
        int item = queue[front];
        front = (front + 1) % capacity; // Wrap around
        size--;
        return item;
    }

    // Returns the front item without removing it. Returns -1 if empty.
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Queue is empty
        }
        return queue[front];
    }

    // Checks if the queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if the queue is full.
    public boolean isFull() {
        return size == capacity;
    }

    // Returns the number of elements in the queue.
    public int getSize() {
        return size;
    }

    // Example usage
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        
        // Enqueue elements
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        
        // Attempt to enqueue when full
        cq.enqueue(60); // Queue is full
        
        // Dequeue elements
        System.out.println(cq.dequeue()); // Output: 10
        System.out.println(cq.peek());    // Output: 20
        
        // Enqueue more elements
        cq.enqueue(60); // Should succeed
        
        // Print remaining elements
        while (!cq.isEmpty()) {
            System.out.println(cq.dequeue());
        }
    }
}
