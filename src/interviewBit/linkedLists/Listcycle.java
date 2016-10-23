package interviewBit.linkedLists;

import utils.ListNode;

/**
 * Created by priyavivek on 11/6/15.
 *
 * Problem statement
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Try solving it using constant additional space.

 Example :

 Input :

 ______
 |     |
 \/    |
 1 -> 2 -> 3 -> 4

 Return the node corresponding to node 3.
 */
public class Listcycle {
    public ListNode detectCycle(ListNode a) {
        ListNode fastPointer = a;
        ListNode slowPointer = a;

        //The fast pointer moves ahead by 2 nodes each time, while the slow pointer moves ahead by 1 node

        while(true){
            //If the fast pointer reaches a null node it implies that there are no loops
            if(fastPointer == null || fastPointer.next == null){
                return null;
            }

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            //Point at which the fast and slow pointers point to the same node
            if(fastPointer == slowPointer){
                break;
            }
        }

        //Move the head pointer and the slow pointer 1 step at a time. The point at which they meet is the start of the loop

        while(a != slowPointer){
            a = a.next;
            slowPointer = slowPointer.next;
        }

        return a;
    }

    public static void main(String[] args){
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = C;

        Listcycle lc = new Listcycle();

        ListNode result = lc.detectCycle(A);

        int m = 5;
    }
}
