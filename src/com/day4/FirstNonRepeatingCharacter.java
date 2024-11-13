package com.day4;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    
    private Queue<Character> queue;
    private Map<Character, Integer> charCountMap;

    public FirstNonRepeatingCharacter() {
        queue = new LinkedList<>();
        charCountMap = new HashMap<>();
    }

    // Method to process each character in the stream
    public void addCharacter(char ch) {
        // Update the frequency count in the map
        charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);

        // Add character to the queue
        queue.add(ch);

        // Remove characters from the front of the queue if they are repeating
        while (!queue.isEmpty() && charCountMap.get(queue.peek()) > 1) {
            queue.poll();
        }
    }

    // Method to get the first non-repeating character
    public Character getFirstNonRepeating() {
        return queue.isEmpty() ? null : queue.peek();
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter stream = new FirstNonRepeatingCharacter();
        
        String input = "aabcdeff";
        for (char ch : input.toCharArray()) {
            stream.addCharacter(ch);
            System.out.println("Current character: " + ch + 
                               ", First non-repeating: " + stream.getFirstNonRepeating());
        }
    }
}
