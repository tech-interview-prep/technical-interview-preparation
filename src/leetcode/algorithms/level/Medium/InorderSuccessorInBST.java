package leetcode.algorithms.level.Medium;

import java.util.Stack;

import utils.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorinBST {
}

class Solution_InorderSuccessorinBST {
    // Time is O(n), Space is O(n).
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null || p == null)
            return null;

        stack.push(root);
        boolean isNext = false;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.right == null && top.left == null) {
                if (isNext) {
                    return top;
                }

                if (p.data == top.data) {
                    isNext = true;
                }
                continue;
            }

            if (top.right != null) {
                stack.push(top.right);
                top.right = null;
            }

            stack.push(top);

            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            }
        }

        return null;
    }

    // Time is O(log(n)) and space is O(1).
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        TreeNode next = null;
        TreeNode c = root;
        while (c != null && c.data != p.data) {
            if (c.data > p.data) {
                next = c;
                c = c.left;
            } else {
                c = c.right;
            }
        }

        if (c == null)
            return null;

        if (c.right == null)
            return next;

        c = c.right;
        while (c.left != null)
            c = c.left;

        return c;
    }

    // in binary search tree
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.data <= p.data) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);
        return (left == null) ? root : left;
    }
}
