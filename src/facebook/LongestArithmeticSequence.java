package facebook;
import java.util.*;

/*
    Find longest increasing sequence with same increase value e.g: 0, 2, 4
    Use double dictionary to store length for each sequence with same delta
    Each time calculate delta, and check if length of that delta in previous part
*/
public class LongestArithmeticSequence {

    public int findLongestArithmeticSequence(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Map<Integer, HashMap<Integer, Integer>> cache = new HashMap<> ();
        int ans = 1;

        for(int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> length = new HashMap<> ();
            // Put new hash map for value i
            cache.put(nums[i], length);

            for(int j = 0; j < i; j++) {
                // Calculate delta and look up length for this delta
                int delta = nums[i] - nums[j];
                HashMap<Integer, Integer> distance = cache.get(nums[j]);
                // Min length is 2 e.g: 0, 2
                int currLength = Math.max(2, distance.getOrDefault(delta, 0) + 1);
                ans = Math.max(ans, currLength);
                length.put(delta, currLength);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSequence ls = new LongestArithmeticSequence();
        System.out.println(ls.findLongestArithmeticSequence(new int[] {0, 2, 4, 5, 6, 7, 10, 13, 16, 19 }));
    }
}
