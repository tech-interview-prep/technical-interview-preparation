package interview_bit.trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/21/15.
 *
 * Problem statement
 *
 *
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :


          _______3______
         /              \
     ___5__          ___1__
    /      \        /      \
   6      _2_     0        8
         /   \
        7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.

 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */
public class LCA {
    public int lca(TreeNode a, int val1, int val2) {

        //Check if both the values are present in the tree
        if (!isNodePresent(a, val1) || !isNodePresent(a, val2)) {
            return -1;
        }

        //Find the lowest common ancestor
        TreeNode lcaNode = getLCA(a, val1, val2);

        return lcaNode.data;


    }

    public boolean isNodePresent(TreeNode a, int val) {
        if (a == null) {
            return false;
        }

        if (a.data == val) {
            return true;
        }

        return isNodePresent(a.left, val) || isNodePresent(a.right, val);
    }

    public TreeNode getLCA(TreeNode a, int val1, int val2) {
        if (a == null) {
            return null;
        }

        if (a.data == val1 || a.data == val2) {
            return a;
        }

        TreeNode left = getLCA(a.left, val1, val2);
        TreeNode right = getLCA(a.right, val1, val2);

        //If both the left and right trees return true then the current node is the LCA
        if (left != null && right != null) {
            return a;
        }

        if (left == null) {
            return right;
        }

        return left;

    }




    public static void main(String[] args) {
        LCA l = new LCA();

        ArrayList<String> s = new ArrayList<>(Arrays.asList("15", "20", "34", "35", "5", "14", "16", "26", "null", "25", "23", "null", "30", "3", "36", "null", "null", "7", "24", "11", "32", "null", "null", "21", "null", "null", "null", "29", "4", "9", "null", "33", "13", "null", "null", "null", "null", "22", "31", "null", "27", "19", "1", "null", "12", "18", "6", "null", "null", "null", "2", "null", "null", "null", "null", "10", "null", "null", "null", "null", "8", "null", "28", "null", "null", "null", "null", "null", "17", "null", "null", "null", "null"));
        TreeNode root = CreateBST.insertElements(s);
        int result = l.lca(root, 33, 5);
        System.out.println(result);


    }
}
