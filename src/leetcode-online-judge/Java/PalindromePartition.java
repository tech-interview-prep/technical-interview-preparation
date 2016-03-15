package leetcode_online_judge;

import java.util.ArrayList;

public class PalindromePartition {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
     */

    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        partition(s, s.length(), ret);
        return ret;
    }

    public static void partition(String s, int end, ArrayList<ArrayList<String>> ret) {
        if (end == 0) {
            ret.add(new ArrayList<String>());
            return;
        }

        int listStartIndex = ret.size();
        for (int i = end - 1; i >= 0; i--) {
            if (isPalindrome(s, i, end)) {
                partition(s, i, ret);
                for (; listStartIndex < ret.size(); listStartIndex++) {
                    ret.get(listStartIndex).add(s.substring(i, end));
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (end--; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    private static void test(String s) {
        for (ArrayList<String> al : partition(s)) {
            for (String p : al) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test("aab");
    }
}
