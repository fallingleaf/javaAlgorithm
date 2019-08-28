package generic;
import java.util.*;


public class ShuffleArray {
    private int[] arr;

    public ShuffleArray(int[] nums) {
        arr = nums;
    }

    public int[] reset() {
        return arr;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int[] shuffle() {
        int[] nums = arr.clone();
        Random random = new Random();
        for(int i = 0; i < nums.length; i++) {
            int rand = random.nextInt(nums.length - i) + i;
            swap(nums, rand, i);
        }

        return nums;
    }
}
