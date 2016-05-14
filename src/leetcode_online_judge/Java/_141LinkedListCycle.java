package leetcode_online_judge.Java;

import utils.ListNode;

public class _141LinkedListCycle {
    /*
    Given a linked list, determine if it has a cycle in it.

    Follow up:
    Can you solve it without using extra space?
    */
    public boolean hasCycle(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head;

        if (head !=null && head.next != null) {
            fastNode = head.next;
        } else {
            return false;
        }

        while (slowNode !=null && fastNode!=null){
            if (slowNode.val == fastNode.val ) return true;

            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode!=null){
                fastNode = fastNode.next;
            }
        }

        return false;
    }
}
