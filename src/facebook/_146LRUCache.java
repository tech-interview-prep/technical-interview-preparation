package facebook;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 *
 * it should invalidate the least recently used item before inserting a new item.
 *
 * https://leetcode.com/problems/lru-cache/
 * http://n00tc0d3r.blogspot.com/2013/08/implement-lru-cache.html
 */
public class _146LRUCache {
    public static void main(String[] args) {
        Solution_LRUCache cache = new Solution_LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        Utils.printTestln(cache.get(1), -1);
        Utils.printTestln(cache.get(2), 2);
        cache.set(4, 4);
        Utils.printTestln(cache.get(3), -1);
        Utils.printTestln(cache.get(2), 2);
        Utils.printTestln(cache.get(4), 4);
        cache.set(4, 3);
        Utils.printTestln(cache.get(4), 3);

        cache.set(2, 1);
        cache.set(3, 2);
        Utils.printTestln(cache.get(3), 2);
        Utils.printTestln(cache.get(2), 1);
        cache.set(4, 3);
        Utils.printTestln(cache.get(2), 1);
        Utils.printTestln(cache.get(3), -1);
        Utils.printTestln(cache.get(4), 3);
    }
}

class Solution_LRUCache {
    private DoubleLinkedNode head;
    private Map<Integer, DoubleLinkedNode> map;
    private int capacity;
    private int size;

    public Solution_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkedNode();
        map = new HashMap<Integer, DoubleLinkedNode>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        DoubleLinkedNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
        } else {
            if (size < capacity) {
                node = new DoubleLinkedNode();
                size++;
            } else {
                node = head.pre;
                map.remove(node.key);
            }
            map.put(key, node);
        }
        node.key = key;
        node.value = value;
        moveToFront(node);
    }

    private void moveToFront(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private static class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre = this;
        DoubleLinkedNode next = this;
    }
}
