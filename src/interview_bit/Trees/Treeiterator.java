package interview_bit.trees;
import java.util.*;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/29/15.
 *
 * Problem statement
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 Try to optimize the additional space complexity apart from the amortized time complexity.
 */
public class Treeiterator {

    ArrayList<Integer> inOrderList = new ArrayList<>();
    int currIndex = 0;
    public Treeiterator(TreeNode root){
        inOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);

        inOrderList.add(root.data);

        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(currIndex < inOrderList.size()){
            return true;
        }

        return false;
    }

    /** @return the next smallest number */
    public int next() {
        int result = -1;
        if(hasNext()){
            result = inOrderList.get(currIndex);
            currIndex++;
        }

        return result;
    }
}

