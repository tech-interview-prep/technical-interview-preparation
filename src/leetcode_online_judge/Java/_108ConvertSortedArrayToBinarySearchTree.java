package leetcode_online_judge.Java;

import utils.TreeNode;

public class _108ConvertSortedArrayToBinarySearchTree {
    /*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    */
    public static TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }

    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (end <= start) {
            return null;
        }

        int mid = (start + end) >>> 1;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, start, mid);
        node.right = sortedArrayToBST(num, mid + 1, end);

        return node;
    }

    private static void test() {
        TreeNode.inOrder(sortedArrayToBST(new int[]{1, 3, 5, 7, 9, 10, 11, 12}));
    }

    public static void main(String[] args) {
        test();
    }
}
