package leetcode_online_judge;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
    /*
    Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

    For example,
    Given n = 3, your program should return all 5 unique BST's shown below.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */
    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n + 1);
    }

    //end is exclusive
    private static ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (start == end) {
            ret.add(null);
            return ret;
        }

        for (int i = start; i < end; i++) {
            ArrayList<TreeNode> leftTrees = generateTrees(start, i);
            ArrayList<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    private static void test() {
        for (TreeNode root : generateTrees(3)) {
            TreeNode.preOrder(root);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
