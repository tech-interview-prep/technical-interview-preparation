/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */
package facebook;

import java.util.Arrays;
import java.util.Comparator;

import utils.Interval;

/**
 * https://leetcode.com/problems/meeting-rooms/
 * @author bkoteshwarreddy
 */
public class _252MeetingRooms {

}

class Solution_MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return true;
        }
        int[]begin = new int[len];
        int[]stop = new int[len];
        for (int i = 0; i < len; i++) {
            begin[i] = intervals[i].start;
            stop[i] = intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);

        for (int i = 1; i < len; i++) {
            if (begin[i] < stop[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].start < end) {
                return false;
            } else {
                end = Math.max(end, intervals[i].end);
            }
        }
        return true;
    }
}
