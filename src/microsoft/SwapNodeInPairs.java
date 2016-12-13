package leetcode.algorithms.level.Medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 *
 * Tags: Linkedlist
 */
class SwapNode {

    /**
     * create a node at before the head
     * swap two next nodes on the node before them
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            cur.next = nextNext;
            cur = cur.next.next;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
