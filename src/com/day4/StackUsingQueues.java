package com.day4;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // Always push onto queue1
        queue1.add(x);
    }

    public int pop() {
        // Move all elements except the last from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        // The last element in queue1 is the top element of the stack
        int poppedValue = queue1.poll();
        // Swap the names of the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poppedValue;
    }

    public int top() {
        // Move all elements except the last from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        // The last element in queue1 is the top element of the stack
        int topValue = queue1.poll();
        queue2.add(topValue);  // Keep the top value in queue2
        // Swap the names of the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topValue;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // Output: 2
        System.out.println(stack.pop());   // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}

