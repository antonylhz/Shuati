/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null||intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int newstart;
        if(intervals.size()==1) {
            if(intervals.get(0).start>newInterval.end) {
                intervals.add(0, newInterval);
                return intervals;
            } else if(intervals.get(0).end<newInterval.start) {
                intervals.add(newInterval);
                return intervals;
            }
            else {
                newstart = intervals.get(0).start>newInterval.start?newInterval.start:intervals.get(0).start;
                intervals.add(new Interval(newstart, intervals.get(0).end<newInterval.end?newInterval.end:intervals.get(0).end));
                intervals.remove(0);
                return intervals;
            }
        }
        int i = 0;
        if(intervals.get(0).start>=newInterval.start) {
        	if(intervals.get(0).start>newInterval.end) {
        		intervals.add(0, newInterval);
        		return intervals;
        	} else if(intervals.get(0).end>=newInterval.end) {
                intervals.add(0, new Interval(newInterval.start, intervals.get(0).end));
                intervals.remove(1);
                return intervals;
            } else {
                newstart = newInterval.start;
                intervals.remove(0);
            }
        } else {
        	while(i<intervals.size()-1&&intervals.get(i+1).start<newInterval.start) i++;
        	if(intervals.get(i).end>=newInterval.end) return intervals;
        	if(intervals.get(i).end>=newInterval.start) {
        		newstart = intervals.get(i).start<newInterval.start?intervals.get(i).start:newInterval.start;
        		intervals.remove(i);
        	} else {
        		newstart = newInterval.start;
        		i++;
        	}
        }
        if(i>=intervals.size()) intervals.add(new Interval(newstart, newInterval.end));
        else{
            if(intervals.get(i).start>newInterval.end) {
                intervals.add(i, new Interval(newstart, newInterval.end));
                return intervals;
            }
            while(i<intervals.size()&&intervals.get(i).end<newInterval.end) intervals.remove(i);
            if(i>=intervals.size()) intervals.add(new Interval(newstart, newInterval.end));
            else {
                if(intervals.get(i).start>newInterval.end) intervals.add(i, new Interval(newstart, newInterval.end));
                else {
                    intervals.add(i, new Interval(newstart, intervals.get(i).end));
                    intervals.remove(i+1);
                }
            }
        }
        return intervals;
    }
}
