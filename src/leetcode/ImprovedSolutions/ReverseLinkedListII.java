package leetcode.algorithms;

import utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * http://n00tc0d3r.blogspot.com/2013/05/reverse-linked-list.html
 */
public class _092ReverseLinkedListII {
    public static void main(String[] args) {
        Solution_ReverseLinkedListII sol = new Solution_ReverseLinkedListII();
        ListNode.print(ListNode.getSampleList(5));
        ListNode.print(sol.reverseBetween(ListNode.getSampleList(5), 2, 4));
    }
}

class Solution_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0); // 0
        dummyHead.next = head; // 0 -> 1

        //move to the start point
        ListNode pre = dummyHead; // 0
        for(int i = 0; i < m - 1; i ++){
            pre = pre.next; // 1
        }

        //do the reverse
        ListNode current = pre.next; // 2
        ListNode subListHead = null;
        ListNode next = null;
        for(int i = 0; i <= n - m; i ++){
            next = current.next; // 5
            current.next = subListHead; // 4->3->2 -> null
            subListHead = current; // 4
            current = next; // 5
        }

        //reconnect
        pre.next.next = current;
        pre.next = subListHead;

        return dummyHead.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) pre = pre.next;

        ListNode cur = pre.next;
        for (int i = m; i < n; i++) { // insert next to head to reverse
            ListNode temp = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = temp;
        }
        return dummy.next;
    }
}
