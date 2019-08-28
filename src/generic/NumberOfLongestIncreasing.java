package generic;
import java.util.*;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// Use an extra array to store count of sequence for length at index i
// If xj < xi:
// 2 cases:
// - if length j >= length i, count[i] = count[j] + 1
// - if length j + 1 == length j, count[i] += count[j]
// Finally, find sum of count for longest length
public class NumberOfLongestIncreasing {

    public int findNumberOfLIS(int[] nums) {

        int[] length = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        counts[i] = counts[j];
                    } else if(length[j] + 1 == length[i]) {
                        counts[i] += counts[j];
                    }

                }
            }

        }

        int longest = 0, ans = 0;
        for (int len: length) {
            longest = Math.max(longest, len);
        }

        for(int i = 0; i < nums.length; i++) {
            if(length[i] == longest) {
                ans += counts[i];
            }
        }


        return ans;
    }
}
