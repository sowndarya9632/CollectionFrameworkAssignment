package com.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to hold sorted strings as keys and lists of anagrams as values
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Sort the characters in the string to form a key
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add the original string to the corresponding list in the map
            /*anagramMap.computeIfAbsent(sortedStr, a -> new ArrayList<>()).add(str);*/
            
        }

        // Return the list of grouped anagrams
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        AnagramGrouping ag = new AnagramGrouping();
        
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = ag.groupAnagrams(strs);
        
        // Print the grouped anagrams
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}

