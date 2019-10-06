package array;


// https://leetcode.com/problems/increasing-triplet-subsequence/submissions/
// Check if array has increasing triplet x < y < z
// Use 2 var to store x, y: if number <= x, x = num, number <= y, y = number
// other wise it bigger than both x, y, we have triplet 
class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num <= small) {
                small = num;// update x to be a smaller value
            } else if (num <= big) {
                big = num; // update y to be a smaller value
            } else {
                return true;
            }
        }

        return false;
    }
}
