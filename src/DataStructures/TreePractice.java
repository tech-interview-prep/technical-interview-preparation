import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}

public class TreePractice {
	
	//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
	//LCA is defined as between nodes v and w as the lowest node in T that has both v and w as descendants, a node can be a
	//descendant of itself
	public TreeNode lCA(TreeNode root, TreeNode p, TreeNode q){
		TreeNode node = root;
		if(node.val > p.val && node.val < q.val) return root; //first case if the lca is the root
		else if(node.val > p.val && node.val > q.val) return lCA(root.left,p,q); //taking in consideration a descendant of itself and leftsubtree
		else if(node.val < p.val && node.val < q.val) return lCA(root.right,p,q); //right subtree

		return root;
	}

	/*
	 * Properties of a valid BST
	 * 1) The left subtree of a node contains only nodes less than root node
	 * 2) The right subtree of a node contains only nodes greater than root node.
	 * 3) Both the left and right subtree must be binary search trees
	 */
	public static boolean isValidBST(TreeNode root){
		//Creating a helper recursive function to keep track of the minimum and maximum values a node can take
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE); 
	}

	private static boolean isValid(TreeNode node, long min, long max){
		
		if(node == null) return true;

		if(node.val <= min || node.val >= max) return false;

		//This recursive solution sets the current value as the new max to our left child and sends the min without changing
		//For the right child, we set the current value as the new min and sent the max without changing.
		return isValid(node.left, min, node.val) && isValid(node.right,node.val,max);
	}

	//Get the maximum depth of a binary tree
	public static int maxDepth(TreeNode root){
		//if tree is empty return 0
		if(root == null) return 0;
		else {
			//compute the depth of each subtree recursively
			int leftSubtreeDepth = maxDepth(root.left); 
			int rightSubtreeDepth = maxDepth(root.right);

			//get the max of max depths of left and right subtree and add 1
			if(leftSubtreeDepth > rightSubtreeDepth) return leftSubtreeDepth + 1;
			else return rightSubtreeDepth + 1;
		}
	}
	public static int minDepth(TreeNode root) {
        if(root == null) return 0; //hit base case
        if(root.left == null) return minDepth(root.right)+1; //check right side
        if(root.right == null) return minDepth(root.left)+1; //check left side 
        
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }

    public static boolean searchValue(TreeNode root, int val){
    	TreeNode node = root;

    	if(val == node.val) return true;
    	if(val < node.val) return searchValue(node.left,val);
    	if(val > node.val) return searchValue(node.right,val);

    	return false;
    }

    // public static TreeNode addNode(TreeNode node, TreeNode root){
    // 	if(root == null) addNode(node,root);
    // 	if(node.val < root.val) return addNode(node,root.left);
    // 	if(node.val > root.val) return addNode(node,root.right);
    // }

    /*
     * DELETE : 3 cases
     * 1. Leaf - if the node is a leaf then set the leaf to be null, keep track of parent node
     * 2. 1 child - 
     * 3. 2 children
     */

    public static void main(String[] args){
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(8);
    	root.right = new TreeNode(15);
    	root.left.right = new TreeNode(9);
    	root.right.right = new TreeNode(20);
    	System.out.println(searchValue(root,20));
    }

    /*
     * Find kth smallest element in binary search tree
     * Definitely inorder traversal since it visits the leftmost leaf which is the kth smallest node starting point
     * return list based upon k-1.
     * BigO: based upon the height of the binary tree
     */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer>result = new ArrayList<Integer>();
        inOrder(root,result);
        
        return result.get(k-1);
    }
    
    //inorder to get the leftmost leaf
    private static void inOrder(TreeNode node, List result){
        if(node == null) return;
        if(node.left != null) inOrder(node.left,result);
        result.add(node.val);
        if(node.right != null) inOrder(node.right,result);
        
    }

    /*
     * Find kth largest element in binary search tree
     * Definitely inorder traversal since it puts nodes in order
     * Return based upon the list.size() - kth
     * BigO: based upon the height of the binary tree
     */

	public int kthLargest(TreeNode root, int k) {
        List<Integer>result = new ArrayList<Integer>();
        inOrder(root,result);
        
        return result.get(result.size() - k);
      }

    /* Return 2nd largest element in bst
     *
     */ 
    
     public static int secondLargestElement(TreeNode node){
        //call inorder
        List<Integer>result = new ArrayList<Integer>();
        inOrder(node,result);

        return result.get(result.size()-2);

    }

    /*
     * Two trees are equal if the have the same data and arrangement of data is the same.
     *
     */ 
    public boolean checkEqualTree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;

        else if(a != null && b != null){
            return a.val == b.val && checkEqualTree(a.left,b.left) && checkEqualTree(a.right,b.right);
        }
        return false;

    }

    /*
     * Given a non-empty binary search tree and a target value, 
     * find the value in the BST that is closest to the target.
     */
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int res = 0;

        if(root == null)
            return res;

        //base case 
        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val - target);
            res = root.val; //on the closest value to target
        }

        //recursive cases 
        if(target < root.val) 
            closestValue(root.left,target);
        if(target > root.val)
            closestValue(root.right,target);
        
        return res;
    }

    /*
     * Get the size of a tree
     */

    public int size(TreeNode root){
        if(root == null) 
            return 0;
        else
            return size(root.left) + 1 + size(root.right); 
    }







}