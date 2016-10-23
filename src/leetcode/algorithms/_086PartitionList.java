package leetcode.algorithms;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _086PartitionList {
    /*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
    */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);

        ListNode n1 = dummyHead1, n2 = dummyHead2;

        while (head != null) {
            if (head.data < x) {
                n1.next = head;
                n1 = n1.next;
            } else {
                n2.next = head;
                n2 = n2.next;
            }
            head = head.next;
        }

        n1.next = dummyHead2.next;
        n2.next = null;
        return dummyHead1.next;
    }

    private static void test() {
        ListNode.print(partition(ListNode.getSampleRandomList(6), 30));
    }

    public static void main(String[] args) {
        test();
    }
}
