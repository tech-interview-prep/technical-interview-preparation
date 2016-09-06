package facebook;

import utils.TreeNode;

/*
	You have two very large binary trees: T1, with millions of nodes,
    and T2, with hundreds of nodes.
    Create an algorithm to decide if T2 is a subtree of T1.

	Link: https://gist.github.com/zac-xin/2644019

*/
public class SubTree {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true; // The empty tree is a subtree of every tree.
        else
            return subTree(t1, t2);
    }

    /* Checks if the binary tree rooted at r1 contains the binary tree
     * rooted at r2 as a subtree somewhere within it.
     */
    public static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return false; // big tree empty & subtree still not found.
        if (t1.data == t2.data) {
            if (matchTree(t1,t2)) return true;
        }
        return (subTree(t1.left, t2) || subTree(t1.right, t2));
    }

    /* Checks if the binary tree rooted at r1 contains the
     * binary tree rooted at r2 as a subtree starting at r1.
     */
    public static boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t2 == null && t1 == null)
            return true; // nothing left in the subtree
        if (t1 == null || t2 == null)
            return false; //  big tree empty & subtree still not found
        if (t1.data != t2.data)
            return false;  // data doesn’t match
        return (matchTree(t1.left, t2.left) &&
                matchTree(t1.right, t2.right));
    }
}
