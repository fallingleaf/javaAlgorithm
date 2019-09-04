package array;
import java.util.*;


// Facebook
// https://leetcode.com/problems/product-of-array-except-self/
// Solution1: use division: calculate product of all except 0, store index of 0
// if 2 more 0, return zeros array, if index != index Of zero, contains 0 => 0
// Solution2: without division: use sub array to store product from right side
// move i from left and multiple with product of right side
// Clarify: what if array has 1 element
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return new int[0];
        }
        int[] rightProduct = nums.clone();
        int[] ans = new int[len];

        for(int i = len - 2; i >= 0; i--) {
            rightProduct[i] *= rightProduct[i+1];
        }

        int leftProduct = 1;

        for(int j = 0; j < len; j++) {
            ans[j] = leftProduct;
            if(j < len - 1) {
                ans[j] *= rightProduct[j+1];
            }
            leftProduct *= nums[j];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
