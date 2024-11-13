package com.day4;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueue {
    
    // Method to interleave the queue
    public static Queue<Integer> interleave(Queue<Integer> queue) {
        int size = queue.size();
        Queue<Integer> tempQueue = new LinkedList<>();
        
        // Step 1: Move the first half of the queue to a temporary queue
        for (int i = 0; i < size / 2; i++) {
            tempQueue.add(queue.poll());
        }
        
        // Step 2: Interleave the elements
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());  // Add from the first half
            queue.add(queue.poll());       // Add from the second half
        }
        
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println("Original Queue: " + queue);
        Queue<Integer> interleavedQueue = interleave(queue);
        System.out.println("Interleaved Queue: " + interleavedQueue);
    }
}
