package facebook;

import java.util.ArrayList;

import utils.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * http://n00tc0d3r.blogspot.com/2013/04/merge-k-sorted-lists.html
 * http://n00tc0d3r.blogspot.com/2013/04/merge-sorted-listsarrays-i.html
 * https://github.com/yadongwen/leetcode/blob/master/Merge%20k%20Sorted%20Lists.java
 */
public class _023MergeKSortedLists {
    public static void main(String[] args) {

    }
}

class Solution_MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int last = lists.size() - 1;
        if (last < 0) return null;

        while (last > 0) {
            int cur = 0;
            while (cur < last) {
                lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(last--)));
            }
        }

        return lists.get(0);
    }

    // Since this is an in-place merging, it takes O(m+n) time and O(1) space.

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.data <= l2.data)) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return head.next;
    }
}
