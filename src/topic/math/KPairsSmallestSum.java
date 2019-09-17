package math;
import java.util.*;


// Find k smalles pair in 2 sorted array
// Use sub array to store index of array 2 for each elements of array 1
// Every time find the smallest and increase the index
public class KPairsSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int total = nums1.length * nums2.length;
        List<List<Integer>> ans = new ArrayList<>();

        if(k > total) {
            k = total;
        }

        int[] secondArrIndex = new int[nums1.length];
        int min, minIdx;

        while(k > 0) {
            min = Integer.MAX_VALUE;
            minIdx = -1;

            for(int i = 0; i < nums1.length; i++) {
                if(secondArrIndex[i] < nums2.length && nums1[i] + nums2[secondArrIndex[i]] < min) {
                    min = nums1[i] + nums2[secondArrIndex[i]];
                    minIdx = i;
                }
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[minIdx]);
            pair.add(nums2[secondArrIndex[minIdx]]);
            ans.add(pair);
            secondArrIndex[minIdx] ++;
            k --;
        }
        return ans;
    }
}
