package facebook;

/* 	
	Check if a given tree is a valid BST
	
	Link: http://www.careercup.com/question?id=5632735657852928

*/	
public class ValidBST {
    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.data) ||
                !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }


    // https://gist.github.com/zac-xin/4349492
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean helper(TreeNode root, int max, int min){
        if(root == null)
            return true;

        if(root.data < max && root.data > min && helper(root.left, root.data, min) &&
                helper(root.right, max, root.data))
            return true;

        return false;
    }
}
