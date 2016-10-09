import java.util.*; 

  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 

public class BFS {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>>result = new ArrayList<List<Integer>>();

        if(root == null){ //check to see if the root is empty 
            return result;
        }
        Queue<TreeNode>queue = new LinkedList<TreeNode>(); //queue to store tree node
    
        queue.add(root);
    
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>oneLevel = new ArrayList<Integer>();
            while(size != 0){
                TreeNode temp = queue.remove();
                oneLevel.add(temp.val);
                
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                size--; //deleted one root before second while loop

            }
            result.add(oneLevel);
        }
        return result;
    }
}