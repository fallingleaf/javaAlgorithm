package array;
import java.util.*;


// Google
// https://leetcode.com/problems/image-overlap/solution/
// Give 2 images (by matrix), return max possible bit 1 if move up, down, left,
// right chosen image that overlap with second image
// Find all bit 1 in image, tranverse x, y from -n to +n and count max bit 1
// exist in second image
class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int row = B.length;
        int col = B[0].length;
        HashSet<String> bitOnes = new HashSet<> ();
        ArrayList<Integer[]> abits = new ArrayList<> ();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(A[i][j] == 1) {
                    abits.add(new Integer[] {i, j});
                }

                if(B[i][j] == 1) {
                    bitOnes.add(i + "," + j);
                }
            }
        }

        int ans = 0;
        int count = 0;
        int x, y;

        for(int i = -row + 1; i < row; i++) {
            for(int j = -col + 1; j < col; j++) {
                count = 0;
                for(Integer[] point: abits) {
                    x = point[0] + i;
                    y = point[1] + j;
                    if(bitOnes.contains(x + "," + y)) {
                        count += 1;
                    }
                }
                ans = Math.max(ans, count);
            }

        }

        return ans;

    }
}
