/*
    Build Tree From Inorder and Preorder

     https://gist.github.com/zac-xin/4015124
          http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

*/
package leetcode.algorithms;

import utils.TreeNode;

public class BuildTreeFromInorderAndPreorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int data = preorder[preStart];
        int i = inStart;
        while (inorder[i] != data) {
            i++;
        }

        int leftCount = i - inStart;
        TreeNode root = new TreeNode(data);
        root.left = build(preorder, preStart + 1, preStart + leftCount, inorder, inStart, inStart + i - 1);
        root.right = build(preorder, preStart + leftCount + 1, preEnd, inorder, i + 1, inEnd);

        return root;
    }
}
