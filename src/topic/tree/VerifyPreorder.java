package tree;
import java.util.*;

// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// for each node it has 1 parent, 2 children, 1 in 2 out degree, (except root no parent)
// Track the degree, -1 node in and +2 if not null, at each if degree < 0 return false
public class VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
