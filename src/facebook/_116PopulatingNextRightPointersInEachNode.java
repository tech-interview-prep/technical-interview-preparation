/*
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
package facebook;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @author bkoteshwarreddy
 */
public class _116PopulatingNextRightPointersInEachNode {
}

class Solution_PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        root.next = null;

        TreeLinkNode leftMostNode = root, node, preNode;
        while (leftMostNode.left != null) {
            node = leftMostNode;
            node.left.next = node.right;
            preNode = node.right;
            node = node.next;

            while (node != null) {
                preNode.next = node.left;
                node.left.next = node.right;
                preNode = node.right;
                node = node.next;
            }
            leftMostNode = leftMostNode.left;
        }
    }

    public void connect2(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode cur = root;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
    }

    public void connect3(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        root.left.next = root.right;
        root.right.next = root.next != null ? root.next.left : null;
        connect(root.left);
        connect(root.right);
    }

    public static void connect4(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);

        TreeLinkNode preNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.remove();
            if (preNode != null) {
                preNode.next = node;
            }
            if (node == null && !queue.isEmpty()) {
                queue.add(null);
            }

            if (node != null && node.left != null) {
                queue.add(node.left);
            }

            if (node != null && node.right != null) {
                queue.add(node.right);
            }
            preNode = node;
        }
    }
}
