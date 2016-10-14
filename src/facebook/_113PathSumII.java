package facebook;

import utils.TreeNode;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum
 * up to that value. Note that it can be any path in the tree it does not have to start at the root.
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *
 * return
 *     [
 *         [5,4,11,2],
 *         [5,8,4,5]
 *     ]
 *
 * https://leetcode.com/problems/path-sum-ii/
 * https://gist.github.com/zac-xin/2650564
 * http://n00tc0d3r.blogspot.com/2013/01/tree-path-sum.html
 */
public class _113PathSumII {
}

class Solution_PathSumII {
    public void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        /* Insert current node into path */
        path[level] = node.data;

        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        /* Remove current node from path. Not strictly necessary, since we would
         * ignore this value, but it's good practice.
         */
        path[level] = Integer.MIN_VALUE;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    public void findSum(TreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    private void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}
