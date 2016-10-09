package facebook;

import java.util.Set;
import java.util.TreeSet;

/**
 * Write a code to print all possible combinations(order matters) of characters of string in lexicographical order.
 */
public class PrintCombinations {
    public static Set<String> printCombinationsOf(String s) {
        Set<String> result = new TreeSet<String>();
        result.add(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            Set<String> temp = printCombinationsOfHelper(s, result, i);
            result = temp;
        }
        return result;
    }

    public static Set<String> printCombinationsOfHelper(String s, Set<String> pre, int index) {
        Set<String> result = new TreeSet<String>(pre);

        for (String st : pre) {
            for (int i = 0; i < st.length(); i++) {
                result.add(st.substring(0, i) + s.charAt(index) + st.substring(i, st.length()));
            }
            result.add(st + s.charAt(index));
        }
        result.add(String.valueOf(s.charAt(index)));
        return result;
    }
}
