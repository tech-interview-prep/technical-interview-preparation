package interviewBit.linkedLists;

import java.util.ArrayList;
import java.util.Arrays;

import utils.ListNode;

/**
 * Created by priyavivek on 11/5/15.
 *
 * Problem statement
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Partitionlist {
    public ListNode partition(ListNode a, int b) {

        ListNode endNode = a;
        ListNode prevNode = a;
        int llSize = 0;

        //Find the size of the linked list and also move pointer to the last element in the linked list.
        while(endNode != null){
            prevNode = endNode;
            endNode = endNode.next;
            llSize++;
        }
        endNode = prevNode;

        if(llSize == 1){
            return a;
        }


        ListNode head = a;
        prevNode = a;
        boolean headFound = false;
        int count = 0;

        //Perhaps not the easiest way to implement this. Might be easier to maintain 2 pointers to 2 lists - less than and greater than or equal to.
        //Traverse the list and move all the nodes greater than or equal to the given value to the end of the linked list.
        //After moving a node to the end, ensure the nodes just before it and just after it are connected.

        while(count < llSize){
            while(a.data >= b && count < llSize){
                endNode.next = a;
                endNode = endNode.next;

                //Worry about connecting a previous node only if a value less than the given value has been found. In other words, if  a head node has been found.
                if(headFound){
                    prevNode.next = a.next;
                }
                a = a.next;
                endNode.next = null;
                count++;
            }


            if(a.data < b){
                if(!headFound){
                    head = a;
                    headFound = true;
                }
                prevNode = a;
                a = a.next;
                count++;
            }




        }

        return head;


    }

    public static void main(String[] args){
        Partitionlist p = new Partitionlist();

        ListNode A = new ListNode(593);
        ListNode B = A;
        ArrayList<Integer> vals = new ArrayList<Integer>(Arrays.asList(475,351,395,562,2,649,790,336,698,444,18,767,31,547,561,113,379,445,7,460,131,984,829,883,729,726,540,560,875,481,586,196,742, 951,754,666,874,241,623,881,433,51,463,895,179,712,873));
        for(int i=0;i<vals.size();i++){
            ListNode temp = new ListNode(vals.get(i));
            B.next = temp;
            B=B.next;
        }

        ListNode result = p.partition(A,79);

        int m=9;

    }
}
