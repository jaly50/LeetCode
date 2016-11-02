
public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
//”√dp
      int[][] dp = new int[n+2][n+2];
      for (int len=1; len < n; len++) {
          for (int from=1; from + len<=n; from++) {
              int to = from + len;
              dp[from][to] = Integer.MAX_VALUE;
              for (int k=from; k<=to; k++) {
                  dp[from][to] = Math.min(dp[from][to], k + dp[from][k-1] + dp[k+1][to]);
              }
          }
      }
        return dp[1][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
