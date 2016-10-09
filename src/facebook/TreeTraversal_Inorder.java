package facebook;

import java.util.Stack;

import utils.TreeNode;

/**
 * Inorder traversal of a binary tree
 *
 * https://gist.github.com/tangkangkai/9968025
 * https://gist.github.com/thorikawa/5500905
 *
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
}
