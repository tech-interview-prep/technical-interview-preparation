package interviewBit.trees;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/17/15.
 *
 * Problem statement
 *
 * Given a binary tree, invert the binary tree and return it.
 Look at the example for more details.

 Example :
 Given binary tree

      1
    /   \
   2     3
  / \   / \
 4   5 6   7
 invert and return

      1
    /   \
   3     2
  / \   / \
 7   6 5   4
 */
public class Invert {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;

    }

    public void invert(TreeNode a){

        if(a == null){
            return;
        }

        TreeNode temp = a.left;
        a.left = a.right;
        a.right = temp;
        invert(a.left);
        invert(a.right);
    }
}
