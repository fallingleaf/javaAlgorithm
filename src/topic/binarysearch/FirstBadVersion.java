package binarysearch;


// Has function to check isBadVersion find first bad version
// Use binary search to check bad version
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int m = i + (j-i) / 2;
            if (isBadVersion(m)) {
                j = m;
            } else {
                i = m+1;
            }
        }

        if (isBadVersion(i)) {
            return i;
        }

        return j;
    }
}
