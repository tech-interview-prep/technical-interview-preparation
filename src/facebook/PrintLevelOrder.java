package facebook;

import java.util.LinkedList;
import java.util.Queue;

/*
	Print a binary tree in level order using BFS & DFS
	
	Link: https://gist.github.com/zac-xin/4076377
	      http://www.geeksforgeeks.org/level-order-tree-traversal/
	      http://leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html
	      http://leetcode.com/2010/09/printing-binary-tree-in-level-order.html

*/	
public class PrintLevelOrder {
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
