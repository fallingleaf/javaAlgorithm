package array;


// https://leetcode.com/problems/split-array-with-same-average/
// Check if can split array with same average
// 2 Solutions: observe that if it's exists: total/len = currSum/currLen
// - Recursive: Add num to current sum and count how many number
// Check if it meets above requirement
// - DP: dp[i][j] is boolean at sum i and j elements
// knapsack problems: dp[i][j] = dp[i][j] || dp[i-num][j-1]
public class SplitArraySameAverage {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for(int num : A){
            sum += num;
        }
        boolean[][] dp = new boolean[sum+1][A.length/2 + 1];
        dp[0][0] = true;
        for(int num : A){
            for(int i = sum; i >= num; i--){
                for(int j = 1; j <= A.length/2; j++){
                    dp[i][j] = dp[i][j] || dp[i-num][j - 1];
                }
            }
        }
        for (int i = 1; i <= A.length/2; ++i)
            if (sum*i%A.length == 0 && dp[sum*i/A.length][i]) return true;
        return false;
    }
}

/* Python for first solution
class Solution(object):
    def split(self, visited, arr, totalSum, length, currSum, num, idx):
        if (num != 0 and num != length and
            currSum * (length - num) == (totalSum - currSum) * num):
            return True

        if (currSum, num) in visited:
            return False

        for i in range(idx, length):
            if self.split(visited, arr, totalSum, length,
                          currSum + arr[i], num + 1, i + 1):
                return True
            else:
                visited.add((currSum + arr[i], num + 1))
        return False

    def splitArraySameAverage(self, A):
        if not A:
            return True
        visited = set()
        s, length = sum(A), len(A)
        return self.split(visited, A, s, length, 0, 0, 0)
*/
