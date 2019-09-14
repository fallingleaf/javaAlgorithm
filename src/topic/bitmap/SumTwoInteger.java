package bitmap;
import java.util.*;

// https://leetcode.com/problems/sum-of-two-integers/submissions/
// a ^ b return sum of a and b for non duplicate bits
// a & b << 1 return carry bits
// repeat above process until has no carry bits
public class SumTwoInteger {
    public int getSum(int a, int b) {
        while(b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
