package math;
import java.util.*;


// https://leetcode.com/problems/excel-sheet-column-number/
// Excel sheet contains 'A' -> 1, 'B' -> 2... 'Z' -> 26, 'AA' -> 27
// Convert title to number and revert
public class ExcelSheet {
    public int titleToNumber(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            ans = ans * 26 + s.charAt(i) - 'A' + 1;
        }
        return ans;
    }

    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n --;
            char c = (char) (n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.toString();
    }
}
