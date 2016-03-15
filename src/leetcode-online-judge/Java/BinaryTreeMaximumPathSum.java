package leetcode_online_judge;

import utils.Utils;

public class BinaryTreeMaximumPathSum {
    /*
    Given a binary tree, find the maximum path sum.

    The path may start and end at any node in the tree.

    For example:
    Given the below binary tree,

           1
          / \
         2   3
    Return 6.
     */
    public static int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root)[0];
    }

    //int[0] is the maxPathSum with root at node, int[1] is the maxPathSum with from ancestor nodes to root
    private static int[] maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE, 0};
        }

        int[] leftMax = maxPathSumHelper(node.left);
        int[] rightMax = maxPathSumHelper(node.right);

        int[] ret = new int[2];
        
        ret[0] = Math.max(Math.max(leftMax[0], rightMax[0]), Math.max(leftMax[1], 0) + Math.max(rightMax[1], 0) + node.val);
        ret[1] = Math.max(Math.max(leftMax[1], rightMax[1]), 0) + node.val;

        return ret;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    private static void test() {
        Utils.printTestln(maxPathSum(TreeNode.getSampleTree()), 18);
        Utils.printTestln(maxPathSum(new TreeNode(-3)), -3);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        Utils.printTestln(maxPathSum(root), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
