package leetcode_online_judge.Java;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _019RemoveNthNodeFromEndOfList {
    /*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

       Given linked list: 1->2->3->4->5, and n = 2.

       After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
    */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode node = head.next, node2;
        int i;

        for (i = 0; i < n && node != null; node = node.next, i++);
        if (i < n) {
            return head.next;
        }

        for (node2 = head; node != null; node = node.next, node2 = node2.next);
        node2.next = node2.next.next;

        return head;
    }

    private static void test() {
        ListNode.print(removeNthFromEnd(ListNode.getSampleList(9), 3));
        ListNode.print(removeNthFromEnd(ListNode.getSampleList(3), 3));
        ListNode.print(removeNthFromEnd(ListNode.getSampleList(4), 0));
    }

    public static void main(String[] args) {
        test();
    }
}
