package leetcode.algorithms;

import java.util.ArrayList;

import utils.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * http://n00tc0d3r.blogspot.com/2013/04/merge-k-sorted-lists.html
 * http://n00tc0d3r.blogspot.com/2013/04/merge-sorted-listsarrays-i.html
 * https://github.com/yadongwen/leetcode/blob/master/Merge%20k%20Sorted%20Lists.java
 * @author bkoteshwarreddy
 */
public class _023MergeKSortedLists {
    public static void main(String[] args) {

    }
}

class Solution_MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return new ListNode();
        }
        int last = lists.size() - 1;
        int current;
        while (last > 0) {
            current = 0;
            while (current < last) {
                lists.set(current, mergeTwoLists(lists.get(current++), lists.get(last--)));
            }
        }

        return lists.get(0);
    }

    // Since this is an in-place merging, it takes O(m+n) time and O(1) space.

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.data <= list2.data)) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        return head.next;
    }
}
