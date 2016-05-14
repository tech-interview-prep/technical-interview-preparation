package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

public class _112PathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    */
    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private static boolean hasPathSum(TreeNode root, int target, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;
        if (root.left == null && root.right == null) {
            return target == currentSum;
        }

        return hasPathSum(root.left, target, currentSum) || hasPathSum(root.right, target, currentSum);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printTestln(hasPathSum(TreeNode.getSampleTree(), 6), true);
        Utils.printTestln(hasPathSum(TreeNode.getSampleTree(), 8), false);
    }

    public static void main(String[] args) {
        test();
    }
}
