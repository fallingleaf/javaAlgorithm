package sort;
import java.util.*;


// Hard
// https://leetcode.com/problems/maximum-gap/
// Give unsorted array, find maximum difference between successive element in sorted order
// e.g [3, 6, 9, 1] => 3, 6 or 6, 9 has difference of 3
// Use comparison sort: runtime 0(nlogn)
// Use bucket sort: calculate range = max - min, interval = length/(max - min)
// Each bucket has at most 2 values low and high
// Calculate bucket index = (num - min) * interval
public class MaximumGap {

    class Bucket {
        int low;
        int high;
        
        public Bucket() {
            low = -1;
            high = -1;
        }

        @Override
        public String toString() {
            return low + "," + high;
        }
    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if(max == min) {
            return 0;
        }

        // Calculate interval
        double interval = (double) nums.length/(max - min);

        Bucket[] buckets = new Bucket[nums.length+1];
        for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new Bucket();
        }

        // Put number into buckets
        for(int num: nums) {
            int index = (int) ((num - min) * interval);

            if(buckets[index].low == -1) {
                buckets[index].low = num;
                buckets[index].high = num;
            } else {
                buckets[index].low = Math.min(buckets[index].low, num);
                buckets[index].high = Math.max(buckets[index].high, num);
            }
        }

        int ans = 0;
        int prev = min;

        for(Bucket bucket: buckets) {
            if(bucket.low != -1) {
                ans = Math.max(ans, bucket.low - prev);
                prev = bucket.high;
            }
        }

        return ans;
    }
}
