package array;
import java.util.*;


// https://leetcode.com/problems/contains-duplicate-iii/
// check if there i, j pairs: i - j <= k and nums[i] - nums[j] <= t
// Use treeset: store value in set, if i >= k remove outdated i - k number
// calculate left boundary and right boundary, nums[i] - t and nums[i] + t
// Use subset to find if there other number in range
// Other solution: use bucket of size t, bucket = num / t, check if number in bucket
// m + 1 and m - 1 has different < t
public class ContainDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length < 2 || k < 0 || t < 0)
            return false;

        TreeSet<Long> set = new TreeSet<Long>();
        for(int i=0; i<nums.length; i++){
            long curr = (long) nums[i];

            long leftBoundary = (long) curr - t;
            long rightBoundary = (long) curr + t + 1; //right boundary is exclusive, so +1
            SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
            if(sub.size()>0)
                return true;

            set.add(curr);

            if(i>=k) { // or if(set.size()>=k+1)
                set.remove((long) nums[i-k]);
            }
        }

        return false;
    }
}
