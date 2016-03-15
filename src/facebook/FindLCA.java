package facebook;

import java.util.LinkedList;
import java.util.Queue;

/*
	Find LCA in Binary Tree
*/	
public class FindLCA {
    // https://gist.github.com/zac-xin/4043437
    // http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    public static TreeNode findLCA_BST(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.data > Math.max(p.data, q.data)){
            return findLCA_BST(root.left, p, q);
        }
        if(root.data < Math.min(p.data, q.data)){
            return findLCA_BST(root.right, p, q);
        }
        return root;
    }

    // https://gist.github.com/zac-xin/4043452
    // http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root.data == p.data || root.data == q.data){
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }else{
            return left;
        }
    }
}
