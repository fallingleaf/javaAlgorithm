package expedia;
import java.util.*;


// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
// There always 1 half of array sorted, check if it's right or left side of mid
// position by compare nums[mid] and nums[right]
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while(l <= r) {
            mid = l + (r - l)/2;
            if(nums[mid] == target) {
                return mid;
            }

            // Right side is not sorted, check left side
            if(nums[mid] > nums[r]) {
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // Right side is sorted
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
