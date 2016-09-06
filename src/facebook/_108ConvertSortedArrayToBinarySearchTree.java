/*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    Link: https://gist.github.com/zac-xin/4245928

*/
package facebook;

import utils.TreeNode;

public class _108ConvertSortedArrayToBinarySearchTree {
  
}

class Solution_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length - 1);
    }

    public TreeNode convert(int a[], int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            TreeNode root = new TreeNode(a[mid]);
            TreeNode left = convert(a, low, mid -1);
            TreeNode right = convert(a, mid + 1, high);
            root.left = left;
            root.right = right;
            return root;
        }
        return null;
    }
}
