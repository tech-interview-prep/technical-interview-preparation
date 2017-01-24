package leetcode.algorithms;

import utils.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed
 *
 * For example,
 *   Given this linked list: 1->2->3->4->5
 *   For k = 2, you should return: 2->1->4->3->5
 *   For k = 3, you should return: 3->2->1->4->5
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * http://n00tc0d3r.blogspot.com/2013/05/reverse-linked-list.html
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution_ReverseNodeInKGroup sol = new Solution_ReverseNodeInKGroup();

        ListNode.print(sol.reverseKGroupRecursive(ListNode.getSampleList(5), 2));
        ListNode.print(sol.reverseKGroupRecursive(ListNode.getSampleList(5), 3));
        ListNode.print(sol.reverseKGroupRecursive(null, 1));

        ListNode.print(sol.reverseKGroupIterative(ListNode.getSampleList(5), 2));
        ListNode.print(sol.reverseKGroupIterative(ListNode.getSampleList(5), 3));
        ListNode.print(sol.reverseKGroupIterative(null, 1));
    }
}

class Solution_ReverseNodesInKGroup {
    public static ListNode reverselist(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverselist(pre, next);
                count = 0;
            }
            cur = next;
        }
        return newhead.next;
    }

    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        for (int i = 1; i < k; i++, newHead = newHead.next) {
            if (newHead.next == null) {
                return head;
            }
        }

        ListNode node = head;
        for (int i = 1; i < k; i++) {
            ListNode next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = next;
        }

        head.next = reverseKGroup(head.next, k);

        return newHead;
    }

    public ListNode reverseKGroupIterative(ListNode head, int k) {
        if (head == null || head.next == null || k < 0) return head;
        if (k == 0 || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; // current group dummy
        ListNode cur = head; // current group head

        while (cur != null) {
            ListNode p = pre.next;
            int group = k;
            while (p != null && group > 0) { // move p to next head as stop node
                group--;
                p = p.next;
            }
            if (group > 0) break; // end of list
            while (cur.next != p) { // note it's cur.next here
                ListNode nt = cur.next.next; // insert cur.next to head
                cur.next.next = pre.next;
                pre.next = cur.next;
                cur.next = nt; // unlink cur with cur next, link with next next
            }
            pre = cur; // move pre to current group's tail
            cur = cur.next; // move cur to next group's head
        }

        return dummy.next;
    }
}
