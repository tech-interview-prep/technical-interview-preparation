package leetcode_online_judge.Java;

import utils.TreeNode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _106ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    //end index is exclusive
    private static TreeNode buildTree(int[] inorder, int iS, int iE, int[] postorder, int pS, int pE) {
        if (pS == pE) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pE - 1]);
        int leftSize;
        for (leftSize = 0; inorder[iS + leftSize] != postorder[pE - 1]; leftSize++);
        root.left = buildTree(inorder, iS, iS + leftSize, postorder, pS, pS + leftSize);
        root.right = buildTree(inorder, iS + leftSize + 1, iE, postorder, pS + leftSize, pE - 1);

        return root;
    }

    /*
           1
        /    \
       2      3
     /  \    / \
    4   5   6   7
     */

    private static void test() {
        TreeNode.preOrder(buildTree(new int[] {4, 2, 5, 1, 6, 3, 7}, new int[] {4, 5, 2, 6, 7, 3, 1}));
        //1 2 4 5 3 6 7
    }

    public static void main(String[] args) {
        test();
    }
}
