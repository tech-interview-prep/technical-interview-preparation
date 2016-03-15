package leetcode_online_judge;

public class LinkedListCycle {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
    */
    public static boolean hasCycle(ListNode head) {
        ListNode one = head, two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;

            if (one == two) {
                return true;
            }
        }
        
        return false;
    }
}
