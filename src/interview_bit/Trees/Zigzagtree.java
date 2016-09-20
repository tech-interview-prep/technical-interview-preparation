package interview_bit.trees;
import  java.util.*;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/19/15.
 *
 * Problem statement
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

 Example :
 Given binary tree

    3
   / \
  9  20
  /  \
 15   7

 return

 [
 [3],
 [20, 9],
 [15, 7]
 ]
 */
public class Zigzagtree {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        if(a == null){
            return result;
        }
        levelOrderQueue.add(a);

        //dir = 1, means we are going left to right and dir = -1 means we are going right to left
        int dir = 1;

        while(!levelOrderQueue.isEmpty()){
            ArrayList<Integer> levelVals = new ArrayList<>();
            int queueSize = levelOrderQueue.size();
            Stack<TreeNode> stack = new Stack<>();

            //This section essentially does a BFS
            for(int i=0;i<queueSize;i++) {
                TreeNode x = levelOrderQueue.poll();
                //if going left to right add values to final list else add to stack to add them in reverse
                if(dir == 1) {
                    levelVals.add(x.data);
                }else{
                    stack.push(x);
                }

                if (x.left != null) {
                    levelOrderQueue.add(x.left);
                }

                if (x.right != null) {
                    levelOrderQueue.add(x.right);
                }

            }

            while(!stack.isEmpty()){
                TreeNode x = stack.pop();
                levelVals.add(x.data);
            }

            result.add(levelVals);

            //Reverse direction every iteration
            if(dir == -1){
                dir = 1;
            }else {
                dir = -1;
            }
        }

        return result;
    }
}
