package array;


// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Remove duplicate at most twice
// Use idx pointer to store fill position, check if current number > number of
// 2 previous index, then fill with current number
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int idx = 0;

        for(int num: nums) {
            if(idx < 2 || num > nums[idx - 2]) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
