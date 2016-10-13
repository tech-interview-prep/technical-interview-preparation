package facebook;

import utils.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
 */
public class _298BinaryTreeLongestConsecutiveSequence {

}

class Solution_BinaryTreeLongestConsecutiveSequence {
    int max = 0;
    public void helper(TreeNode root, int curLen, int target) {
        if (root == null) return;
        curLen = (target == root.data) ? curLen + 1 : 1;
        // find max length through dfs traversal
        max = Math.max(curLen, max);
        // DFS
        helper(root.left, curLen, root.data + 1);
        helper(root.right, curLen, root.data + 1);
    }
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.data);
        return max;
    }
}
