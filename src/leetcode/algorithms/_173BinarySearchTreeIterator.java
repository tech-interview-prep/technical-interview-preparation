package leetcode.algorithms;

import java.util.LinkedList;

import utils.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class _173BinarySearchTreeIterator {
}

class BSTIterator {
    LinkedList<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        stack = new LinkedList<TreeNode>();
        while (cur != null) {
            stack.addFirst(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.poll();
        TreeNode cur = top.right;
        while (cur != null) {
            stack.addFirst(cur);
            cur = cur.left;
        }
        return top.data;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
