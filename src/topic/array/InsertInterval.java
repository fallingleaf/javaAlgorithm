package array;
import java.util.*;


// Google: HARD
// https://leetcode.com/problems/insert-interval/
// Give a list of non-overlap intervals, insert new intervals
// Solution: loop through list compare interval and new interval
// - newInterval.end < interval.start: add interval and set new interval = current
// - newInterval.start > interval.end: add current interval
// - new interval overlap current: merge 2 interval and set new interval = merged
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }

        for(Interval interval: intervals) {
            if(newInterval.end < interval.start) {
                ans.add(newInterval);
                newInterval = interval;
            } else if(newInterval.start > interval.end) {
                ans.add(interval);
            } else {
                // Merge 2 intervals
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        ans.add(newInterval);
        return ans;
    }
}
