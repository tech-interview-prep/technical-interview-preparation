package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _096UniqueBinarySearchTrees {
    /*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

    1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
    2     1         2                 3
    */
    public static int numTrees(int n) {
        if (n == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }

    public static int numTrees2(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    private static void test() {
        Utils.printTestln(numTrees(3), 5);
        Utils.printTestln(numTrees2(3), 5);
    }

    public static void main(String[] args) {
        test();
    }

}
