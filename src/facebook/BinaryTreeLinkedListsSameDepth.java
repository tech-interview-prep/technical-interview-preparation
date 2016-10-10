package facebook;

import java.util.ArrayList;
import java.util.LinkedList;

import utils.TreeNode;

/*
    Given a binary search tree, design an algorithm which creates a linked list of all the
    nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).

     https://gist.github.com/zac-xin/2627331

*/
public class BinaryTreeLinkedListsSameDepth {
    public static ArrayList<LinkedList<TreeNode>> findLevelLinkedList(TreeNode root) {
        int level = 0;
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        result.add(list);

        while (true) {
            list = new LinkedList<TreeNode>();
            for (int i = 0; i < result.get(level).size(); i++) {
                TreeNode node = result.get(level).get(i);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            if (list.size() > 0) {
                result.add(list); // or  result.add(level+1, list)
                level++;
            } else {
                break;
            }
        }

        return result;
    }
}
