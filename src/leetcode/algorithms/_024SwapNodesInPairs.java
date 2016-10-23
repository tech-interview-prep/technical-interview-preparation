package leetcode.algorithms;

import utils.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author bkoteshwarreddy
 */
public class _024SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can
     * be changed.
     */

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;

        head.next = swapPairs(head.next.next);
        node.next = head;

        return node;
    }

    private static void test() {
        ListNode.print(swapPairs(ListNode.getSampleList(4)));
    }

    public static void main(String[] args) {
        test();
    }
}
