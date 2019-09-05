package array;
import java.util.*;


public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        while(idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[] {3, 2, 0, 12, 0, 11, 0, 1, 15, 0};
        mz.moveZeroes(nums);
        System.out.println("new array..." + Arrays.toString(nums));
    }
}
