package leetcode.algorithms.level.Medium;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class InsertionSortList {
    /*
    Sort a linked list using insertion sort.
     */
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);

        for (ListNode node = head; node != null; ) {
            ListNode insertNode, nextNode = node.next;
            for (insertNode = dummyHead; insertNode.next != null && node.data >= insertNode.next.data; insertNode = insertNode.next);
            node.next = insertNode.next;
            insertNode.next = node;
            node = nextNode;
        }
        return dummyHead.next;
    }

    private static void test() {
        ListNode.print(insertionSortList(ListNode.getSampleRandomList(10)));
        ListNode.print(insertionSortList(ListNode.getSampleRandomList(10)));
    }

    public static void main(String[] args) {
        test();
    }

}
