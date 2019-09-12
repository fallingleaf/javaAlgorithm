package bitmap;
import java.util.*;


// https://leetcode.com/problems/gray-code/
// Gray code is sequence of numbers differ by 1 bit starting from 0
// give n bit return sequence of numbers
// Observe that: for 1 bit: 0 -> 1, 2 bits: 00 -> 01 -> 11 -> 10
// Flip n-1 bit and add previous list in reverse order
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if(n == 0) {
            ans.add(0);
            return ans;
        }

        ans = grayCode(n - 1);
        int addTo = 1 << (n-1);
        for(int i = ans.size() - 1; i >= 0; i--) {
            ans.add(addTo + ans.get(i));
        }

        return ans;
    }

    // Formular: G(i) = i ^ i >> 1
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
