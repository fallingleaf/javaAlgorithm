package array;
import java.util.*;


// Google
// https://leetcode.com/articles/gas-station/
// Each gas station i has gas[i] amount, require cost[i] to travel from station
// i to station i+1, return starting station if can complete circle, -1
// otherwise
// Brute force: check each station for tank = gas[i] - cost[i] => O(n^2)
// Optimize: cannot start with gas < cost at station i,
class GasStation {
    public int canCompleteCircle(int[] gas, int[] cost) {
        int total_tank = 0;
        int current_tank = 0;
        int starting_station = 0;

        for(int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];

            if(current_tank < 0) {
                current_tank = 0;
                starting_station = i + 1;
            }
        }

        return total_tank >= 0 ? starting_station : -1;
    }
}
