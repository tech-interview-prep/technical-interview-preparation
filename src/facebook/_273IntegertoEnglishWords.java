package facebook;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Hint:
 *
 * 1. Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * 2. Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and
 * convert just that chunk to words.
 * 3. There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010?
 * (middle chunk is zero and should not be printed out)
 *
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class _273IntegertoEnglishWords {
}

class Solution_IntegertoEnglishWords {
    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = {"Billion", "Million", "Thousand", ""};
    final int[] radix = {1000000000, 1000000, 1000, 1};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < radix.length; i++) {
            if (num / radix[i] == 0) continue;
            sb.append(trans(num / radix[i])).append(THOUSANDS[i]).append(" ");
            num %= radix[i];
        }
        return sb.toString().trim();
    }

    private String trans(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + trans(num % 10);
        return LESS_THAN_20[num / 100] + " Hundred " + trans(num % 100);
    }
}
