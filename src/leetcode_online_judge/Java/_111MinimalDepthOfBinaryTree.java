package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

import java.util.Queue;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _111MinimalDepthOfBinaryTree {
    /*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static int minDepthIter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        int depth = 1;
        TreeNode node;

        while (!queue.isEmpty()) {
            while ((node = queue.remove()) != null) {
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (!queue.isEmpty()) {
                queue.add(null);
                depth++;
            }
        }
        return depth;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printTestln(minDepth(TreeNode.getSampleTree()), 3);
        Utils.printTestln(minDepthIter(TreeNode.getSampleTree()), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
