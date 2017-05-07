/*
Scarlett Chen
LeetCode Weekly Contest 31
576. Out of Boundary Paths My SubmissionsBack To Contest
There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.

Example 1:
Input:m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6
Explanation:

Example 2:
Input:m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12
Explanation:

Note:
Once you move the ball out of boundary, you cannot move it back.
The length and height of the grid is in range [1,50].
N is in range [0,50].


*/
public class Solution {
    int base = (int)(Math.pow(10,9)) + 7;
    public int findPaths(int m, int n, int N, int x, int y) {
        if (N<=0 || x<0 || x>=m || y<0 || y>=n) return 0;
        int[][][] dp = new int[m][n][N];
        dp[x][y][0] = 1;
        int sum = 0;
        for (int i=0; i<N; i++) {
            if (i>0)
            for (int j=0; j<m; j++) {
                for (int k=0; k<n; k++) {
                    if (dp[j][k][i-1] > 0) {
                        if (j>0) dp[j-1][k][i] = (dp[j-1][k][i] + dp[j][k][i-1]) % base;
                        if (k<n-1) dp[j][k+1][i] = (dp[j][k][i-1] + dp[j][k+1][i]) % base;
                        if (j<m-1) dp[j+1][k][i] = (dp[j][k][i-1] + dp[j+1][k][i]) % base;
                        if (k>0) dp[j][k-1][i] = (dp[j][k][i-1] + dp[j][k-1][i]) % base;
                    }
                }
                
            }
            for (int j=0; j<m; j++){
                sum = (sum + dp[j][0][i]) % base;
                sum = (sum + dp[j][n-1][i]) % base;
            }
            for (int k=0; k<n; k++) {
                sum = (sum  + dp[0][k][i]) % base;
                sum = (sum + dp[m-1][k][i]) % base;
            }
        }
        return sum;
    }

}
