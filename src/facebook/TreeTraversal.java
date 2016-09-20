package facebook;

import java.util.Stack;

/*
	Traversals of binary tree

	inorder
	preorder
	postorder

	Link: https://gist.github.com/tangkangkai/9968025
	      https://gist.github.com/thorikawa/5500905

*/
public class TreeTraversal {
	// Pre-Order recursion
	public void preOrderRecursion(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.data + "  ");
			preOrderRecursion(root.left);
			preOrderRecursion(root.right);
		}
	}

	// Pre-Order interation
	public void preOrderIteration(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.print(current.data + "  ");// print the data when
														// pushed into the stack
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				current = current.right;
			}
		}
	}

    public void preorder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.add(root);
        while (!stack.empty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void preorder2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.add(root);
        BinaryTreeNode node = null;
        while (!stack.empty()) {
            if (node == null) {
                node = stack.pop();
            }
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }
    }

	// In-Order recursion
	public void inOrderRecursion(BinaryTreeNode root) {
		if (root != null) {
			inOrderRecursion(root.left);
			System.out.print(root.data + "  ");
			inOrderRecursion(root.right);
		}
	}

	// In-Order Iteration
	public void inOrderIteration(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.print(current.data + "  ");// print the data when
														// popped out of stack
				current = current.right;
			}
		}

	}

    public void inorder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                // No need to explore
                node = stack.pop();
                System.out.print(node.data + "  ");
                node = node.right;
            } else {
                // Explore more
                stack.push(node);
                node = node.left;
            }
        }
    }

	// Post-Order Recursion
	public void postOrderRecursion(BinaryTreeNode root) {
		if (root != null) {
			postOrderRecursion(root.left);
			postOrderRecursion(root.right);
			System.out.print(root.data + "  ");
		}

	}

	// Post-Order Iteration
	public void postOrderIteration(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				if (current.isFinished) { // we use isFinished as a flag to see
											// if both of the children have been
											// visited.
					System.out.print(current.data + "  ");
					current = null;
				} else {
					current.isFinished = true;
					stack.push(current);
					current = current.right;
				}
			}
		}
	}

    public void postorder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(node);
        BinaryTreeNode prevNode = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode curNode = stack.peek();
            if (prevNode == null || prevNode.left == curNode || prevNode.right == curNode) {
                // Come from parent
                if (curNode.left != null) {
                    stack.push(curNode.left);
                } else if (curNode.right != null) {
                    stack.push(curNode.right);
                }
            } else if (prevNode == curNode.left) {
                // Back from left child
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
            } else {
                // Back from right child or stay (which means there is no child
                // to be visited). Either way, it means no more explore.
                System.out.print(node.data + "  ");
                stack.pop();
            }
            prevNode = curNode;
        }
    }
}

class BinaryTreeNode {
	int data;
	boolean isFinished;
	BinaryTreeNode left = null;
	BinaryTreeNode right = null;

	public BinaryTreeNode(int data) {
		this.data = data;
	}
}
