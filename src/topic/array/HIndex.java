package array;


// https://leetcode.com/problems/h-index/
// Give n articles, h index is has h articles with at least h citations
// and n - h articles has not more than h citations
// Solution: Sort array: loop array for i => h index = n - i check if citations
// i >= n - i bc later number >= current number
// Optimize: observe that h index is not more than length of array
// Using counting sort: counter[min(val, len)] ++
// Then loop from right to left, accumulate count articles check if sum >= j
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for(int i = 0; i < n; i++) {
            if(citations[i] >= n - i) {
                return n - i;
            }
        }

        return 0;
    }

    // Counting sort version
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len+1];

        for(int c: citations){
            counter[Math.min(len,c)]++;
        }

        int k=len;
        for(int s=counter[len]; k > s; s += counter[k]){
            k--;
        }

        return k;
    }


    // https://leetcode.com/problems/h-index-ii/
    // If array already sorted, use binary search
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0) {
            return 0;
        }

        int left = 0, right = len - 1, mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(citations[mid] == len - mid) {
                return len - mid;
            else if(citations[mid] > len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return len - left;
    }
}
