package interviewBit.linkedLists;

import java.util.ArrayList;

import utils.ListNode;

/**
 * Created by priyavivek on 11/3/15.
 *
 * Problem statement
 *
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 342 + 465 = 807
 Make sure there are no trailing zeros in the output list
 So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class Addnum {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        if(a == null && b ==null){
            return null;
        }

        if(a == null){
            return b;
        }else if(b == null){
            return a;
        }

        ListNode aCopy = a;
        ListNode bCopy = b;

        int carry = 0;

        ArrayList<Integer> vals = new ArrayList<Integer>();

        while(aCopy != null && bCopy != null){
            vals.add((aCopy.data + bCopy.data + carry) % 10);
            carry = (aCopy.data + bCopy.data + carry)/10;
            aCopy = aCopy.next;
            bCopy = bCopy.next;

        }

        //Handle cases when the length of 1 linked list is longer than the other

        while(aCopy !=null){
            vals.add((aCopy.data + carry) % 10);
            carry = (aCopy.data + carry)/10;
            aCopy = aCopy.next;
        }

        while(bCopy !=null){
            vals.add((bCopy.data + carry) % 10);
            carry = (bCopy.data + carry)/10;
            bCopy = bCopy.next;
        }

        //Check if carry from last addition is a non-zero number
        if(carry != 0){
            vals.add(carry);
        }

        //Remove trailing zeros
        int sizeCount = vals.size();
        for(int j=vals.size()-1;j>=0;j--){
            if(vals.get(j) != 0){
                sizeCount = j;
                break;
            }
        }

        //Create a linked list with the results calculated above

        ListNode resultHead  = new ListNode(vals.get(0));
        ListNode result;

        result = resultHead;

        for(int i=1;i<=sizeCount;i++){
            ListNode temp = new ListNode(vals.get(i));
            result.next = temp;
            result = result.next;

        }

        return resultHead;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);

        Addnum a = new Addnum();

        ListNode result = a.addTwoNumbers(l4,l1);

        int m = 4;
    }
}
