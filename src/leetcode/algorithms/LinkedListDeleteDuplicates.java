package leetcode.algorithms;

import java.util.HashSet;

import utils.ListNode;

/**
 * A LinkedList class with a private static inner node class based on:
 *     http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 *
 * LinkedList Remove Duplicates
 *
 * CarrerCup 2.1  removeDup() removeDupWithoutBuffer()
 *
 * https://gist.github.com/zac-xin/2515371#file-linkedlist-java
 */
public class LinkedListDeleteDuplicates {
    public void deleteDupsA(ListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public void deleteDupsC(ListNode head) {
        if (head == null) return;
        ListNode previous = head;
        ListNode current = previous.next;
        while (current != null) {
            // Look backwards for dups, and remove any that you see.
            ListNode runner = head;
            while (runner != current) {
                if (runner.data == current.data) {
                    ListNode tmp = current.next;
                    previous.next = tmp;
                    current = tmp;
                    /* We know we can't have more than one dup preceding
                     * our element since it would have been removed
                     * earlier. */
                    break;
                }
                runner = runner.next;
            }

            /* If runner == current, then we didn't find any duplicate
             * elements in the previous for loop.  We then need to
             * increment current.
             * If runner != current, then we must have hit the ‘break'
             * condition, in which case we found a dup and current has
             * already been incremented.*/
            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
    }

    public void deleteDupsB(ListNode head) {
        if (head == null) return;

        ListNode current = head;
        while (current != null) {
            /* Remove all future nodes that have the same value */
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
