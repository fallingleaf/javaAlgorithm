package google;
import java.util.*;


class BinaryIndexTree {
    int[] bit;

    public BinaryIndexTree(int n) {
        bit = new int[n+1];
    }

    // Populate change to child nodes
    public void update(int index, int val) {
        index += 1;

        while(index < bit.length) {
            bit[index] += val;
            index += index & -index;
        }
    }

    // Get value up to parent nodes
    public int query(int index) {
        int ans = 0;
        index += 1;

        while(index > 0) {
            ans += bit[index];
            index -= index & -index;
        }

        return ans;
    }

    public static BinaryIndexTree construct(int[] arr) {
        BinaryIndexTree bit = new BinaryIndexTree(arr.length);
        for(int i = 0; i < arr.length; i++) {
            bit.update(i, arr[i]);
        }
        
        return bit;
    }
}
