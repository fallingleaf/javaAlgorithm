package string;
import java.util.*;


// Google
// https://leetcode.com/problems/fraction-to-recurring-decimal/submissions/
// Find recurring value of fraction
// Cases: numerator is 0, negative number, overflow
// Use hashmap to store remain value with index,
// everytime check if new value exists
public class FractionDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        long num = Math.abs((long)numerator), div = Math.abs((long)denominator);
        String sign = (numerator > 0) == (denominator > 0) ? "" : "-";

        HashMap<Long, Integer> hm = new HashMap<> ();
        long val = num/div;
        long remain = (num - val*div)*10;
        if(remain == 0) {
            return sign + val;
        }
        StringBuilder sb = new StringBuilder(sign + val);
        sb.append('.');
        while(remain != 0) {
            if(hm.containsKey(remain)) {
                int index = hm.get(remain);
                sb.insert(index, '(');
                sb.append(')');
                break;
            }
            hm.put(remain, sb.length());
            val = remain/div;
            sb.append("" + val);
            remain = (remain - val*div)*10;
        }
        return sb.toString();
    }
}
