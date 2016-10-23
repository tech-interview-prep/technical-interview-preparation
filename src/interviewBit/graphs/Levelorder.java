package interviewBit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;


/**
 * Created by priyavivek on 11/26/15.
 *
 * Problem statement
 *
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

 Example :
 Given binary tree

    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]
 Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 */
public class Levelorder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        queue.add(a);

        if(a == null){
            return result;
        }

        //BFS for the required answer

        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode curr = queue.poll();
                temp.add(curr.data);
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }

            }

            result.add(temp);


        }

        return result;

    }


    public static void main(String[] args){

        Levelorder l = new Levelorder();
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;

        c.left = d;
        c.right = e;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        result = l.levelOrder(a);

    }
}
