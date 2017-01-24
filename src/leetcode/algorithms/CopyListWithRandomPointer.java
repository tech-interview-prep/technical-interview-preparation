package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Tags: Hashtable, Linkedlist
 */
class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    /**
     * Use a hashmap to store map between original node and copy node
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode temp, current = head;
        Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();

        while(current != null) {
            temp = new RandomListNode(current.label);
            hm.put(current, temp);
            current = current.next;
        }

        current = head;

        while(current != null) {
            temp = hm.get(current);
            temp.next = hm.get(current.next);
            temp.random = hm.get(current.random);

            current = current.next;
        }

        return hm.get(head);
    }

    /**
     * Method 2 (Uses Constant Extra Space)
     * 1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
     * 2) Now copy the arbitrary link in this fashion
     *      original->next->arbitrary = original->arbitrary->next;
     *      This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
     * 3) Now restore the original and copy linked lists in this fashion in a single loop.
     *     original->next = original->next->next;
     *     copy->next = copy->next->next;
     * 4) Make sure that last element of original->next is NULL.
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode p = head;

        // copy every node and insert to list
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // break list to two
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
        RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            p = p.next;
        }

        return newHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
