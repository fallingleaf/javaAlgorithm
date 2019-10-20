package queuestack;

import java.util.*;


// https://leetcode.com/problems/132-pattern/submissions/
// Give list of integer, find if i < j < k and s1 < s3 < s2
// Brute force: 3 loops, find i, j, k => n^3
// Improve: 2 loop 1 for i, j, 1 from j + 1 to length for k
// Improve: we need to find s2 > s3, ideally transver from right to left, if we
// find s2 > s3, then just need to find s1 < s3
// Use stack to store s3, if s2 > stack peek(), pop from stack s3 is candidate 
public class 132Pattern {
    boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < s3) return true;
            else {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }
}
