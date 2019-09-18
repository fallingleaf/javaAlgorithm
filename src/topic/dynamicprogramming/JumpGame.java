package dynamicprogramming;
import java.util.*;


// https://leetcode.com/problems/jump-game/
// Give array of non-negative numbers indicates number of jump at position i
// Determine if can jump to last index starting at 0
// at each position, calculate max position can reach
// If i go over reach, return false, if reach >= n - 1 return true
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length <= 0) {
            return true;
        }

        int reach = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > reach) {
                return false;
            }

            reach = Math.max(reach, i + nums[i]);
            if(reach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    // Find minimum number of jumps to reach end of index
    // e.g [2,3,1,1,4] => jump from 0 index to index 1 to index 4
    // BFS: calculate current max can reach, then for each index in current
    // reach, calculate next distance can reach
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }

        int currentDistance = 0;
        int nextDistance = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > currentDistance) {
                ans ++;
                currentDistance = nextDistance;
            }

            nextDistance = Math.max(nextDistance, nums[i] + i);
        }

        if(nextDistance < nums.length - 1) {
            return -1;
        }
        return ans;
    }
}
