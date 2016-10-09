package facebook;

import java.util.Stack;

import utils.TreeNode;

/**
 * Postorder traversal of a binary tree
 *
 * https://gist.github.com/tangkangkai/9968025
 * https://gist.github.com/thorikawa/5500905
 *
 */
public class TreeTraversal_Postorder {
    // Post-Order Recursion
    public void postOrderRecursion(TreeNode root) {
        if (root != null) {
            postOrderRecursion(root.left);
            postOrderRecursion(root.right);
            System.out.print(root.data + "  ");
        }

    }

    // Post-Order Iteration
    public void postOrderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (current.isFinished) { // we use isFinished as a flag to see
                    // if both of the children have been
                    // visited.
                    System.out.print(current.data + "  ");
                    current = null;
                } else {
                    current.isFinished = true;
                    stack.push(current);
                    current = current.right;
                }
            }
        }
    }

    public void postorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        TreeNode prevNode = null;

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            if (prevNode == null || prevNode.left == curNode || prevNode.right == curNode) {
                // Come from parent
                if (curNode.left != null) {
                    stack.push(curNode.left);
                } else if (curNode.right != null) {
                    stack.push(curNode.right);
                }
            } else if (prevNode == curNode.left) {
                // Back from left child
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
            } else {
                // Back from right child or stay (which means there is no child
                // to be visited). Either way, it means no more explore.
                System.out.print(node.data + "  ");
                stack.pop();
            }
            prevNode = curNode;
        }
    }
}
