package leetcode_online_judge.Java;

import utils.ListNode;

public class _082RemoveDuplicatesFromSortedListII {
    /*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = head, node = head.next, appendNode = dummyHead;
        int count = 0;

        while (node != null) {
            if (node.val == currentNode.val) {
                count++;
            } else {
                if (count == 0) {
                    appendNode.next = currentNode;
                    appendNode = currentNode;
                    appendNode.next = null;
                }
                currentNode = node;
                count = 0;
            }
            node = node.next;
        }

        if (currentNode.next == null) {
            appendNode.next = currentNode;
        }

        return dummyHead.next;
    }

    private static ListNode getSampleLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        return head;
    }

    private static ListNode getSampleLinkedList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        return head;
    }

    private static void test() {
        ListNode.print(deleteDuplicates(getSampleLinkedList()));     //1->2->5
        ListNode.print(deleteDuplicates(getSampleLinkedList2()));    //2->3
    }

    public static void main(String[] args) {
        test();
    }
}
