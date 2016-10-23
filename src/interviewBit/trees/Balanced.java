package interviewBit.trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 *
 * Problem statement
 *
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Example :

 Input :
 1
 / \
 2   3

 Return : True or 1

 Input 2 :
 3
 /
 2
 /
 1

 Return : False or 0
 Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 Difference = 2 > 1.
 */
public class Balanced {
    public int isBalanced(TreeNode a) {

        if(computeHeight(a) == -1){
            return 0;
        }

        return 1;


    }

    public int computeHeight(TreeNode a){
        if(a == null){
            return 0;
        }

        int leftHeight = computeHeight(a.left);
        int rightHeight = computeHeight(a.right);

        if(leftHeight == -1 || rightHeight ==-1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight,rightHeight) + 1;
    }

    public  static  void main(String[] args){
        ArrayList<String> s = new ArrayList<>(Arrays.asList("1","2","3","4","5","null","6","7","8","9","10","null","null","null","null","null","null","null","null","null","null"));
        TreeNode root = CreateBST.insertElements(s);


        Balanced b = new Balanced();

        int result = b.isBalanced(root);

        System.out.println(result);
    }



}
