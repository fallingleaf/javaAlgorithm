package generic;
import java.util.*;


public class BinarySearch {
    public int searchInsertPosition(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }

        if(k > nums[nums.length - 1]) {
            return nums.length;
        }

        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l)/2;
            if(k > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
