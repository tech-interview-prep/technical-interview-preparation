package interview_bit.trees;

import java.util.*;
import java.util.Arrays;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 *
 *
 * Problem statement
 *
 * Given a binary search tree, write a function to find the kth smallest element in the tree.

 Example :

 Input :
 2
 / \
 1   3

 and k = 2

 Return : 2

 As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST
 */
public class Kthsmallest {


    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.data;
                p = t.right;
            }
        }

        return result;

    }

    public static void main(String[] args){
        ArrayList<String> s = new ArrayList<>(Arrays.asList("2", "1", "3", "null", "null","null", "null"));
        TreeNode root = CreateBST.insertElements(s);
        Kthsmallest k = new Kthsmallest();
        int result = k.kthsmallest(root,4);
        System.out.println(result);
    }
}
