package generic;
import java.util.*;

/*
- Find minimum length of sub array for total sum larger or equal than k value
- Use 2 pointers: increase hi and add to sum, if sum exceeds k, then increase
lo and calculate len
*/
public class SubarraySum {
    public int findMinSubarrayLen(int[] nums, int k) {
        int len = nums.length + 1;
        int sum = 0;

        int lo = 0, hi = 0;

        while(hi < nums.length) {
            sum += nums[hi];
            while(sum >= k) {
                len = Math.min(len, hi - lo + 1);
                sum -= nums[lo];
                lo ++;
            }
            hi ++;
        }

        return len > nums.length ? -1 : len;
    }

    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int ans = ss.findMinSubarrayLen(new int[] {2, 5, 6, 1, 3, 11, 2, 4}, 14);
        System.out.println("min sub array len: " + ans);
    }
}
