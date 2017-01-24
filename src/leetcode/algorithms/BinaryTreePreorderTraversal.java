package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Stack;

import utils.TreeNode;
import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class BinaryTreePreorderTraversal {
    /*
    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node == null) {
                node = s.pop();
            } else {
                ret.add(node.data);
                if (node.right != null) {
                    s.add(node.right);
                }
                node = node.left;
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
    public static void test() {
        Utils.printListln(preorderTraversal(TreeNode.getSampleTree()));
    }

    public static void main(String[] args) {
        test();
    }
}
