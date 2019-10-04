package array;
import java.util.*;


// https://leetcode.com/problems/zigzag-conversion/
// Reorder chars in string in zig zag order by number of rows
// solution: for diagonal number of char = numRows - 2
// Row 0 and numberRows - 1: 0, step, 2 steps ...
// inner rows: i, step - i, 2step + i, 3step - i
public class ZigZagOrder {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        // numRows - 2 + numRows
        int step = 2*numRows - 2;

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j + i < n; j += step) {
                sb.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + step - i < n) {
                    sb.append(s.charAt(j + step - i));
                }
            }
        }

        return sb.toString();
    }
}
