package facebook;

import java.util.ArrayList;

import utils.Interval;
import utils.Utils;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *     Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 *     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * https://leetcode.com/problems/insert-interval/
 * http://www.programcreek.com/2012/12/leetcode-insert-interval/
 * http://n00tc0d3r.blogspot.com/2013/03/insert-interval.html
 */
public class _057InsertInterval {
    public static void main(String[] args) {
        Solution_InsertInterval sol = new Solution_InsertInterval();

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        Utils.printListln(sol.insert(intervals, new Interval(4, 9)));

        intervals.clear();
        intervals.add(new Interval(1, 5));
        Utils.printListln(sol.insert(intervals, new Interval(2, 3)));
    }
}

class Solution_InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
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

    public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);

        return result;
    }
}
