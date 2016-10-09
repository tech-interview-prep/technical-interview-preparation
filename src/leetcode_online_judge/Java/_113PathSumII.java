package leetcode_online_judge.Java;

import java.util.ArrayList;

import utils.TreeNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _113PathSumII {
    /*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
     */
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        pathSum(root, new ArrayList<Integer>(), ret, 0, sum);
        return ret;
    }

    public static void pathSum(TreeNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, int currentSum, int sum) {
        if (node == null) {
            return;
        }

        path.add(node.data);
        currentSum += node.data;

        if (node.left == null && node.right == null && currentSum == sum) {
            ret.add(new ArrayList<Integer>(path));
        }

        pathSum(node.left, path, ret, currentSum, sum);

        pathSum(node.right, path, ret, currentSum, sum);

        path.remove(path.size() - 1);
    }



    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printListListln(pathSum(TreeNode.getSampleTree(), 6));
        Utils.printListListln(pathSum(TreeNode.getSampleTree(), 7));
        Utils.printListListln(pathSum(TreeNode.getSampleTree(), 12));
    }

    public static void main(String[] args) {
        test();
    }
}
