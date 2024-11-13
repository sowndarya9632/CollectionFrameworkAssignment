package com.day6;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static Character findFirstNonRepeated(String str) {
        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeated character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // Return null if no non-repeated character is found
    }

    public static void main(String[] args) {
        String input = "swiss";
        Character result = findFirstNonRepeated(input);
        System.out.println(result); // Output: w
    }
}


