/*
    Having a home-defined linked list with the following structure, where the next will
    point to the next node in the list and the random will point to a random node in the list (not null).

    Create a copy of the structure (the data field in each node is not unique for different nodes):

    Example:
        Having the list:
          1 -> 2 -> 3 -> X
        With random pointers to:
          1: 3
          2: 2
          3: 1

        Create the list:
          1' -> 2' -> 3' -> X
          1': 3'
          2': 2'
          3': 1'

     http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
        http://www.careercup.com/question?id=5731237876465664

*/
package facebook;

import java.util.HashMap;

import utils.RandomListNode;

public class _138CopyListWithRandomPointer {
}

class Solution_CopyListWithRandomPointer {
    public RandomListNode copyRandomList_HashMap(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.data);

        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);

        p = p.next;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.data);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }

        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null)
                q.random = map.get(p.random);
            else
                q.random = null;

            p = p.next;
            q = q.next;
        }

        return newHead;
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode p = head;

        // copy every node and insert to list
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.data);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // break list to two
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }

        return newHead;
    }
}
