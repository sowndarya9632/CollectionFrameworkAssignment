package com.day4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {
    
    // Method to generate binary numbers from 1 to n
    public static void generateBinary(int n) {
        Queue<String> queue = new LinkedList<>();
        
        // Start with the first binary number
        queue.add("1");
        
        for (int i = 1; i <= n; i++) {
            // Get the front of the queue
            String binaryNumber = queue.poll();
            System.out.println(binaryNumber);
            
            // Generate the next two binary numbers and add them to the queue
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10; // Generate binary numbers from 1 to n
        System.out.println("Binary numbers from 1 to " + n + ":");
        generateBinary(n);
    }
}

