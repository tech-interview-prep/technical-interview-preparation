package leetcode.algorithms;

import utils.ListNode;

/**
 * @author bkoteshwarreddy
 */
public class RemoveDuplicatesFromSortedList {
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

        ListNode runner = head.next, current = head;
        while (runner != null) {
            if (current.data != runner.data) {
                current.next = runner;
                current = current.next;
            }
            runner = runner.next;
        }
        current.next = null;
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
