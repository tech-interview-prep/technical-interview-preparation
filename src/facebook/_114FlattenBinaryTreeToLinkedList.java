package facebook;

import java.util.Stack;

import utils.TreeNode;

/**
 * Given a Binary Tree (balanced or not) write a method that transforms the tree in a degenerate tree (basically a
 * data structure like a sorted linked list where each node has the left child null) and returns the new root. This
 * must be made in place, no external memory usage is allowed.
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *            1
 *           / \
 *          2   5
 *         / \   \
 *        3   4   6
 *
 * The flattened tree should look like:
 *      1
 *       \
 *        2
 *         \
 *          3
 *           \
 *            4
 *             \
 *              5
 *               \
 *                6
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 * https://gist.github.com/bittib/5697095
 * http://www.careercup.com/question?id=6241652616200192
 * http://n00tc0d3r.blogspot.com/2013/03/flatten-binary-tree-to-linked-list-in.html
 */
public class _114FlattenBinaryTreeToLinkedList {
}

class Solution_FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode root) {
        return flatten(root, null);
    }

    TreeNode flatten(TreeNode cur, TreeNode next) {
        if (cur == null) return next;
        next = flatten(cur.right, next);
        next = flatten(cur.left, next);
        cur.right = next;
        cur.left = null;
        return cur;
    }

    /*
     * Iterative version
     */
    public void flatten_Iterative(TreeNode root) {
        if (root == null) return;
        TreeNode prev = null, cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
            if (prev != null) {
                prev.right = cur;
                prev.left = null;
            }
            prev = cur;
        }
    }
}
