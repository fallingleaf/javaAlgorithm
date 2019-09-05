package bfs;
import java.util.*;


// Facebook
// Give a string with parentheses, remove invalid parentheses
// String may contains other char
// Count number of open and close char, if close > open, then remove random none 2 continuous
// append to queue, after that reverse string and do the same
public class RemoveInvalidParentheses {
    private List<StringBuilder> remove(StringBuilder s, char open, char close) {
        List<StringBuilder> queue = new ArrayList<>();

        queue.add(s);

        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == open) {
                count ++;
            }

            if(s.charAt(i) == close) {
                count --;
            }

            if(count < 0) {
                List<StringBuilder> newQueue = new ArrayList<>();
                for(StringBuilder sb: queue) {
                    for(int j = 0; j <= i; j ++) {
                        if(sb.charAt(j) == close && (j == 0 || sb.charAt(j) != sb.charAt(j-1))) {
                            StringBuilder cloneSb = new StringBuilder(sb.toString());
                            cloneSb.setCharAt(j, ' ');
                            newQueue.add(cloneSb);
                        }
                    }
                }
                count = 0;
                queue = newQueue;
            }
        }

        List<StringBuilder> list = new ArrayList<>();

        if(count > 0 && open == '(') {
            for(StringBuilder processed: queue) {
                List<StringBuilder> res = remove(processed.reverse(), ')', '(');
                for(StringBuilder r: res) {
                    list.add(r.reverse());
                }
            }
        } else {
            list = queue;
        }

        return list;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<StringBuilder> res = remove(new StringBuilder(s), '(', ')');
        Set<String> ans = new HashSet<>();

        for(StringBuilder sb: res) {
            ans.add(sb.toString().replaceAll(" ", ""));
        }
        return new ArrayList<String>(ans);
    }
}
