package interviewBit.graphs;

import java.util.ArrayList;

import utils.ListNode;
import utils.TreeNode;

/**
 * Created by priyavivek on 11/27/15.
 *
 * Problem statement
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : 1 -> 2 -> 3
 A height balanced BST  :

     2
   /   \
  1     3
 *
 */
public class List2tree {
    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> listElems = new ArrayList<Integer>();

        ListNode aCopy = a;
        while(aCopy != null){
            listElems.add(aCopy.data);
            aCopy = aCopy.next;
        }

        return constructTree(listElems,0,listElems.size()-1);

    }


    public TreeNode constructTree(ArrayList<Integer> listElems,int lo,int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo+hi)/2;

        TreeNode root = new TreeNode(listElems.get(mid));
        root.left = constructTree(listElems,lo,mid-1);
        root.right = constructTree(listElems,mid+1,hi);

        return root;

    }


}
