package array;
import java.util.*;


// Facebook
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Give array 1 <= a[i] <= n, with n is size of array, return all duplicate
// use hash map
// put number in it position, if a[i] != i + 1, check value at index: a[i] - 1
// if different then swap, if equal then has duplicate, set it to 0 and continue
// Optimize: for every number, find the index it should be at that position
// index = abs(nums[i]) - 1, flip value at that index to negative
// if encounter new number, and see value at index is negative, => duplicate
public class FindDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }


    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }

        int i = 0;
        while(i < nums.length) {
            if(nums[i] != i + 1 && nums[i] != -1) {
                int val = nums[i];
                if(nums[val-1] == val) {
                    ans.add(val);
                    nums[i] = -1;
                } else {
                    nums[i] = nums[val - 1];
                    nums[val - 1] = val;
                }
            } else {
                i ++;
            }
        }

        return ans;

    }
}
