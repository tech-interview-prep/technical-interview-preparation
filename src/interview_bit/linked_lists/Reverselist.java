package interview_bit.linked_lists;

import java.util.ArrayList;
import java.util.Arrays;

import utils.ListNode;

/**
 * Created by priyavivek on 11/5/15.
 *
 * Problem statement
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list. Note 2:
 Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
public class Reverselist {
    public ListNode reverseBetween(ListNode a, int m, int n) {

        ListNode aCopy = a;

        //Move pointer to right before the mth node
        ListNode prev;
        int count = 0;
        if(m == 1){
            prev = null;
        }else{
            prev = null;

            while(count < m-1){
                prev = aCopy;
                aCopy = aCopy.next;
                count++;
            }
        }

        count = 0;

        ListNode t = null;
        ListNode subTail = null;
        ListNode subHead = null;

        //Find the new head and tail of the reversed linked list between m and n.
        // Connect the new head to the node before m and the new tail to the node right after n

        while(count <= n-m){
            ListNode temp = aCopy.next;
            aCopy.next = t;
            if(t == null){
                subTail = aCopy;
            }
            t = aCopy;

            if(count == n-m){
                subHead = aCopy;
            }

            aCopy = temp;
            count++;
        }

        //Check to see if m = 1. If not, add the new head of the reversed sub-list to node before m.
        if(prev != null){
            prev.next = subHead;
        }

        //Connect tail to node after n.
        subTail.next = aCopy;

        if(m > 1){
            return a;
        }else {
            return subHead;
        }
    }

    public static void main(String[] args){

       Reverselist r = new Reverselist();

        ListNode A = new ListNode(1);
        ListNode B = A;
        ArrayList<Integer> vals = new ArrayList<Integer>(Arrays.asList(2,3,4,5));
        for(int i=0;i<vals.size();i++){
            ListNode temp = new ListNode(vals.get(i));
            B.next = temp;
            B=B.next;
        }

        ListNode result = r.reverseBetween(A,1,5);

        int x = 9;


    }

}
