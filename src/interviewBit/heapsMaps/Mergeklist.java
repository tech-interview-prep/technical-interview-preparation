package interviewBit.heapsMaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

import utils.ListNode;


/**
 * Created by priyavivek on 11/22/15.
 *
 * Problem statement
 *
 * Merge k sorted linked lists and return it as one sorted list.

 Example :

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 will result in

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class Mergeklist {
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ListNode result = new ListNode(0);
        ListNode  root = result;

        //Insert all elements in all lists in to a min heap
        for (int i = 0; i < a.size(); i++) {
            ListNode currNode = a.get(i);
            while(currNode != null) {
                minHeap.add(currNode.data);
                currNode = currNode.next;
            }
        }

        //Until the min heap is empty get the head and insert in to linked list
        while (!minHeap.isEmpty()){
            ListNode temp = new ListNode((int )minHeap.poll());
            result.next = temp;
            result = result.next;
        }

        return root.next;

    }

    public static void main(String[] args){
        Mergeklist m = new Mergeklist();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(20);
        b.next = c;
        a.next = b;


        ListNode d = new ListNode(4);
        ListNode e = new ListNode(11);
        ListNode f = new ListNode(13);

        e.next = f;
        d.next = e;

        ListNode g = new ListNode(3);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);

        h.next = i;
        g.next = h;

        ArrayList<ListNode> ip = new ArrayList<>();
        ip.add(a);
        ip.add(d);
        ip.add(g);

        ListNode result = m.mergeKLists(ip);
    }
}
