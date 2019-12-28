package com.antonylhz.shuati.summary;


import java.util.ArrayList;
import java.util.List;

/**
 * Intervals related questions
 */
public class Intervals {


    /**
     *
     * @param intervals Original sorted intervals
     * @param newInterval New interval that is to be inserted
     * @return New list after insertion
     */
    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>(intervals.size() + 1);
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start || interval.start > newInterval.end) {
                res.add(interval);
            } else {
                int start = Math.min(interval.start, newInterval.start);
                int end = Math.max(interval.end, newInterval.end);
                while (i < intervals.size() - 1) {
                    interval = intervals.get(++i);
                    if (interval.start <= end + 1) {
                        end = Math.max(end, interval.end);
                    } else {
                        break;
                    }
                }
                i--;
                res.add(new Interval(start, end));
            }
        }
        return res;
    }


    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public List<Interval> mergeIntervals(List<Interval> list1, List<Interval> list2) {
        return null;
    }

    private class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


