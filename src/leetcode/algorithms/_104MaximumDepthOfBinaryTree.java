package leetcode.algorithms;

import java.util.LinkedList;

import utils.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 * http://www.careercup.com/question?id=5735068173598720
 * http://n00tc0d3r.blogspot.com/2013/04/maximum-depth-of-binary-tree.html
 */
public class _104MaximumDepthOfBinaryTree {

}

class Solution_MaximumDepthOfBinaryTree {
    public int maxDepth_Recursive(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth_Recursive(root.left), maxDepth_Recursive(root.right));
    }

    public int maxDepth_Iterative(TreeNode root) {
        int len = 0;
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        if (root != null) {
            que.addLast(root);
            que.addLast(null); // add a special node for level breaker
        }

        while (!que.isEmpty()) {
            TreeNode cur = que.removeFirst();
            if (cur == null) { // finish one level
                ++len;
                if (!que.isEmpty()) que.addLast(null);
            } else {
                if (cur.left != null) que.addLast(cur.left);
                if (cur.right != null) que.addLast(cur.right);
            }
        }

        return len;
    }
}
