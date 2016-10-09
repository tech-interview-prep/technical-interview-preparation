package facebook;

/*
    Write an algorithm to find the ‘next’ node (e.g., in-order successor) of
    a given node.

     https://gist.github.com/zac-xin/2636153

*/
public class InorderSuccessor {
    public static TreeNodeWithParent inorderSucc(TreeNodeWithParent n) {
        if (n == null) return null;

        // Found right children -> return left most node of right subtree
        if (n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNodeWithParent q = n;
            TreeNodeWithParent x = q.parent;
            // Go up until we’re on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public static TreeNodeWithParent leftMostChild(TreeNodeWithParent n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    class TreeNodeWithParent {
        public int data;
        public TreeNodeWithParent left;
        public TreeNodeWithParent right;
        public TreeNodeWithParent parent;

        public TreeNodeWithParent(int data) {
            this.data = data;
            left = null;
            right = null;
            parent = null;
        }

        public TreeNodeWithParent(int data, TreeNodeWithParent left, TreeNodeWithParent right) {
            this.data = data;
            this.left = left;
            this.right = right;
            parent = null;
        }

        public TreeNodeWithParent getLeftMost() {
            if (left == null)
                return this;
            else
                return left.getLeftMost();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(data);
            return sb.toString();
        }
    }
}
