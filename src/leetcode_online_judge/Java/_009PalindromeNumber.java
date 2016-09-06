package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _009PalindromeNumber {
    /*
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * Some hints:
     * Could negative integers be palindromes? (ie, -1)
     *
     * If you are thinking of converting the integer to string, note the restriction of using
     * extra space.
     *
     * You could also try reversing an integer. However, if you have solved the problem
     * "Reverse Integer", you know that the reversed integer might overflow. How would you handle
     * such case?
     *
     * There is a more generic way of solving this problem.
     *
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int newX = 0;
        for (int copyX = x; copyX > 0; newX = newX * 10 + copyX % 10, copyX /= 10);

        return x == newX;
    }

    public boolean isPalindrome2(int x) {
        //optimizations
        if(x<0) return false;
        if(x<10) return true;
        if(x%10==0) return false;
        if(x<100&&x%11==0) return true;
        if(x<1000&&((x/100)*10+x%10)%11==0) return true;
        int v;
        //actual logic
        v=x%10;
        x=x/10;
        while(x-v>0)
        {
                v=v*10+x%10;
                x/=10;
        }
        if(v>x){v/=10;}
        return v==x?true:false;
    }

    public boolean isPalindrome3(int x) {
        if(x<0 || (x!=0 && x%10==0))
        return false;
        int res = 0;
           while(x>res){
            res = res*10 + x%10;
            x = x/10;
           }
        return (x==res || x==res/10);
    }

    private static void test() {
        Utils.printTestln(isPalindrome(12345), false);
        Utils.printTestln(isPalindrome(123454321), true);
    }

    public static void main(String[] args) {
        test();
    }
}
