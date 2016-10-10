/*
    Build Tree From Inorder and Preorder

     https://gist.github.com/zac-xin/4015124
          http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

*/
package facebook;

import utils.TreeNode;

public class BuildTreeFromInorderAndPreorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int s1, int t1, int[] inorder, int s2, int t2) {
        if (s1 > t1) {
            return null;
        }
        int data = preorder[s1];
        int i = s2;
        while (inorder[i] != data) {
            i++;
        }

        int leftCount = i - s2;
        TreeNode root = new TreeNode(data);
        root.left = build(preorder, s1 + 1, s1 + leftCount, inorder, s2, s2 + i - 1);
        root.right = build(preorder, s1 + leftCount + 1, t1, inorder, i + 1, t2);

        return root;
    }
}
