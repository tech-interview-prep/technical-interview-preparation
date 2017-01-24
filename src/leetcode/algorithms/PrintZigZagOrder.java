package leetcode.algorithms;

import java.util.Stack;

import utils.TreeNode;

/**
 * Print a binary tree in zig zag level order
 *
 * https://gist.github.com/zac-xin/4076432
 */
public class PrintZigZagOrder {
    public static void printZigZagOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        s1.add(root);
        boolean leftToRight = false;

        while (!s1.isEmpty()) {
            TreeNode n = s1.pop();
            System.out.print(n.data + " ");

            if (!leftToRight) {
                if (n.left != null) {
                    s2.push(n.left);
                }
                if (n.right != null) {
                    s2.push(n.right);
                }
            } else {
                if (n.right != null) {
                    s2.push(n.right);
                }
                if (n.left != null) {
                    s2.push(n.left);
                }
            }

            if (s1.isEmpty()) {
                leftToRight = !leftToRight;
                System.out.println();
                tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
        }
    }
}
