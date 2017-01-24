package leetcode.algorithms;

import java.util.Set;
import java.util.TreeSet;

/**
 * Write a code to print all possible combinations(order matters) of characters of string in lexicographical order.
 */
public class PrintCombinations {
    public static Set<String> printCombinationsOf(String str) {
        Set<String> result = new TreeSet<String>();
        result.add(String.valueOf(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            Set<String> temp = printCombinationsOfHelper(str, result, i);
            result = temp;
        }

        return result;
    }

    public static Set<String> printCombinationsOfHelper(String str, Set<String> pre, int index) {
        Set<String> result = new TreeSet<String>(pre);

        for (String s : pre) {
            for (int i = 0; i < s.length(); i++) {
                result.add(s.substring(0, i) + str.charAt(index) + s.substring(i, s.length()));
            }
            result.add(s + str.charAt(index));
        }

        result.add(String.valueOf(str.charAt(index)));

        return result;
    }
}
