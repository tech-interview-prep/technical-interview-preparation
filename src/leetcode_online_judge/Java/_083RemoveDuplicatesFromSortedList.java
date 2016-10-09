package leetcode_online_judge.Java;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _083RemoveDuplicatesFromSortedList {
    /*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
    */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next, node = head;
        while (nextNode != null) {
            if (node.data == nextNode.data) {
                nextNode = nextNode.next;
            } else {
                node.next = nextNode;
                node = node.next;
                nextNode = nextNode.next;
            }
        }
        node.next = null;
        return head;
    }

    private static ListNode getSampleLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        return head;
    }

    private static ListNode getSampleLinkedList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        return head;
    }

    private static void test() {
        ListNode.print(deleteDuplicates(getSampleLinkedList()));
        ListNode.print(deleteDuplicates(getSampleLinkedList2()));
    }

    public static void main(String[] args) {
        test();
    }
}
