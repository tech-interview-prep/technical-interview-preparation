package leetcode_online_judge;

import java.util.List;
import java.util.ArrayList;

public class Interval {
    public int start;
    public int end;
    public Interval() {
        start = end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    //[1, 3], [2, 6], [5, 9], [8, 10], [15, 18]
    public static List<Interval> getSampleIntervals() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 3));
        ret.add(new Interval(2, 6));
        ret.add(new Interval(5, 9));
        ret.add(new Interval(8, 10));
        ret.add(new Interval(15, 18));

        return ret;
    }

    //[1, 4], [4, 5]
    public static List<Interval> getSampleIntervals2() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(4, 5));

        return ret;
    }

    //[1, 4], [2, 3]
    public static List<Interval> getSampleIntervals3() {
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(new Interval(1, 4));
        ret.add(new Interval(2, 3));

        return ret;
    }
}
