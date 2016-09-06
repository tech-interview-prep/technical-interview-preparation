package leetcode_online_judge.Java;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _070ClimbingStairs {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsDP(int n) {
        if (n <= 2) {
            return n;
        }

        int f0 = 1, f1 = 2, f = 0;
        for (int i = 3; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }

        return f;
    }
}
