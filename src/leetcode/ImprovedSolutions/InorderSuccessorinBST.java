package leetcode.ImprovedSolutions;

import utils.TreeNode;
import utils.TreeNodeWithParent;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorinBST {
}

class Solution_InorderSuccessorinBST {
    // With parent pointer
    public static TreeNodeWithParent inorderSuccessor(TreeNodeWithParent n) {
        if (n == null) return null;

        // Found right children -> return left most node of right subtree
        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNodeWithParent q = n;
            TreeNodeWithParent x = q.parent;
            // Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNodeWithParent leftMostChild(TreeNodeWithParent right) {
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    public TreeNodeWithParent inorderSuccessor(TreeNodeWithParent root, TreeNodeWithParent p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNodeWithParent left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    /**
     * The inorder traversal of a BST is the nodes in ascending order. To find a successor, you just need to find the
     * smallest one that is larger than the given value since there are no duplicate values in a BST. It just like the
     * binary search in a sorted list. The time complexity should be O(h) where h is the depth of the result node. succ
     * is a pointer that keeps the possible successor. Whenever you go left the current root is the new possible
     * successor, otherwise the it remains the same.
     *
     * Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.
     *
     * Time: O(h), Space: O(1)
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}
