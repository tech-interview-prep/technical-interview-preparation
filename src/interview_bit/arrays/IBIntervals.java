package interview_bit.arrays;

import java.util.ArrayList;

import utils.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

 Example 2:

 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Make sure the returned intervals are also sorted.
 */
public class IBIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();

        //If the inital intervals list is empty, return newInterval
        if(intervals.isEmpty()){
            result.add(newInterval);
            return result;
        }


        int orgStart = intervals.get(0).start;
        int orgEnd = intervals.get(intervals.size()-1).end;
        int orgSize = intervals.size();



        //Case where the new interval precedes all the existing intervals
        if(newInterval.end < orgStart){
            intervals.add(0,newInterval);
            return intervals;
        }

        //Case where the new interval succeeds all the existing intervals
        if(newInterval.start > orgEnd){
            intervals.add(orgSize,newInterval);
            return intervals;
        }

        //Case when the new interval encompasses all existing intervals
        if(newInterval.start < orgStart && newInterval.end > orgEnd){
            result.add(newInterval);
            return  result;

        }

        //Find overlapping and non-overlapping intervals
        ArrayList<Integer> overlapInds = new ArrayList<Integer>();
        for(int i=0;i<orgSize-1;i++){
            Interval currInterval = new Interval();
            Interval nextInterval = new Interval();

            currInterval = intervals.get(i);
            nextInterval = intervals.get(i+1);

            //Case when there is no overlap
            if(newInterval.start > currInterval.end && newInterval.end < nextInterval.start){
                intervals.add(i+1,newInterval);
                return intervals;
            }

            //Find the intervals that newInterval overlaps with
            if(Math.max(newInterval.start,currInterval.start) <= Math.min(newInterval.end,currInterval.end)){
                overlapInds.add(i);

            }

            //Account for overlap with the last interval, since loop goes to size-1 only
            if((Math.max(newInterval.start,nextInterval.start) <= Math.min(newInterval.end,nextInterval.end)) && i+1==orgSize-1){
                overlapInds.add(i+1);
            }

        }


        //Post-processing after the overlapping intervals are obtained
        Interval i1,i2;
        Interval mergeInterval = new Interval();

        int mergeStartInd,mergeEndInd;
        mergeStartInd = overlapInds.get(0);
        mergeEndInd = overlapInds.get(overlapInds.size()-1);

        i1 = intervals.get(mergeStartInd);
        i2 = intervals.get(mergeEndInd);

        //Find the start and end values for the merged interval

        mergeInterval.start = Math.min(newInterval.start, i1.start);
        mergeInterval.end = Math.max(newInterval.end,i2.end);


        //Remove from the original list of intervals, the intervals that have been merged

        for(int i=mergeEndInd;i>=mergeStartInd;i--){
            intervals.remove(i);
        }

        //Add the merged interval
        intervals.add(mergeStartInd,mergeInterval);

        return intervals;


    }
}
