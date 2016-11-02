package facebook;

import utils.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *      You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *        1
 *       /  \
 *      2    3
 *     / \    \
 *    4   5    7
 *
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * http://n00tc0d3r.blogspot.com/2013/05/populating-next-right-pointers-for-each.html
 *
 */
public class _117PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        Solution_PopulatingNextRightPointersInEachNodeII sol = new Solution_PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);

        sol.connect(root);

        sol.connect2(root);
    }
}

class Solution_PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode next = null;
            TreeLinkNode cur = null;
            for (; root != null; root = root.next) {
                TreeLinkNode r = null;
                if (root.left != null) {
                    if (root.right != null)
                        root.left.next = root.right;
                    r = root.left;
                } else if (root.right != null)
                    r = root.right;
                if (r != null) {
                    if (next != null)
                        next.next = r;
                    else {
                        cur = r;
                        next = r;
                    }
                    if (next.next != null)
                        next = next.next;

                    if (next.next != null)
                        next = next.next;
                }
            }
            root = cur;
        }
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode leftMostNode = root, dummyNode = new TreeLinkNode(0);
        while (leftMostNode != null) {
            TreeLinkNode node = leftMostNode, preNode = dummyNode;
            while (node != null) {
                if (node.left != null) {
                    preNode.next = node.left;
                    preNode = node.left;
                }
                if (node.right != null) {
                    preNode.next = node.right;
                    preNode = preNode.next;
                }
                node = node.next;
            }
            leftMostNode = dummyNode.next;
            dummyNode.next = null;
        }
    }
}
