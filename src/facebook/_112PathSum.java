package facebook;

import utils.TreeNode;
import utils.Utils;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * https://leetcode.com/problems/path-sum
 * http://n00tc0d3r.blogspot.com/2013/01/tree-path-sum.html
 */
public class _112PathSum {
    public static void main(String[] args) {
    	Solution_PathSum sol = new Solution_PathSum();
        Utils.printTestln(sol.hasPathSum(TreeNode.getSampleTree(), 6), true);
        Utils.printTestln(sol.hasPathSum(TreeNode.getSampleTree(), 8), false);
    }
}

class Solution_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int target, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.data;
        if (root.left == null && root.right == null) {
            return target == currentSum;
        }

        return hasPathSum(root.left, target, currentSum) || hasPathSum(root.right, target, currentSum);
    }
}
