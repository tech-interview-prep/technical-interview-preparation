package facebook;

/* 	
	Boundary Traversal of binary tree

	Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.

	For example, boundary traversal of the following tree is “20 8 4 10 14 25 22″
	
	Link: http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
	      http://leetcode.com/2010/10/print-edge-nodes-boundary-of-binary.html

*/	
public class PrintEdgeNodes {
    // A function to do boundary traversal of a given binary tree
    void printBoundary (TreeNode root)
    {
        if (root != null) {
            System.out.println(root.data);

            // Print the left boundary in top-down manner.
            printBoundaryLeft(root.left);

            // Print all leaf nodes
            printLeaves(root.left);
            printLeaves(root.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(root.right);
        }
    }

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode root) {
        if (root != null) {
            printLeaves(root.left);

            // Print it if it is a leaf node
            if ( (root.left == null)  &&  (root.right == null) ) {
                System.out.println(root.data);
            }

            printLeaves(root.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.println(root.data);
                printBoundaryLeft(root.left);
            }
            else if(root.right != null) {
                System.out.println(root.data);
                printBoundaryLeft(root.right);
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode root) {
        if (root != null) {
            if (root.right != null) {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(root.right);
                System.out.println(root.data);
            }
            else if (root.left != null) {
                printBoundaryRight(root.left);
                System.out.println(root.data);
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }
}
