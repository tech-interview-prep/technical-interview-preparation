package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * Tags: Hash Table, Heap
 * Similar Problems: (M) Word Frequency, (M) Kth Largest Element in an Array
 */
public class TopKFrequentElements {

    private TopKFrequentElements t;

    /**
     * Use a map to store frequency.
     * Create a bucket of lists, indexed by frequency.
     * Each list contains the number of that frequency.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        // Build frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        // Build frequency buckets
        List<Integer>[] lists = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : frequencyMap.entrySet()) {
            int frequency = e.getValue();
            if (lists[frequency] == null) lists[frequency] = new ArrayList<>();
            lists[frequency].add(e.getKey());
        }
        // Add top k most frequent integer to result
        List<Integer> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null) continue;
            for (int j = 0; j < lists[i].size() && res.size() < k; j++) {
                res.add(lists[i].get(j));
            }
        }
        return res;
    }
}
