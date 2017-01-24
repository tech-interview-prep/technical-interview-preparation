package interviewBit.trees;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 *
 * Problem statement
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example :

 Input :
   1
  / \
 2   3

 Output : 0 or False


 Input :
   2
  / \
 1   3

 Output : 1 or True
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidBST {
    public int isValidBST(TreeNode a) {
        boolean val = isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (val) {
            return 1;
        } else {
            return 0;
        }

    }

    public boolean isBST(TreeNode a, int minVal, int maxVal) {
        if (a == null)
            return true;

        if (a.data >= maxVal || a.data <= minVal ) {
            return false;
        }

        return isBST(a.left, minVal, a.data) && isBST(a.right, a.data, maxVal);
    }

    public static void main(String[] args) {
        ValidBST v = new ValidBST();
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        int result = v.isValidBST(a);
        System.out.println(result);
    }
}
