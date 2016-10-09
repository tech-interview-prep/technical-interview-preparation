package leetcode_online_judge.Java;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _061RotateList {
    /*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
     */
    public static ListNode rotateRight(ListNode head, int n) {
        ListNode node = head, node2;
        int length;

        for (length = 0 ; length < n & node != null; length++, node = node.next);

        if (node == null) {
            if (length == n || length < 2) {
                return head;
            }
            for (n %= length, length = 0, node = head; length < n & node != null; length++, node = node.next);
        }

        for (node2 = head; node.next != null; node = node.next, node2 = node2.next);

        node.next = head;
        node = node2.next;
        node2.next = null;

        return node;
    }

    private static void test() {
        ListNode.print(rotateRight(ListNode.getSampleList(5), 2));
        ListNode.print(rotateRight(ListNode.getSampleList(2), 2));
        ListNode.print(rotateRight(ListNode.getSampleList(2), 5));
    }

    public static void main(String[] args) {
        test();
    }
}
