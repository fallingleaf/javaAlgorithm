package array;

import java.util.*;


class MaxSubArraySum {

    // Kadan algorithm
    int maxSumSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxUntil = 0;

        for(int num: nums) {
            maxUntil += num;

            if(maxSoFar < maxUntil) {
                maxSoFar = maxUntil;
            }

            if(maxUntil < 0) {
                maxUntil = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubArraySum ms = new MaxSubArraySum();
        int[] nums = new int[] {2, -2, 1, 4, -1, 0, -8, 3};
        System.out.println("max sub array..." + ms.maxSumSubArray(nums));
    }
}
