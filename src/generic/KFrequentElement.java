package generic;
import java.util.*;


public class TopKFrequentElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<> ();

        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Use min heap size k
        PriorityQueue<Integer> heap = new PriorityQueue((n1, n2) -> count.get(n1) - count.get(n2));

        for(int n: count.keySet()) {
            heap.offer(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> topK = new ArrayList<> ();

        while(!heap.isEmpty()) {
            topK.add(heap.poll());
        }

        Collections.reverse(topK);
        return topK;
    }
}
