package array;
import java.util.*;


// https://leetcode.com/problems/merge-intervals/
// Give a list of interval start end, merge them
// Solution: sort interval by start time
// Add interval into stack, if new interval start time < current stack end time
// => overlap, merge them by setting start end = max(stack_end, new_interval_end)
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        Collection.sort(intervals, (i1, i2) -> i1.start - i2.start);
        ans.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval last = ans.get(ans.size() - 1);
            Interval curr = intervals.get(i);

            if(curr.start <= last.end) {
                last.end = Math.max(curr.end, last.end);
            } else {
                ans.add(curr);
            }
        }

        return ans;
    }
}
