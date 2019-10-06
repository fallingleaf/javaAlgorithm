package array;


// HARD
// https://leetcode.com/problems/first-missing-positive/
// Give array of number, find first missing positive number
// Solution: put number in correct position where nums[i] =  i + 1
// Check for number in incorrect position
class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }

        int i = 0;
        while(i < nums.length) {
            int val = nums[i];
            if(val > 0 && val <= nums.length && nums[val - 1] != val) {
                nums[i] = nums[val - 1];
                nums[val - 1] = val;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}
