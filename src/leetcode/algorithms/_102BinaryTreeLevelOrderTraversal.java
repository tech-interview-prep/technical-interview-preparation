package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _102BinaryTreeLevelOrderTraversal {
    /*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
    */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                level.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                ret.add(level);
                if (!queue.isEmpty()) {
                    level = new ArrayList<Integer>();
                    queue.add(null);
                }
            }
        }

        return ret;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printListListln(levelOrder(TreeNode.getSampleTree()));
    }

    public static void main(String[] args) {
        test();
    }
}
