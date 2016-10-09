/**
 * Reverse a singly linked list.
 */
package uber;

import utils.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author bkoteshwarreddy
 */
public class _206ReverseLinkedList {

}

class Solution_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return null;
    }

    public ListNode reverse(ListNode ptr , ListNode previous) {
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

    public ListNode reverse(ListNode ptr ) {
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

    //    ListNode reversedHead = reverse(head, NULL);
}
