package leetcode_online_judge.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.Interval;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _056MergeIntervals {
    /*
    Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
     */
    public static ArrayList<Interval> merge(List<Interval> intervals) {
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


    private static void test() {
        //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18] --> [1, 10], [15, 18]
        for (Interval interval : merge(Interval.getSampleIntervals())) {
            System.out.print(interval + "\t");
        }
        System.out.println();

        //[1, 4], [4, 5] --> [1, 5]
        for (Interval interval : merge(Interval.getSampleIntervals2())) {
            System.out.print(interval + "\t");
        }
        System.out.println();

        //[1, 4], [2, 3] --> [1, 4]
        for (Interval interval : merge(Interval.getSampleIntervals3())) {
            System.out.print(interval + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
