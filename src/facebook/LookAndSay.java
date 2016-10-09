package facebook;

/**
 * Write a program to find pattern.
 *
 *     0: 1
 *     1: 11
 *     2: 21
 *     3: 1211
 *     4: 111221
 *     5: 312211
 *
 * Iterate over the previous number, and find count for same number number. Append that count before number.
 *
 * e.g.,
 *
 * public String pattern(int input){}
 *
 * If input = 4, function should return 111221.
 *
 * http://www.careercup.com/question?id=5146925198213120
*/
public class LookAndSay {
    public String lookAndSay(int input) {
        if (input < 0) {
            return "";
        }
        String output = "1";
        for (int i = 0; i < input; i++) {
            output = lookAndSay(input, output);
        }
        return output;
    }

    private String lookAndSay(int input, String str) {
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(last);
                last = str.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(last);
        return sb.toString();
    }
}
