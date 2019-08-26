package google;
import java.util.*;


// https://leetcode.com/problems/strobogrammatic-number-iii/
// Recursive call for 0, 1, 8, 69, 96, compare length with low and high
class StrobogrammaticNumber {
    int res = 0;

    public int countStrobogrammaticNumber(String low, String high) {
        find(low, high, "");
        find(low, high, "0");
        find(low, high, "1");
        find(low, high, "8");
        return res;
    }

    private void find(String low, String high, String curr) {
        if(curr.length() <= high.length() && curr.length() >= low.length()) {
            if(curr.length() == high.length() && curr.compareTo(high) > 0) {
                return;
            }

            if(!curr.startsWith("0") && !(curr.length() == low.length() && curr.compareTo(low) < 0)) {
                res ++;
            }
        }

        find(low, high, "0" + curr + "0");
        find(low, high, "1" + curr + "1");
        find(low, high, "8" + curr + "8");
        find(low, high, "6" + curr + "9");
        find(low, high, "9" + curr + "6");
    }
}
