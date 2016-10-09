package facebook;

/**
 * Morris InOrder Traverse Algorithm
 *
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 *
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * https://gist.github.com/bittib/5746501
 */
public class MorrisInOrderTraverse {
    public int climbStairs(int n) {
        if ( n == 0 || n == 1 || n == 2)
            return n;

        int array[] = new int[n + 1];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        if ( n == 0 || n == 1 || n == 2) {
            return array[n];
        }

        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
