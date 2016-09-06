package leetcode_online_judge.Java;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _021MergeTwoSortedLists {
    /*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
    nodes of the first two lists.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0), node1 = l1, node2 = l2, tail = dummyNode;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }

        if (node1 == null) {
            tail.next = node2;
        } else {
            tail.next = node1;
        }

        return dummyNode.next;
    }

    private static void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(10);
        l1.next.next.next = new ListNode(19);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(11);
        l2.next.next.next = new ListNode(12);
        ListNode.print(mergeTwoLists(l1, l2));
    }

    public static void main(String[] args) {
        test();
    }
}
