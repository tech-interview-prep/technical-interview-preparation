package leetcode.algorithms;

import utils.ListNode;

/**
 * @author bkoteshwarreddy
 */
public class _160IntersectionOfTwoLinkedLists {
    /*
    Intersection of Two Linked Lists
    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:

        A:          a1 → a2
                           ↘
                             c1 → c2 → c3
                           ↗
        B:     b1 → b2 → b3
    begin to intersect at node c1.


    Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int l = Math.min(lenA, lenB);
        ListNode curA = headA;
        for (int i = 0; i < lenA - l; i++) curA = curA.next;
        ListNode curB = headB;
        for (int i = 0; i < lenB - l; i++) curB = curB.next;
        while (curA != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++ ; head = head.next;
        }
        return len;
    }
}
