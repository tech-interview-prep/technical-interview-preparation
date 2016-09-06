/*
    Given a binary tree, return all root-to-leaf paths.

    For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5
    All root-to-leaf paths are:

    ["1->2->5", "1->3"]

    public List<String> binaryTreePaths(TreeNode root)
     */

package facebook;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * @author bkoteshwarreddy
 */
public class _257BinaryTreePaths {

}

class Solution_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
      return null;
    }
    
    /*
    Print all paths of a binary tree from root to leaf.

    Later, extend the solution to work with graphs, careful attention to cycles which you should print
    as paths as well (without printing visited nodes twice).

    Link: http://www.careercup.com/question?id=5742219382226944

    public void printRootToLeaf(TreeNode node)
 */
    public void printRootToLeaf(TreeNode node) {
        List<String> path = new ArrayList<String>();
        printRootToLeaf(node, path);
    }

    private void printRootToLeaf(TreeNode node, List<String> path) {
        if(node != null) {
            path.add(String.valueOf(node.data));

            if(node.left == null && node.right == null) {
                printPath(path);
            } else {
                printRootToLeaf(node.left, path);
                printRootToLeaf(node.right, path);
            }
        }
    }

    private void printPath(List<String> path) {
        for(String s : path) {
            System.out.println(s);
        }
    }
}
