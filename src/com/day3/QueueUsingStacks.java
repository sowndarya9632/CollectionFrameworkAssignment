package com.day3;
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // Stack for enqueue operation
    private Stack<Integer> stack2; // Stack for dequeue operation

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Dequeue operation
    public int dequeue() {
        // If both stacks are empty, throw an exception
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop the top element from stack2
        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 1
        queue.enqueue(4);
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 2
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 3
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 4
    }
}
