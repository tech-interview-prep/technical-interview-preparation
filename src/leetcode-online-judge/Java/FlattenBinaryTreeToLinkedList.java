package leetcode_online_judge;

public class FlattenBinaryTreeToLinkedList {
    /*
    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6

    The flattened tree should look like:

       1
        \
         2
          \
           3
            \                                                   
             4
              \
               5
                \
                 6

     */
    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public static TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = flattenHelper(root.left);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        TreeNode rightLast = flattenHelper(root.right);
        return leftLast == null && rightLast == null ? root : rightLast == null ? leftLast : rightLast;
    }

    private static void test() {
        TreeNode root = TreeNode.getSampleTree();
        flatten(root);
        TreeNode.inOrder(root);
    }

    public static void main(String[] args) {
        test();
    }
}
