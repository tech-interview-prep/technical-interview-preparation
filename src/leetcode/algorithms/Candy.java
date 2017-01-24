package leetcode.algorithms;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class Candy {
    /*
    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
     */
    public static int candy(int[] ratings) {
        int total = 0, start = 0;
        for (int i = 0, j; i < ratings.length; ) {
            if (i > 0 && ratings[i] == ratings[i - 1]) {
                start = 0;
            }
            for (j = i + 1; j < ratings.length && ratings[j - 1] > ratings[j]; j++);
            total += (j - i + 1) * (j - i) / 2 + Math.max(0, start - j + i + 1);
            start = j - i > 1 ? 1 : start + 1;
            i = j;
        }

        return total;
    }

    public static void test() {
        Utils.printTestln(candy(new int[] {1, 1, 2, 4, 5, 6, 4}), 17);
        Utils.printTestln(candy(new int[] {1, 5, 2, 4, 2, 6, 4}), 10);
        Utils.printTestln(candy(new int[] {2, 2, 1}), 4);
        Utils.printTestln(candy(new int[] {1, 2, 2, 1}), 6);
        Utils.printTestln(candy(new int[] {1, 2, 2, 2, 1}), 7);
        Utils.printTestln(candy(new int[] {11, 13, 8, 9, 4, 3, 2, 5, 7}), 19);
        Utils.printTestln(candy(new int[] {1, 2, 3, 4}), 10);
        Utils.printTestln(candy(new int[] {4, 3, 2, 1}), 10);
        Utils.printTestln(candy(new int[] {4, 2, 3, 4, 1}), 9);
        Utils.printTestln(candy(new int[] {5, 1, 1, 1, 10, 2, 1, 1, 1, 3}), 15);
        Utils.printTestln(candy(new int[] {58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82}), 22);
        Utils.printTestln(candy(new int[] {58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89, 54, 26, 54, 54, 99}), 40);
    }

    public static void main(String[] args) {
        test();
    }


}
