package bitmap;


// Facebook
public class SingleNumber {
    // https://leetcode.com/problems/single-number/
    // one number appears once, other appears twice, find that number
    // Use Xor operation: 1^1 = 0, 0 ^ 1 = 1
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }

    // https://leetcode.com/problems/single-number-ii/
    // Every number appears 3 times, one number appear once
    // Solution: record number appear ones and two times
    // number appear 3 times = one & time, then remove 3rd appear number
    // from ones and twos
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            // Record number appear second time => x & x = x
            twos |= ones & nums[i];
            // Record number appear one time: x ^ x = 0
            ones ^= nums[i];
            // Record number appear third times: ones & twos
            threes = ones & twos;
            // Remove third times number from ones and twos
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    // https://leetcode.com/problems/single-number-iii/
    // Two number appear once, find them
    // Xor all number in array, result = num1 ^ num2 e.g 3 = 011, 5 = 101
    // 3 ^ 5 = 110, 2 bit 1 are where bit different between 2 number
    // choose right most bit one, divide array into 2 groups: & bit = 0 and & bit = 1
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        int xor = nums[0];

        for (int i=1; i<nums.length; i++) {
            xor ^= nums[i];
        }

        // Take the right most bit
        int bit = xor & ~(xor-1);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums)
        {
            if ((num & bit) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;
    }
}
