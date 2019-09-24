package sort;
import java.util.*;


// Give array of 3 color present by 0, 1, 2 Sort array
// Use sub array to store count of each color
public class SortColor {
    public void sortColor(int[] nums) {
        if(num.length < 2) {
            return;
        }

        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] ++;
        }

        int i = 0;
        int j = 0;

        while(i <= 2) {
            if(count[i] >= 0) {
                nums[j++] = i;
                count[i] --;
            } else {
                i++;
            }
        }
    }
}
