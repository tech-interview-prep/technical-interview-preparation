package interviewBit.trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/19/15.
 *
 * Problem statement
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 Example :

 Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
  /  \      \
 7    2      1

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Path {
    public int hasPathSum(TreeNode a, int b) {

        boolean result = isSumFound(a,b);
        if(result){
            return 1;
        }else {
            return 0;
        }

    }

    //Track sum from root to leaf node
    public boolean isSumFound(TreeNode a,int b){

        if(a == null){
            return false;
        }

        //Detect if a node is a leaf node
        if(a.left == null && a.right == null){
            if(b - a.data  == 0) {
                return true;
            }else {
                return false;
            }
        }



        return isSumFound(a.left,b-a.data) || isSumFound(a.right,b-a.data) ;
    }

    public static void main(String[] args){

        Path p = new Path();

        ArrayList<String> s = new ArrayList<>(Arrays.asList("5","4","8","11","null","13","4","7","2","null","null","null","1"));
        TreeNode root = CreateBST.insertElements(s);
        int result = p.hasPathSum(root,27);
        System.out.println(result);

    }
}
