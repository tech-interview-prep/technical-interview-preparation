package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * https://leetcode.com/problems/merge-intervals/
 */
public class _056MergeIntervals {
    public static void main(String[] args) {
        Solution_MergeIntervals sol = new Solution_MergeIntervals();

        //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18] --> [1, 10], [15, 18]
        for (Interval interval : sol.merge(Interval.getSampleIntervals())) {
            System.out.print(interval + "\t");
        }
        System.out.println();

        //[1, 4], [4, 5] --> [1, 5]
        for (Interval interval : sol.merge(Interval.getSampleIntervals2())) {
            System.out.print(interval + "\t");
        }
        System.out.println();

        //[1, 4], [2, 3] --> [1, 4]
        for (Interval interval : sol.merge(Interval.getSampleIntervals3())) {
            System.out.print(interval + "\t");
        }
        System.out.println();
    }
}

class Solution_MergeIntervals {
    public ArrayList<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0, s = intervals.size(); i < s; ) {
            Interval interval = new Interval(intervals.get(i).start, intervals.get(i).end);
            for (i++; i < s && intervals.get(i).start <= interval.end; i++) {
                interval.end = Math.max(intervals.get(i).end, interval.end);
            }
            ret.add(interval);
        }

        return ret;
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1)
            return intervals;

        // sort intervals by using self-defined Comparator
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            if (prev.end >= curr.start) {
                // merged case
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);

        return result;
    }

    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}
