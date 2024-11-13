package com.day4;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache;
    private final LinkedList<Integer> usageOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usageOrder = new LinkedList<>();
    }

    // Get value from cache
    public Integer get(int key) {
        if (!cache.containsKey(key)) {
            return null; // Key not found
        }
        // Move the accessed key to the front of the usage order
        usageOrder.remove((Integer) key);
        usageOrder.addFirst(key);
        return cache.get(key);
    }

    // Put key-value in cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value
            cache.put(key, value);
            // Move the accessed key to the front of the usage order
            usageOrder.remove((Integer) key);
        } else {
            if (cache.size() >= capacity) {
                // Remove the least recently used key
                Integer lruKey = usageOrder.removeLast();
                cache.remove(lruKey);
            }
            // Add the new key-value pair
            cache.put(key, value);
        }
        // Add the key to the front of the usage order
        usageOrder.addFirst(key);
    }
    
    // Display the current cache state
    public void display() {
        System.out.println("Cache: " + cache);
        System.out.println("Usage Order: " + usageOrder);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);
        
        lruCache.display(); // Cache: {1=100, 2=200, 3=300}, Usage Order: [3, 2, 1]
        
        lruCache.get(1); // Access key 1
        lruCache.display(); // Cache: {1=100, 2=200, 3=300}, Usage Order: [1, 3, 2]
        
        lruCache.put(4, 400); // Evicts key 2
        lruCache.display(); // Cache: {1=100, 3=300, 4=400}, Usage Order: [4, 1, 3]
        
        lruCache.put(5, 500); // Evicts key 3
        lruCache.display(); // Cache: {1=100, 4=400, 5=500}, Usage Order: [5, 1, 4]
        
        System.out.println("Get key 3: " + lruCache.get(3)); // Output: null (not found)
    }
}

