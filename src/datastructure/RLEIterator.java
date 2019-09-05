package datastructure;
import java.util.*;

/*
- Google
- https://leetcode.com/problems/rle-iterator/
*/
class RLEIterator {
    int[] arr;
    int curr;

    public RLEIterator(int[] A) {
        arr = A;
        curr = 0;
    }

    public int next(int n) {
        while(curr < arr.length && arr[curr] < n) {
            n -= arr[curr];
            arr[curr] = 0;
            curr += 2;
        }


        if(curr < arr.length - 1) {
            arr[curr] -= n;
            return arr[curr + 1];
        }

        return -1;

    }
}
