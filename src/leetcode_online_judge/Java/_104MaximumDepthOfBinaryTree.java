package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author bkoteshwarreddy
 */
public class _104MaximumDepthOfBinaryTree {
    /*
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    private static void test() {
        Utils.printTestln(maxDepth(TreeNode.getSampleTree()), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
