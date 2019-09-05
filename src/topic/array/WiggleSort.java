package array;
import java.util.*;


// Sort array: nums[0] <= nums[1] >= nums[2] <= nums[3]...
// even number < odd number and odd number > even number
// check if number is even or odd and swap if not satisfy condition
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if((i % 2 == 0 && nums[i] > nums[i-1]) || (i % 2 == 1 && nums[i] < nums[i-1])) {
                int tmp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int[] nums = new int[] {2, 1, 5, 12, 11, 4, 3, 2, 2};
        System.out.println("Before sorting..." + Arrays.toString(nums));
        ws.wiggleSort(nums);
        System.out.println("After sorting..." + Arrays.toString(nums));
    }
}
