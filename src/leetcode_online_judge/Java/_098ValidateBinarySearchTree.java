package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _098ValidateBinarySearchTree {
    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftMax = Integer.MIN_VALUE, rightMin = Integer.MAX_VALUE;
        TreeNode node = root.left;
        while (node != null ) {
            leftMax = node.data;
            node = node.right;
        }
        if (leftMax > root.data) {
            return false;
        }

        node = root.right;
        while (node != null) {
            rightMin = node.data;
            node = node.left;
        }

        return rightMin > root.data && isValidBST(root.left) && isValidBST(root.right);
    }

    private static void test() {
        Utils.printTestln(isValidBST(TreeNode.getSampleTree()), false);
    }

    public static void main(String[] args) {
        test();
    }
}
