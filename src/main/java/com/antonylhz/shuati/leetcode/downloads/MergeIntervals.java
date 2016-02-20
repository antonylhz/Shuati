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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()<2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }});
        int i = 1, start = intervals.get(0).start, end = intervals.get(0).end;
        boolean overlap = false;
        while(i<intervals.size()) {
            if(intervals.get(i).start>end) {
                if(overlap) {
                    intervals.add(i, new Interval(start, end));
                    intervals.remove(i-1);
                    overlap = false;
                }
                end = intervals.get(i).end;
                i++;
            } else {
                if(!overlap) {
                    start = intervals.get(i-1).start;
                    overlap = true;
                }
                end = end > intervals.get(i).end ? end : intervals.get(i).end;
                intervals.remove(i-1);
            }
        }
        if(overlap) {
            intervals.remove(intervals.size()-1);
            intervals.add(new Interval(start, end));
        }
        return intervals;
    }
}
