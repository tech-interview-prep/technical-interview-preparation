package leetcode_online_judge.Java;

import java.util.List;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _099RecoverBinarySearchTree {
    /*
    Two elements of a binary search tree (BST) are swapped by mistake.

    Recover the tree without changing its structure.

    Note:
    A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
    */
    public static void recoverTree(TreeNode root) {
        List<TreeNode> swapNode = new ArrayList<TreeNode>();
        List<TreeNode> preNode = new ArrayList<TreeNode>();
        preNode.add(null);
        inOrder(root, swapNode, preNode);

        if (!swapNode.isEmpty()) {
            int tmp = swapNode.get(0).data;
            swapNode.get(0).data = swapNode.get(1).data;
            swapNode.get(1).data = tmp;
        }
    }

    private static void inOrder(TreeNode node, List<TreeNode> swapNode, List<TreeNode> preNode) {
        if (node == null) {
            return;
        }

        inOrder(node.left, swapNode, preNode);

        TreeNode pre = preNode.get(0);
        if (pre != null && pre.data > node.data) {
            if (swapNode.isEmpty()) {
                swapNode.add(pre);
                swapNode.add(node);
            } else {
                swapNode.set(1, node);
            }
        }

        preNode.set(0, node);

        inOrder(node.right, swapNode, preNode);
    }

    private static void test() {
        TreeNode root = constructTree();
        TreeNode.inOrder(root);
        System.out.print("\t>>>\t");
        recoverTree(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree2();
        TreeNode.inOrder(root);
        System.out.print("\t>>>\t");
        recoverTree(root);
        TreeNode.inOrder(root);

        System.out.println();

        root = constructTree3();
        TreeNode.inOrder(root);
        System.out.print("\t>>>\t");
        recoverTree(root);
        TreeNode.inOrder(root);
    }

    /*
            5
        /       \
       3         8
     /   \     /   \
    10   4    7     2
     */
    public static TreeNode constructTree() {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(2);

        return root;
    }

    /*
           2
            \
             1
     */
    public static TreeNode constructTree2() {
        TreeNode root = new TreeNode(2);

        root.right = new TreeNode(1);

        return root;
    }

    /*
                   64
                  /
                 41
                /
              -85
              /  \
           -73  -49
            /
         -98
         /
       -124
    */
    public static TreeNode constructTree3() {
        TreeNode root = new TreeNode(64);

        root.left = new TreeNode(41);

        root.left.left = new TreeNode(-85);

        root.left.left.left = new TreeNode(-73);
        root.left.left.right = new TreeNode(-49);

        root.left.left.left.left = new TreeNode(-98);

        root.left.left.left.left.left = new TreeNode(-124);

        return root;
    }

    public static void main(String[] args) {
        test();
    }
}
