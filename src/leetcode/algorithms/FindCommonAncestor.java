/*
    Design an algorithm to find common ancestor of two nodes in a binary tree. Avoid storing addistional nodes in a data
    structure.

    NOTE: This is not necessarily a binary search tree.

     https://gist.github.com/zac-xin/2641366

*/
package leetcode.algorithms;

import utils.TreeNode;

public class FindCommonAncestor {

    // O(N) subtrees searched over and over
    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        boolean is_p_on_left = covers(root.left, p);
        boolean is_q_on_left = covers(root.left, q);
        if (is_p_on_left != is_q_on_left) { // Nodes are on different side
            return root;
        }
        TreeNode child_side = is_p_on_left ? root.left : root.right;
        return commonAncestorHelper(child_side, p, q);
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
            return null;
        }
        return commonAncestorHelper(root, p, q);
    }

    // ------------------ Optimized -------------------- //
    public static class Result {
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    public static Result commonAncestorHelper_O(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper_O(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper_O(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            /* If we're currently at p or q, and we also found one of those
             * nodes in a subtree, then this is truly an ancestor and the
             * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor_O(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper_O(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }
}
