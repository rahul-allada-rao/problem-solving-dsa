package leetcode;

import ds.linkedlist.DoublyLL;
import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/lru-cache/
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:

 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.



 Example 1:

 Input
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4

 */
public class LRUCache {

    private static LRUDoubleNode first;
    private static HashMap<Integer, Integer> cache = new HashMap<>();
    private static int cacheCapacity;

    public static class LRUDoubleNode
    {
        int data;
        LRUDoubleNode next;
        LRUDoubleNode prev;
    }

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
    }

    public int get(int key)
    {
        int value = -1;
        if (cache.containsKey(key))
        {
            value = cache.get(key);

            LRUDoubleNode temp = first;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            LRUDoubleNode newNode = new LRUDoubleNode();
            newNode.data = key;
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
        }

        return value;
    }

    public void put(int key, int value)
    {
        if (cache.size() < cacheCapacity)
        {
            cache.put(key, value);
            LRUDoubleNode newNode = new LRUDoubleNode();
            newNode.data=key;
            newNode.prev = null;
            newNode.next = null;
            if (first == null)
            {
                first = newNode;
            }
            else
            {
                LRUDoubleNode temp = first;
                while (temp.next != null)
                {
                    temp = temp.next;
                }

                // create links
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next = newNode;
            }
        }
        else
        {
            LRUDoubleNode temp = first;
            while (temp.next != null)
            {
                temp = temp.next;
            }


            LRUDoubleNode local = temp.prev;
            while (local != null)
            {
                int lruKey = local.data;
                cache.remove(lruKey);
                local = local.prev;
            }

            cache.put(key, value);
        }
    }

    public static void main(String[] args)
    {
        LRUCache lRUCache = new LRUCache(2);

//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        lRUCache.get(1);    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        lRUCache.get(1);    // return -1 (not found)
//        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4

        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println("lRUCache.get(1) --> Expected 1 | Actual " + lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println("lRUCache.get(2) --> Expected -1 | Actual " + lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println("lRUCache.get(1) --> Expected -1 | Actual " + lRUCache.get(1));
        System.out.println("lRUCache.get(3) --> Expected 3 | Actual " + lRUCache.get(3));
        System.out.println("lRUCache.get(4) --> Expected 4 | Actual " + lRUCache.get(4));
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Output ->   [null,null,null,-1,null,2,null,-1,-1,4]
// Expected -> [null,null,null,0,null,-1,null,-1,3,4]