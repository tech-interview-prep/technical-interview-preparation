package interviewBit.linkedLists;

import java.util.ArrayList;
import java.util.Arrays;

import utils.ListNode;

/**
 * Created by priyavivek on 11/4/15.
 *
 * Problem statement
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swapl {
    public ListNode swapPairs(ListNode a) {
        ListNode aCopy = a;
        int listSize = 0;
        while (aCopy != null) {
            listSize++;
            aCopy = aCopy.next;
        }

        if (listSize == 1) {
            return a;
        }

        if (listSize == 0) {
            return  null;
        }

        ListNode head = swapNodes(a);
        ListNode prev = head.next;

        ListNode currHead = head.next.next;

        while (currHead != null) {
            ListNode swappedHead = swapNodes(currHead);
            prev.next = swappedHead;
            prev = swappedHead.next;
            if (prev == null) {
                break;
            }
            currHead = swappedHead.next.next;


        }

        return head;

    }

    //Swap 2 nodes
    public ListNode swapNodes(ListNode A) {

        ListNode B = A.next;
        if (B == null) {
            return A;
        }

        ListNode C = B.next;

        A.next = C;
        B.next = A;

        //B is the head of the swapped nodes
        return B;
    }

    public static void main(String[] args) {
        Swapl s = new Swapl();

        ListNode A = new ListNode(1);
        ListNode B = A;
        ArrayList<Integer> vals = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
        for (int i = 0; i < vals.size(); i++) {
            ListNode temp = new ListNode(vals.get(i));
            B.next = temp;
            B = B.next;
        }

        ListNode result = s.swapPairs(A);

        int m = 5;

    }

}
