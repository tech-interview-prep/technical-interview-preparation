package leetcode_online_judge.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _107BinaryTreeLevelOrderTraversalII {
    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7]
      [9,20],
      [3],
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
     */
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> thislevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        thislevel.add(root);

        while (!thislevel.isEmpty()) {
            ArrayList<Integer> data = new ArrayList<Integer>();

            while (!thislevel.isEmpty()) {
                TreeNode node = thislevel.remove();
                data.add(node.data);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            ret.add(data);

            Queue<TreeNode> tmp = thislevel;
            thislevel = nextLevel;
            nextLevel = tmp;
        }


        for (int i = 0, l = ret.size(); i < (l >> 1); i++) {
            ArrayList<Integer> tmp = ret.get(i);
            ret.set(i, ret.get(l - i - 1));
            ret.set(l - i - 1, tmp);
        }

        return ret;
    }

    //NOTE: you can not write a function to swap immutable objects in java
    private static void swap(Object a, Object b) {
        Object tmp = a;
        a = b;
        b = tmp;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        for (ArrayList<Integer> iL : levelOrderBottom(TreeNode.getSampleTree())) {
            Utils.printIntListln(iL);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
