/**
 * Write a program to sum numbers represented by linked list.
 *
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) 617 + 295
 * Output: 2 -> 1 -> 9
 *
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 */
package facebook;

import utils.ListNode;

public class _002AddTwoNumbers {
    public static void main(String[] args) {
        Solution_AddTwoNumbers sol = new Solution_AddTwoNumbers();
        System.out.println(sol.addLists(null, null));
    }
}

class Solution_AddTwoNumbers {
    public ListNode addListsIterative(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
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

    public ListNode addListsRecursive(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    public ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;
        ListNode more = addLists(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next,
                value >= 10 ? 1 : 0);
        result.setNext(more);

        return result;
    }

    // -----------------------------------------------------------------//
    //    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5)      617 + 295           //
    //    Output: 9 -> 1 -> 2     912                                   //
    //    http://www.geeksforgeeks.org/sum-of-two-linked-lists/         //
    // -----------------------------------------------------------------//

    public ListNode addLists(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListsHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private static PartialSum addListsHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
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
