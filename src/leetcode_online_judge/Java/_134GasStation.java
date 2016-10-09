package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _134GasStation {
    /*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
    You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
    The solution is guaranteed to be unique.
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start, end, diff = 0;
        for (start = 0, end = gas.length - 1; start <= end; start++) {
            diff += gas[start] - cost[start];
            while (diff < 0 && end > start) {
                diff += gas[end] - cost[end];
                end--;
            }
        }
        return diff < 0 ? -1 : start % gas.length;
    }

    public static void test() {
        Utils.printTestln(canCompleteCircuit(new int[] {4}, new int[] {5}), -1);
        Utils.printTestln(canCompleteCircuit(new int[] {5}, new int[] {4}), 0);
        Utils.printTestln(canCompleteCircuit(new int[] {1, 2}, new int[] {2, 1}), 1);
        Utils.printTestln(canCompleteCircuit(new int[] {2, 3, 1}, new int[] {3, 1, 2}), 1);
        Utils.printTestln(canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}), 3);
        Utils.printTestln(canCompleteCircuit(new int[] {6, 0, 1, 3, 2}, new int[] {4, 5, 2, 5, 5}), -1);
    }

    public static void main(String[] args) {
        test();
    }
}
