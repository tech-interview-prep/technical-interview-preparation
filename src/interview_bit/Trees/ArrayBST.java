package interview_bit.trees;
import java.util.*;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/16/15.
 *
 * Problem statement
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : [1, 2, 3]
 A height balanced BST  :

   2
 /   \
 1     3

 */
public class ArrayBST {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        TreeNode root = makeBST(a,0,a.size()-1);
        return root;

    }

    public TreeNode makeBST(List<Integer> a,int lo,int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo + hi)/2;
        TreeNode x = new TreeNode(a.get(mid));
        x.left = makeBST(a,lo,mid-1);
        x.right = makeBST(a,mid+1,hi);
        return x;

    }
}

