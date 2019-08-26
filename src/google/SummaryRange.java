package google;
import java.util.*;


// Summary range: https://leetcode.com/submissions/detail/207260673/
// Summary the range of continuous value: 0, 1, 2 => 0 -> 2
class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<> ();
        if(nums.length == 0) {
            return ans;
        }

        int len = 1;
        int t = nums.length;
        int i = 1;
        while(i < t) {
            if(nums[i] == nums[i-1] + 1) {
                len++;
            } else {
                if(len == 1) {
                    ans.add(String.valueOf(nums[i-1]));
                } else {
                    ans.add(nums[i-len] + "->" + nums[i-1]);
                }

                len = 1;
            }

            i++;
        }

        if(len == 1) {
            ans.add(String.valueOf(nums[t-1]));
        } else {
            ans.add(nums[i-len] + "->" + nums[t-1]);
        }

        return ans;

    }
}
