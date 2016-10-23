package leetcode.algorithms;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _148SortList {
    /*
    Sort a linked list in O(n log n) time using constant space complexity.
    */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head, node2 = head.next.next;
        while (node2 != null && node2.next != null) {
            node = node.next;
            node2 = node2.next.next;
        }

        node2 = sortList(node.next);
        node.next = null;
        node = sortList(head);

        return merge(node, node2);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
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

        if (node1 != null) {
            tail.next = node1;
        } else {
            tail.next = node2;
        }

        return dummyNode.next;
    }

    private static void test() {
        ListNode head = ListNode.getSampleRandomList(10);

        ListNode.print(head);
        ListNode.print(sortList(head));
    }

    public static void main(String[] args) {
        test();
    }
}
