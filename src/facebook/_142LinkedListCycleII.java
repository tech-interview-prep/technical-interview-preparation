/*
    Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
    DEFINITION
     Circular linked list: A (corrupt) linked list in which a node’s next pointer
     points to an earlier node, so as to make a loop in the linked list

    EXAMPLE
     input: A -> B -> C -> D -> E -> C [the same C as earlier]
     output: C

     https://gist.github.com/zac-xin/2557211

*/

package facebook;

import utils.ListNode;

public class _142LinkedListCycleII {
}

class Solution_LinkedListCycleII {
    public static ListNode FindBeginning(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps
        /* from the Loop Start. If they move at the same pace, they must
         * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }
}
