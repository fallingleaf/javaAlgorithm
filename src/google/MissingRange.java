package google;
import java.util.*;

/*
- https://leetcode.com/problems/missing-ranges
- Given a range lower and upper (inclusive), and a list of number in range,
- return missing range
*/
class MissingRange {
    List<String> findMissingRange(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();

        int next = lower;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < next) {
                continue;
            }

            if(nums[i] == next) {
                next ++;
                continue;
            }

            ans.add(getRange(next, nums[i] - 1));
        }

        if(next <= upper) {
            ans.add(getRange(next, upper));
        }

        return ans;

    }

    String getRange(int s, int e) {
        return s == e ? String.valueOf(s) : String.format("%d->%d", s, e);
    }
}
