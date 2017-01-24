package leetcode.algorithms;

import utils.ListNode;

/**
 * @author bkoteshwarreddy
 */
public class ReorderList {
    /*
    Given a singly linked list L: L0?L1?�?Ln-1?Ln,
    reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?�

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // first half part is always 1 or 2 longer than the 2nd half part
        ListNode node = head, node2 = head, nextNode;
        while (node2 != null && node2.next != null) {
            node = node.next;
            node2 = node2.next.next;
        }

        //reverse the 2nd half linked list
        node2 = node.next;
        node.next = null;
        node = null;
        while (node2 != null) {
            nextNode = node2.next;
            node2.next = node;
            node = node2;
            node2 = nextNode;
        }

        //merge
        node2 = head;
        while (node2 != null && node  != null) {
            nextNode = node.next;
            node.next = node2.next;
            node2.next = node;
            node = nextNode;
            node2 = node2.next.next;
        }
    }

    private static void test() {
        ListNode head = ListNode.getSampleList(10);
        ListNode.print(head);

        reorderList(head);
        ListNode.print(head);
    }

    public static void main(String[] args) {
        test();
    }


}
