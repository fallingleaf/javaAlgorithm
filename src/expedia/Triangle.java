package expedia;
import java.util.*;


// Sort array then use 2 pointers to count for 3 pairs
// https://leetcode.com/problems/valid-triangle-number/
public class Triangle {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int ans = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                int k = nums.length - 1;
                while(k > j && nums[k] >= nums[i] + nums[j]) {
                    k --;
                }

                ans += k - j;
            }


        }

        return ans;

    }

    public int triangleNumber2(int[] nums) {
        int result = 0;
        if (nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    // All numbers from left to right - 1 + right > nums[i]
                    result += (right - left);
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return result;
    }
}
