/*
    A LinkedList class with a private static inner node class
    based on:
    http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html

    Find Nth from Last
    Find Kth from Last

    CarrerCup 2.2 findLastNth()

     https://gist.github.com/zac-xin/2515371#file-linkedlist-java

*/
package leetcode.algorithms;

import utils.ListNode;

public class FindKthFromLastLinkedList {
    public ListNode nthToLast(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        if (n <= 0) return null;

        // Move p2 n nodes into the list.  Keep n1 in the same position.
        for (int i = 0; i < n - 1; i++) {
            if (p2 == null) {
                return null; // Error: list is too small.
            }
            p2 = p2.next;
        }
        if (p2 == null) { // Another error check.
            return null;
        }

        // Move them at the same pace.  When p2 hits the end,
        // p1 will be at the right element.
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
