package leetcode_online_judge.Java;

import utils.ListNode;
import utils.Utils;

public class _142LinkedListCycleII {
    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    Follow up:
    Can you solve it without using extra space?
    */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode node = head.next, fastNode = head.next.next;
        while (fastNode != null && fastNode.next != null) {
            if (node == fastNode) {
                node = head;
                while (node != fastNode) {
                    node = node.next;
                    fastNode = fastNode.next;
                }
                return fastNode;
            }
            fastNode = fastNode.next.next;
            node = node.next;
        }

        return null;
    }

    private static void test() {
        Utils.printTestln(detectCycle(ListNode.getSampleList(1)), null);
        Utils.printTestln(detectCycle(ListNode.getSampleList(2)), null);
    }

    public static void main(String[] args) {
        test();
    }
}
