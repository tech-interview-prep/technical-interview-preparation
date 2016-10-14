package facebook;

import utils.TreeNode;
import utils.Utils;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 * http://n00tc0d3r.blogspot.com/2013/04/validate-binary-search-tree.html
 */
public class _098ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution_ValidateBinarySearchTree sol = new Solution_ValidateBinarySearchTree();
        Utils.printTestln(sol.isValidBST(TreeNode.getSampleTree()), false);
    }
}

class Solution_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
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

    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) ||
                !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }


    // https://gist.github.com/zac-xin/4349492
    public boolean isValidBST2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean helper(TreeNode root, int max, int min) {
        if (root == null)
            return true;

        if (root.data < max && root.data > min && helper(root.left, root.data, min) &&
                helper(root.right, max, root.data))
            return true;

        return false;
    }
}
