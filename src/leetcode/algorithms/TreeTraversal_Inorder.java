package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Stack;
import utils.TreeNode;

/**
 * Inorder traversal of a binary tree
 *
 * http://n00tc0d3r.blogspot.com/2013/09/inorder-binary-tree-traversal-with.html
 * https://gist.github.com/tangkangkai/9968025
 * https://gist.github.com/thorikawa/5500905
 */
public class TreeTraversal_Inorder {
    // In-Order recursion
    public void inOrderRecursion(TreeNode root) {
        if (root != null) {
            inOrderRecursion(root.left);
            System.out.print(root.data + "  ");
            inOrderRecursion(root.right);
        }
    }

    // In-Order Iteration
    public void inOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data + "  ");// print the data when
                // popped out of stack
                current = current.right;
            }
        }
    }

    public void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                // No need to explore
                node = stack.pop();
                System.out.print(node.data + "  ");
                node = node.right;
            } else {
                // Explore more
                stack.push(node);
                node = node.left;
            }
        }
    }

    public void inorderMorris(TreeNode root, ArrayList<Integer> values) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) { // set right to successor
                    pre.right = current;
                    current = current.left;
                } else { // visit and revert the change
                    pre.right = null;
                    values.add(current.data);
                    current = current.right;
                }
            } else { // visit and move to successor
                values.add(current.data);
                current = current.right;
            }
        }
    }
}
