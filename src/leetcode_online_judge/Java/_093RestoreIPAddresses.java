package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _093RestoreIPAddresses {
    /*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    */
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        restoreIpAddresses(s, 0, 0, ret);
        return ret;
    }

    private static void restoreIpAddresses(String s, int start, int segment, ArrayList<String> ret) {
        int l = s.length();
        if (segment == 3) {
            if (start + 3 >= l && start < l && parseInt(s, start, l) < 256) {
                ret.add(s.substring(start));
            }
            return;
        }

        for (int i = start + 1; i <= start + 3 && i < l; i++) {
            String sub = s.substring(start, i);
            int retStart = ret.size();
            if (parseInt(s, start, i) < 256) {
                restoreIpAddresses(s, i, segment + 1, ret);
                for (int j = retStart; j < ret.size(); j++) {
                    ret.set(j, sub + "." + ret.get(j));
                }
            }
        }
    }

    private static int parseInt(String s, int start, int end) {
        if (end > s.length()) {
            end = s.length();
        }

        if (start == end || end - start > 1 && s.charAt(start) == '0') {
            return Integer.MAX_VALUE;
        }

        int ret = 0;
        for (int i = start; i < end; i++) {
            ret = ret * 10 + s.charAt(i) - '0';
        }

        return ret;
    }

    private static void test() {
        Utils.printListln(restoreIpAddresses("25525511135"));
        Utils.printListln(restoreIpAddresses("0279245587303"));
        Utils.printListln(restoreIpAddresses("010010"));
    }

    public static void main(String[] args) {
        test();
    }
}
