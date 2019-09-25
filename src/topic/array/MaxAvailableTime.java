package array;
import java.util.*;


// Give a list of available times for each person: start, end (exclusive)
// Find time where most people can attend meeting
// Use hashmap: start time +1, end time -1
// Sort all time point and count number of available persons
public class MaxAvailableTime {
    public int maxAvailableTime(int[][] times) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        ArrayList<Integer> points = new ArrayList<>();

        for(int[] time: times) {
            counter.put(time[0], counter.getOrDefault(time[0], 0) + 1);
            counter.put(time[1], counter.getOrDefault(time[1], 0) - 1);

            points.add(time[0]);
            points.add(time[1]);
        }

        int ans = 0;
        int curr = 0;
        int prev = -1;
        int time = -1;

        Collections.sort(points);

        for(int point: points) {
            if(point == prev) {
                continue;
            }

            curr += counter.get(point);
            if(curr > ans) {
                time = point;
                ans = curr;
            }
            prev = curr;
        }
        return time;
    }

    public static void main(String[] args) {
        MaxAvailableTime mat = new MaxAvailableTime();
        int[][] times = new int[][] { {12, 33}, {8, 50}, {0, 10}, {20, 30}, {45, 60}};
        System.out.println("Time where most people can attend: " + mat.maxAvailableTime(times));
    }
}
