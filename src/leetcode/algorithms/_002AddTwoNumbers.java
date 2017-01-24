package leetcode.algorithms;

import utils.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * https://leetcode.com/problems/add-two-numbers
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * http://n00tc0d3r.blogspot.com/2013/01/add-two-binary-numbers.html
 */
public class _002AddTwoNumbers {
    public static void main(String[] args) {
        Solution_AddTwoNumbers sol = new Solution_AddTwoNumbers();
        System.out.println(sol.addLists(null, null));
    }
}

class Solution_AddTwoNumbers {
    public ListNode addListsIterative(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = list1, q = list2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public ListNode addListsRecursive(ListNode list1, ListNode list2) {
        return addLists(list1, list2, 0);
    }

    public ListNode addLists(ListNode list1, ListNode list2, int carry) {
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;

        if (list1 != null) {
            value += list1.data;
        }

        if (list2 != null) {
            value += list2.data;
        }

        result.data = value % 10;
        ListNode more = addLists(list1 == null ? null : list1.next,
                                 list2 == null ? null : list2.next,
                                 value >= 10 ? 1 : 0);
        result.setNext(more);

        return result;
    }

    // -----------------------------------------------------------------//
    //    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5)      617 + 295           //
    //    Output: 9 -> 1 -> 2     912                                   //
    //    http://www.geeksforgeeks.org/sum-of-two-linked-lists/         //
    // -----------------------------------------------------------------//

    public ListNode addLists(ListNode list1, ListNode list2) {
        int len1 = length(list1);
        int len2 = length(list2);

        if (len1 < len2) {
            list1 = padList(list1, len2 - len1);
        } else {
            list2 = padList(list2, len1 - len2);
        }

        PartialSum sum = addListsHelper(list1, list2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private static PartialSum addListsHelper(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListsHelper(list1.next, list2.next);
        int val = sum.carry + list1.data + list2.data;
        sum.sum = insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;

        return sum;
    }

    private static ListNode padList(ListNode l, int padding) {
        ListNode head = l;

        for (int i = 0; i < padding; i++) {
            ListNode n = new ListNode(0);
            n.next = head;
            head = n;
        }

        return head;
    }

    private static ListNode insertBefore(ListNode list, int data) {
        ListNode node = new ListNode(data);

        if (list != null) {
            node.next = list;
        }

        return node;
    }

    private static int length(ListNode l) {
        if (l == null) {
            return 0;
        } else {
            return 1 + length(l.next);
        }
    }
}

class PartialSum {
    public ListNode sum = null;
    public int carry = 0;
}
