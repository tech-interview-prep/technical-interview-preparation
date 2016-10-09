package facebook;

import java.util.Stack;

import utils.TreeNode;

/**
 * Preorder traversal of a binary tree
 *
 * https://gist.github.com/tangkangkai/9968025
 * https://gist.github.com/thorikawa/5500905
 *
 */
public class TreeTraversal_Preorder {
    // Pre-Order recursion
    public void preOrderRecursion(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    // Pre-Order interation
    public void preOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.print(current.data + "  ");// print the data when
                // pushed into the stack
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    public void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void preorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode node = null;

        while (!stack.empty()) {
            if (node == null) {
                node = stack.pop();
            }
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }
    }
}
