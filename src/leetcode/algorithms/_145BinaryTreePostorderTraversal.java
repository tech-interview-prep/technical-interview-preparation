package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Stack;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _145BinaryTreePostorderTraversal {
    /*
    Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [3,2,1].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root, preNode = null;

        while (!s.isEmpty() || node != null) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    ret.add(node.data);
                    if (s.isEmpty()) {
                        return ret;
                    }
                    preNode = node;
                    node = s.pop();
                }

                if (preNode == null || node.right != preNode && (node.right != null || node.left != preNode)) {
                    s.add(node);
                    if (node.right != null) {
                        s.add(node.right);
                    }
                    node = node.left;
                } else {
                    ret.add(node.data);
                    if (s.isEmpty()) {
                        return ret;
                    }
                    preNode = node;
                    node = s.pop();
                }
            }  else {
                node = s.pop();
                preNode = null;
            }
        }

        return ret;
    }

    private static ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root != null) {
            s.add(root);
        }
        TreeNode preNode = null;

        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            if (node.left == null && node.right == null || preNode != null && (node.left == preNode || node.right == preNode)) {
                ret.add(node.data);
                preNode = node;
                node = s.pop();
            } else {
                if (node.right != null) {
                    s.add(node.right);
                }
                if (node.left != null) {
                    s.add(node.left);
                }
            }
        }

        return ret;
    }

    private static ArrayList<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode preNode = null, node = root;

        while (!s.isEmpty() || node != null) {
            if (node == null) {
                node = s.pop();
            } else if (node.left == null && node.right == null || preNode != null && (node.left == preNode || node.right == preNode)) {
                ret.add(node.data);
                if (s.isEmpty()) {
                    return ret;
                }
                preNode = node;
                node = s.pop();
            } else {
                s.add(node);
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
    private static void test() {
        Utils.printListln(postorderTraversal(TreeNode.getSampleTree()));
        Utils.printListln(postorderTraversal(sampleTree()));
        Utils.printListln(postorderTraversal(sampleTree2()));

        Utils.printListln(postorderTraversal2(TreeNode.getSampleTree()));
        Utils.printListln(postorderTraversal2(sampleTree()));
        Utils.printListln(postorderTraversal2(sampleTree2()));

        Utils.printListln(postorderTraversal3(TreeNode.getSampleTree()));
        Utils.printListln(postorderTraversal3(sampleTree()));
        Utils.printListln(postorderTraversal3(sampleTree2()));
    }

    private static TreeNode sampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }

    private static TreeNode sampleTree2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static void main(String[] args) {
        test();
    }
}
