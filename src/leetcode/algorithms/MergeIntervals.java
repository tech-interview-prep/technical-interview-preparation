package leetcode.algorithms.level.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import utils.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * https://leetcode.com/problems/merge-intervals/
 * http://n00tc0d3r.blogspot.com/2013/04/merge-intervals.html
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution_MergeIntervals sol = new Solution_MergeIntervals();

        //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18] --> [1, 10], [15, 18]
//        for (Interval interval : sol.merge(Interval.getSampleIntervals())) {
//            System.out.print(interval + "\t");
//        }
//        System.out.println();
//
//        //[1, 4], [4, 5] --> [1, 5]
//        for (Interval interval : sol.merge(Interval.getSampleIntervals2())) {
//            System.out.print(interval + "\t");
//        }
//        System.out.println();
//
//        //[1, 4], [2, 3] --> [1, 4]
//        for (Interval interval : sol.merge(Interval.getSampleIntervals3())) {
//            System.out.print(interval + "\t");
//        }
//        System.out.println();
    }
}

class Solution_MergeIntervals {
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
                prev = new Interval(prev.start, Math.max(prev.end, curr.end));
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
