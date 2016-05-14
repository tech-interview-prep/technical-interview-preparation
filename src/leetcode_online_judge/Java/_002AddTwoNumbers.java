package leetcode_online_judge.Java;

import utils.ListNode;

public class _002AddTwoNumbers {
    /*
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
    each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), node = dummyHead;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + dummyHead.val;
            if (sum >= 10) {
                dummyHead.val = 1;
                sum -= 10;
            } else {
                dummyHead.val = 0;
            }

            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            int sum = l1.val + dummyHead.val;
            if (sum >= 10) {
                dummyHead.val = 1;
                sum -= 10;
            } else {
                dummyHead.val = 0;
            }

            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
        }

        if (dummyHead.val == 1) {
            node.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    private static void test() {
        //321 + 54 = 375
        ListNode.print(addTwoNumbers(ListNode.getSampleList(3), ListNode.getSampleList(4, 2)));
    }

    public static void main(String[] args) {
        test();
    }
}
