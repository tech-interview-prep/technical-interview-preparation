package leetcode_online_judge;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "\t");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    public static TreeNode getSampleTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        return root;
    }

    /*
             8
          /      \
         4       19
        / \     /  \
       3   6   11  20
            \   \
            7   14
     */
    public static TreeNode getSampleBinarySearchTree() {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);


        root.left.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(14);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = getSampleTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
