/*
    Given a sorted (increasing order) array, write an algorithm to create a binary tree with
    minimal height.

    We will try to create a binary tree such that for each node, the number of nodes
    in the left subtree and the right subtree are equal, if possible.

    Algorithm:
        1. Insert into the tree the middle element of the array.
        2. Insert (into the left subtree) the left subarray elements
        3. Insert (into the right subtree) the right subarray elements
        4. Recurse

     https://gist.github.com/zac-xin/2625543

    Time: O(N logN)

*/
package leetcode.algorithms;

import utils.TreeNode;

public class CreateBSTWithMinimalHeight {
    public static TreeNode createMinimalBST(int[] input, int start, int end) {
        if (end < start)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(input[mid]);
        n.left = createMinimalBST(input, start, mid - 1);
        n.right = createMinimalBST(input, mid + 1, end);
        return n;
    }

    public static TreeNode makeTree(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }
}
