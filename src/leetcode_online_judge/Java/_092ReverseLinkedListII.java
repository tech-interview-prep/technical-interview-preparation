package leetcode_online_judge.Java;

import utils.ListNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _092ReverseLinkedListII {
    /*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ? m ? n ? length of list.
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        int index;
        ListNode dummyHead = new ListNode(0), insertNode, node,nextNode;
        dummyHead.next = head;
        for (insertNode = dummyHead, index = 1; index < m; index++, insertNode = insertNode.next);

        for (node = insertNode.next; index < n; index++) {
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = insertNode.next;
            insertNode.next = nextNode;
        }

        return dummyHead.next;
    }

    private static void test() {
        ListNode.print(ListNode.getSampleList(5));
        ListNode.print(reverseBetween(ListNode.getSampleList(5), 2, 4));
    }

    public static void main(String[] args) {
        test();
    }
}
