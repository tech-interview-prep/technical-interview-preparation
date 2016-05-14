package leetcode_online_judge.Java;

import java.util.Stack;

import utils.TreeNode;

public class _156BinaryTreeUpsideDown {
    /*
    Given a binary tree where all the right nodes are either leaf nodes with a sibling
    (a left node that shares the same parent node) or empty, flip it upside down and turn
    it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
    For example:
        Given a binary tree {1,2,3,4,5},
                    1
                   / \
                  2   3
                 / \
                4   5
        return the root of the binary tree [4,5,2,#,#,3,1].
                   4
                  / \
                 5   2
                    / \
                   3   1
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode cur = root, parent = null, parentRight = null;
        while (cur != null) {
            TreeNode left = cur.left;
            cur.left = parentRight;
            parentRight = cur.right;
            cur.right = parent;
            parent = cur;
            cur = left;
        }
        return parent;
    }

    public final TreeNode upsideDownBinaryTree2(TreeNode root) {
        // iterative solution using stack
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode left = root;
        while (left != null) {
            st.push(left);
            left = left.left;
        }
        TreeNode head = st.isEmpty() ? null : st.pop();
        TreeNode parent = head;
        while (st.size() > 0) {
            TreeNode t = st.pop();
            parent.right = t;
            parent.left = t.right;
            t.left = t.right = null;
            parent = t;
        }
        return head;
    }

    void preorderPrintTree(TreeNode root) {
        if (root == null)
            System.out.print("#,");
        else {
            System.out.print(root.val + ",");
            preorderPrintTree(root.left);
            preorderPrintTree(root.right);
        }
    }
}
