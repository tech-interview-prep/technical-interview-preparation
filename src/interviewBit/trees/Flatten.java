package interviewBit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/20/15.
 *
 * Problem statement
 *
 * Given a binary tree, flatten it to a linked list in-place.

 Example :
 Given


     1
    / \
   2   5
  / \   \
 3   4   6
 The flattened tree should look like:

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
 Note that the left child of all nodes should be NULL.
 */
public class Flatten {


    public TreeNode flatten(TreeNode a) {
        Queue<Integer> q = new LinkedList<Integer>();

        //This problem  reduces to a preorder traversal
        q = preOrderRecursive(q,a);
        TreeNode root = a;
        a.data = q.remove();

        while(!q.isEmpty()){
           a.left = null;
           TreeNode temp = new TreeNode(q.remove());
           a.right = temp;
           a = a.right;
        }

        return root;


    }

    public Queue<Integer> preOrderRecursive(Queue<Integer> q,TreeNode a){
        if(a == null){
            return q;
        }

        q.add(a.data);

        preOrderRecursive(q, a.left);
        preOrderRecursive(q,a.right);
        return q;

    }

    public static void main(String[] args){
        Flatten f = new Flatten();
        ArrayList<String> s = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"));
        TreeNode root = CreateBST.insertElements(s);

        TreeNode result = f.flatten(root);
    }
}
