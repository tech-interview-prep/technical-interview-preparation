package facebook;

import java.util.ArrayList;
import java.util.List;

/*
    Print all paths of a binary tree from root to leaf.

    Later, extend the solution to work with graphs, careful attention to cycles which you should print
    as paths as well (without printing visited nodes twice).

    Link: http://www.careercup.com/question?id=5742219382226944
 */
public class PrintRootToLeafPath {
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
