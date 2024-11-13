package com.day6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) {
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Call the method to count character frequencies
        Map<Character, Integer> frequencyMap = countCharacterFrequencies(input);
        
        // Display the frequency of each character
        System.out.println("Character Frequencies:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Close the scanner
        scanner.close();
    }

    // Method to count frequencies of each character
    private static Map<Character, Integer> countCharacterFrequencies(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            // Increment the count for this character
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        
        return frequencyMap;
    }
}

