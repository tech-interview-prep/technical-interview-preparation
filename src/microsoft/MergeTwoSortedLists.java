package leetcode.algorithms.level.Easy;

import utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 * Tags: Linkedlist
 */
public class MergeTwoLists {

    /**
     * Recursive
     * the order of l1, l2 doesn't matter
     */
    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // next node should be the result of comparison
        if (l1.data < l2.data) {
            l1.next = mergeTwoListsRec(l1.next, l2); // notice l1.next
            return l1;
        } else {
            l2.next = mergeTwoListsRec(l1, l2.next); // notice l2.next
            return l2;
        }
    }

    /**
     * iterative
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while((l1 != null) && (l2 != null)) {
            if(l1.data > l2.data) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if(l1 == null) {
            cur.next = l2;
        }

        if(l2 == null) {
            cur.next = l1;
        }

        return dummy.next;
    }
}
