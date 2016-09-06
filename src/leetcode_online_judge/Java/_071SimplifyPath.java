package leetcode_online_judge.Java;

import utils.Utils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _071SimplifyPath {
    /*
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    click to show corner cases.

    Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuffer sb = new StringBuffer();

        int l = path.length();
        for (int i = 0; i <= l; i++) {
            if (i == l || path.charAt(i) == '/') {
                String dir = sb.toString();
                if ("..".equals(dir)){
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (sb.length() != 0 && !".".equals(dir)){
                    stack.push(dir);
                }
                sb.setLength(0);
            } else {
                sb.append(path.charAt(i));
            }
        }

        String p = stack.isEmpty() ? "/" : "";
        while (!stack.isEmpty()) {
            p = "/" + stack.pop() + p;
        }

        return p;
    }

    private static void test() {
        Utils.printTestln(simplifyPath("/a/./b/../../c/"), "/c");
        Utils.printTestln(simplifyPath("/home/"), "/home");
        Utils.printTestln(simplifyPath("/../"), "/");
        Utils.printTestln(simplifyPath("/."), "/");
        Utils.printTestln(simplifyPath("/..."), "/...");
        Utils.printTestln(simplifyPath("/home//foo/"), "/home/foo");
        Utils.printTestln(simplifyPath("/home//foo"), "/home/foo");
    }

    public static void main(String[] args) {
        test();
    }
}
