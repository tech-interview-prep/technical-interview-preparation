package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;
import utils.Utils;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * return its bottom-up level order traversal as:
 *  [
 *      [15,7]
 *      [9,20],
 *      [3],
 *  ]
 *
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * http://n00tc0d3r.blogspot.com/2013/01/binary-tree-traversals-ii.html
 */
public class _107BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Solution_BinaryTreeLevelOrderTraversalII sol = new Solution_BinaryTreeLevelOrderTraversalII();
        for (ArrayList<Integer> iL : sol.levelOrderBottom(TreeNode.getSampleTree())) {
            Utils.printIntListln(iL);
        }
    }
}

class Solution_BinaryTreeLevelOrderTraversalII {
    /**
     * Use a level list to store the nodes of this level
     * addRecursive root to it to begin
     * Build next level with current level, add current level value to result
     * Assign next level to current level
     * addRecursive curLevel to first of result each time to get reverse order
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;

        /*store the nodes of this level*/
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curLevel = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                curLevel.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            result.add(0, curLevel);
        }

        return result;
    }
}
