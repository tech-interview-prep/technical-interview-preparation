package leetcode.algorithms;

/**
 * Convert a number to hex
 * <p>
 * Created by kiyan on 6/3/16.
 */
public class ConvertToHex {

    private ConvertToHex c;

    /**
     *
     */
    public String convert(int num, int base) {
        // Deal with negative numbers
        boolean isNegative = false;
        if (num < 0 && base == 10) {
            isNegative = true;
            num = -num;
        }

        // Process individual digits
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int rem = num % base;
            char c = (char) ((rem > 9) ? (rem - 10) + 'a' : rem + '0');
            sb.insert(0, c);
            num = num / base;
        }

        // If number is negative, append '-'
        if (isNegative)
            sb.insert(0, '-');
        return sb.toString();
    }

    /**
     * Using bit mask and bit-wise operation
     */
    public String convertB(int num) {
        int mask = 15;
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int index = (num & mask);
            char c = (char) ((index < 10) ? (index + '0') : ('a' + index - 10));
            sb.append(c);
            num = num >>> 4;
        }
        sb.reverse();
        return sb.toString();
    }
}
