    /*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
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

    Link: https://gist.github.com/zac-xin/4076377
    Link: http://www.geeksforgeeks.org/level-order-tree-traversal/
    Link: http://leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html
    Link: http://leetcode.com/2010/09/printing-binary-tree-in-level-order.html
    */
package facebook;

import utils.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author bkoteshwarreddy
 */

public class _102BinaryTreeLevelOrderTraversal {
    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    public static void main(String[] args) {
      Solution_BinaryTreeLevelOrderTraversal sol = new Solution_BinaryTreeLevelOrderTraversal();
      Utils.printListListln(sol.levelOrder(TreeNode.getSampleTree()));
    }
}

class Solution_BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                level.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                ret.add(level);
                if (!queue.isEmpty()) {
                    level = new ArrayList<Integer>();
                    queue.add(null);
                }
            }
        }

        return ret;
    }

    public static void printLevelOrderBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while(!queue.isEmpty()){
            TreeNode n = queue.remove();
            System.out.print(n.data + " ");
            if(n.left != null){
                queue.add(n.left);
                nextLevelCount++;
            }
            if(n.right != null){
                queue.add(n.right);
                nextLevelCount++;
            }
            currentLevelCount--;
            if(currentLevelCount == 0){
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    public static void printLevelOrderDFS(TreeNode root){
        int height = maxHeight(root);
        for( int  i = 0; i < height; i++){
            printLevel(root, i);
            System.out.println();
        }
    }

    public static void printLevel(TreeNode node, int level){
        if(node == null)
            return;
        if(level == 0){
            System.out.print(node.data +" ");
        }else{
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }


    }

    public static int maxHeight(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
