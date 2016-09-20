package interview_bit.trees;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 *
 * Problem statement
 *
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Example :

 Input :

 1       1
 / \     / \
 2   3   2   3

 Output :
 1 or True
 */
public class Sametree {
    public int isSameTree(TreeNode a, TreeNode b) {
        if(sameTree(a,b)){
            return 1;
        }else{
            return 0;
        }
    }

    public boolean sameTree(TreeNode a, TreeNode b){
        if(a == null && b==null){
            return true;
        }

        if((a == null && b!=null) || (a!=null && b == null)){
            return false;
        }

        if(a.data != b.data){
            return false;
        }

        return sameTree(a.left,b.left) && sameTree(a.right,b.right);
    }
}
