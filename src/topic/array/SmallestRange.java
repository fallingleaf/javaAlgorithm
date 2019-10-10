package array;


// https://leetcode.com/problems/smallest-range-i/
// can add -K to K to value of array find smallest different
public class SmallestRange {
    public int smallestRangeI(int[] A, int K) {
        // return max(0, max(A) - min(A) - 2*K)
    }


    // https://leetcode.com/problems/smallest-range-ii/
    // Sort array
    /*
    def smallestRangeII(self, A, K):
       """
       :type A: List[int]
       :type K: int
       :rtype: int
       """
       A.sort()
       mi, ma = A[0], A[-1]
       res = ma - mi
       for i in range(len(A) - 1):
           a, b = A[i], A[i+1]
           res = min(res, max(a + K, ma - K) - min(b - K, mi + K))
       return res
     */
}
