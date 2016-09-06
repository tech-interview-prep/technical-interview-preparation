package leetcode_online_judge.Java;

import utils.Interval;
import utils.Utils;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _057InsertInterval {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i, l;
        ArrayList<Interval> ret = new ArrayList<Interval>();
        for (i = 0, l = intervals.size(); i < l && intervals.get(i).end < newInterval.start; ret.add(intervals.get(i)), i++);

        if (i < l) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        }

        for (; i < l && newInterval.end >= intervals.get(i).start; newInterval.end = Math.max(newInterval.end, intervals.get(i).end), i++);
        ret.add(newInterval);
        for (; i < l; ret.add(intervals.get(i++)));

        return ret;
    }

    private static void test() {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        Utils.printListln(insert(intervals, new Interval(4, 9)));

        intervals.clear();
        intervals.add(new Interval(1, 5));
        Utils.printListln(insert(intervals, new Interval(2, 3)));
    }

    public static void main(String[] args) {
        test();
    }
}
