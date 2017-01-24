package leetcode.algorithms;

import utils.TreeNode;
import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class _101SymmetricTree {
    /*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.

    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
    */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == null && rightNode == null;
        }

        return leftNode.data == rightNode.data
               && isSymmetric(leftNode.left, rightNode.right)
               && isSymmetric(leftNode.right, rightNode.left);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printTestln(isSymmetric(TreeNode.getSampleTree()), false);
    }

    public static void main(String[] args) {
        test();
    }
}
