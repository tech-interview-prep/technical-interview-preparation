package leetcode.algorithms.level.Easy;

import java.util.ArrayList;
import java.util.List;

import utils.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
}



class Solution_PalindromeLinkedList {
    // O(n) time, O(1) space.
    public boolean isPalindrome(ListNode head) {
        ListNode second = reverse(secondHalf(head));
        while (second != null) {
            if (head.data != second.data)
                return false;
            head = head.next;
            second = second.next;
        }
        return second == null;
    }

    public ListNode secondHalf(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur = prev.next;
        }
        return head;
    }

    /*******************************************************************/

    // O(n) time, O(n) space.
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            // Java boxing and unboxing!
            if (!list.get(i).equals(list.get(list.size() - 1 - i)))
                return false;
        }
        return true;
    }

}
