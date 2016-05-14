package leetcode_online_judge.Java;

import utils.TreeNode;
import utils.Utils;

public class _129SumRootToLeafNumbers {
    /*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    For example,

        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.

    Return the sum = 12 + 13 = 25.
    */
    public static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode node, int pathSum) {
        if (node == null) {
            return 0;
        }

        pathSum = pathSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return pathSum;
        }

        return sumNumbers(node.left, pathSum) + sumNumbers(node.right, pathSum);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
    */
    private static void test() {
        Utils.printTestln(sumNumbers(TreeNode.getSampleTree()), 403);
    }

    public static void main(String[] args) {
        test();
    }
}
