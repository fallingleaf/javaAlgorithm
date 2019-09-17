package queuestack;
import java.util.*;

/*
Find K largest elements in array
- 1: can sort array
- 2: can use min heap
- 3: use quick select
*/
public class KLargestElement {
    public Integer findKthLargest(int[] nums, int k) {
        if(nums.length < k) {
            return null;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for(int num: nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

    public static void main(String[] args) {
        KLargestElement ke = new KLargestElement();
        System.out.println("K largest elements..." + ke.findKthLargest(new int[] {10, 1, 9, 23, 4, 5, 7}, 3));
    }

}
