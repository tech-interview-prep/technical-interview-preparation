package leetcode.algorithms;

import utils.ListNode;

/**
 * Reverse a singly linked list.
 *
 * https://leetcode.com/problems/reverse-linked-list/
 * http://n00tc0d3r.blogspot.com/2013/05/reverse-linked-list.html
 */
public class ReverseLinkedList {

}

class Solution_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = reverse(head, null);
        return reversedHead;
    }

    public ListNode reverse(ListNode ptr, ListNode previous) {
        ListNode temp;
        if (ptr.next == null) {
            ptr.next = previous;
            return ptr;
        } else {
            temp = reverse(ptr.next, ptr);
            ptr.next = previous;
            return temp;
        }
    }

    public ListNode reverse(ListNode ptr) {
        ListNode temp;
        ListNode previous = null;
        while (ptr != null) {
            temp = ptr.next;
            ptr.next = previous;
            previous = ptr;
            ptr = temp;
        }
        return previous;
    }
}
