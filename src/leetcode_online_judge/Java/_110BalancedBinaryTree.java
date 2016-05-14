package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

public class _110BalancedBinaryTree {
    /*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
    of every node never differ by more than 1.
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    private static void test() {
        Utils.printTestln(isBalanced(TreeNode.getSampleTree()), true);
    }

    public static void main(String[] args) {
        test();
    }
}
