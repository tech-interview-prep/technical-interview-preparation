import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x;}
}

public class TreeTraversals {

	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.right = new TreeNode(11);
		//System.out.println(preOrder(root));
		//System.out.println(recursivePreOrder(root));
		//System.out.println(inOrder(root));
		//System.out.println(recursiveInOrder(root));
		System.out.println(postOrder(root));
		//System.out.println(recursivePostOrder(root));
	}

	private static List<Integer>result = new ArrayList<Integer>();

	//////////ITERATIVE PREORDER TRAVERSAL////////
	public static List<Integer> preOrder(TreeNode root){ //V,L,R
		if(root == null) return result;		
		
		Stack<TreeNode>stack = new Stack<TreeNode>();

		while(true){
			while(root != null){
				stack.push(root);
				result.add(root.val);
				root = root.left;
			}
			if(stack.isEmpty()) break;

			if(root == null){
				root = stack.pop(); //in order to get access to its parent to go to the right side of its parent
				root = root.right;
			}
		}
		return result;
	}

	//////////RECURSIVE PREORDER TRAVERSAL////////
	public static List<Integer> recursivePreOrder(TreeNode root){ //V,L,R
		if(root != null) helperPreOrder(root);

		return result;
	}

	//////////ITERATIVE INORDER TRAVERSAL////////
	public static List<Integer> inOrder(TreeNode root){ //L,V,R
		if(root == null) return result;

		Stack<TreeNode>stack = new Stack<TreeNode>();

		while(true){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) break;

			if(root == null){
				root = stack.pop(); //topmost is parent
    			result.add(root.val);
    			root = root.right;
			}
		}
		return result;
	}

	//////////RECURSIVE INORDER TRAVERSAL////////
	public static List<Integer> recursiveInOrder(TreeNode root) {
        if(root != null) helperInOrder(root);

        return result;
    }

	//////////ITERATIVE POSTORDER TRAVERSAL////////
    public static List<Integer> postOrder(TreeNode root){
    	if(root == null) return result;

    	Stack<TreeNode>stack = new Stack<TreeNode>(); 
    	Set<TreeNode>visited = new HashSet<TreeNode>(); 
    	
    	while(true){
    		while(root != null){ //leftwise direction
    			stack.push(root);
    			root = root.left;
    		}

    		if(stack.isEmpty()) break; //break out since you have finished

    		root = stack.peek().right; //rightwise direction
    		/* Essentially visited.contains(root) is the case where you need to pop off the root and you have already
    		 * visited its right child. So it adds the root to last part of result
    		 */
    		if(root == null || visited.contains(root)){
    			root = stack.pop(); //topmost is parent
    			result.add(root.val);
    			visited.add(root); //for rightside case
    			root = null;
    		}
    	}
    	return result;
    }

    //////////RECURSIVE INORDER TRAVERSAL////////
    public static List<Integer> recursivePostOrder(TreeNode root) {
        if(root != null) helperPostOrder(root);
        
        return result;
    }

    //////////Helper functions////////
    private static void helperPreOrder(TreeNode node){ 
        result.add(node.val);
    
        if(node.left != null) helperPreOrder(node.left);
      
        if(node.right != null) helperPreOrder(node.right);     
    }

    private static void helperInOrder(TreeNode node){     
        if(node.left != null) helperInOrder(node.left);
      
        result.add(node.val);

        if(node.right != null) helperInOrder(node.right);     
    }

    private static void helperPostOrder(TreeNode node){ 
        if(node.left != null) helperPostOrder(node.left);

        if(node.right != null) helperPostOrder(node.right);
     
        result.add(node.val);
    }


}


		


	

