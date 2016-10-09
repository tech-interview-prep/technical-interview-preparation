package leetcode_online_judge.Java;

import utils.TreeNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    private static TreeNode buildTree(int[] preorder, int ps, int[] inorder, int is, int length) {
        if (length == 0) {
            return null;
        }
        int midIdx;
        for (midIdx = 0; midIdx < length && inorder[midIdx + is] != preorder[ps]; midIdx++);
        TreeNode midNode = new TreeNode(preorder[ps]);
        midNode.left = buildTree(preorder, ps + 1, inorder, is, midIdx);
        midNode.right = buildTree(preorder, ps + midIdx + 1, inorder, is + midIdx + 1, length - midIdx - 1);

        return midNode;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        TreeNode.inOrder(buildTree(new int[] {1, 2, 3, 4, 5, 6}, new int[] {3, 2, 4, 1, 5, 6}));
//        TreeNode.inOrder(buildTree(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    public static void main(String[] args) {
        test();
    }
}
