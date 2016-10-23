package interviewBit.linkedLists;

import java.util.ArrayList;
import java.util.Arrays;

import utils.ListNode;

/**
 * Created by priyavivek on 11/2/15.
 *
 * Problem statement
 *
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

 Notes:
 - Expected solution is linear in time and constant in space.

 For example,

 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.
 */
public class Lpalin {
    public int lPalin(ListNode A) {
        int llSize = 0;
        ListNode B = A;
        while(B != null ){
            B=B.next;
            llSize++;
        }

        if(llSize == 1){
            return 1;
        }

        ListNode headList2;
        ListNode tailList1;

        //There is a middle node only if the size of the linkedlist is odd
        ListNode middleNode = null;
        int linkCount = 0;

        B=A;

        //Reverse the second half of the linked list. When the size of the linked list is odd track the middle element separately.
        if(llSize%2==0){
            while(linkCount != (llSize/2) - 1){
                B = B.next;
                linkCount++;
            }
            ListNode temp;
            temp = B.next;
            B.next = null;
            tailList1 = B;

            headList2 = reverseLinkedList(temp);
        }else{
            while(linkCount != (llSize -1)/2 - 1 ){
                B = B.next;
                linkCount++;
            }

            middleNode = B.next;
            ListNode temp = middleNode.next;
            B.next = null;
            middleNode.next = null;
            tailList1 = B;

            headList2 = reverseLinkedList(temp);
        }

        //Compare the linked lists in the first and second halves

        int result;
        if(compareLinkedLists(A,headList2)){
            result = 1;
        }else{
            result = 0;
        }

        //Since the input linked list was changed, return it to its original state

        headList2 = reverseLinkedList(headList2);
        if(llSize % 2 == 0){
            tailList1.next = headList2;
        }else{
            tailList1.next = middleNode;
            middleNode.next = headList2;
        }

        return result;





    }

    public ListNode reverseLinkedList(ListNode A){
        ListNode prev = null;
        while(A!=null){
            ListNode temp = A.next;
            A.next = prev;
            prev = A;
            A = temp;
        }

        return prev;

    }

    public boolean compareLinkedLists(ListNode head1,ListNode head2){
        while(head1 != null && head2!= null){
            if(head1.data !=head2.data){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1 != null || head2 != null){
            return false;
        }

        return true;




    }

    public static void main(String[] args){
        ListNode A = new ListNode(4);
        //ListNode B = new ListNode(2);
        //ListNode C = new ListNode(3);
        ListNode B = A;
        ArrayList<Integer> vals = new ArrayList<Integer>(Arrays.asList(4,2,1,3,5,5,1,5,4,3,1,3,3,1,3,4,4,2,2,5,4,2,1,3,3,1,3,4,5,1,5,5,3,1,2,4));
        for(int i=1;i<vals.size();i++){
            ListNode temp = new ListNode(vals.get(i));
            B.next = temp;
            B=B.next;
        }

       // A.next = B;
       // B.next = C;

        Lpalin lp = new Lpalin();

        int result = lp.lPalin(A);

        System.out.println(result);

    }
}
