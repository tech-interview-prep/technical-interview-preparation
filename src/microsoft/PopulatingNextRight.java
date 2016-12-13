package leetcode.algorithms.level.Medium;

/**
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 *
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the
 * same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 *
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *
 * Tags: Tree, DFS
 */
class PopulatingNextRight {
    public static void main(String[] args) {

    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode cur = new TreeLinkNode(0);
            for (int i = 0; i < size; i++) {
                TreeLinkNode head = queue.poll();
                cur.next = head;
                cur = cur.next;
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            cur.next = null;
        }
    }

    /**
     * Iterative
     * Store node in previous line
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode runner = root;
        while(runner != null){
            TreeLinkNode firstNode = new TreeLinkNode(0); //Dummy head
            TreeLinkNode pre = firstNode;
            TreeLinkNode cur = runner;
            while(cur != null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            runner = firstNode.next;
        }
    }

    static class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}
