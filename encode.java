public class Solution {
//471. Encode String with Shortest Length
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int dis=0; dis<n; dis++) { // The shortest shrink distance is 3
            for (int i=0, j=i+dis; j<n; i++, j++) { // there are 3 elements in 0-2
                String sub = s.substring(i,j+1);
                
                if (j-i <=2) {
                    dp[i][j] = sub;
                    continue;
                }
                // Try to get pattern from s[i:j]
                String pattern = kmp(sub);
                //System.out.println("sub: "+ sub +"  pattern: "+pattern);
                if (pattern.length()>0 && sub.length() % pattern.length() == 0 && sub.length() > pattern.length()+3) {
                   // Don't forget to get current result from a divided result we got before
                    dp[i][j] = sub.length()/pattern.length() + "[" + dp[i][i+pattern.length()-1] + "]";
                }
                else  dp[i][j] = sub;
                
                // Try to shorten it from substirngs
                if (j-i <= 4) continue;
                for (int k=i+1; k<j; k++) {
                    if (dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    private String kmp(String s) {
        int n = s.length();
        int[] p = new int[n];
        int i=1, j = -1;
        p[0] = -1;
        while (i<n) {
            if (s.charAt(i) == s.charAt(j+1)) {
                p[i++] = ++ j;
            }
            else if (j==-1) {
               p[i++] = j;
            }
            else {
                j = p[j];
            }
        }
        return s.substring(p[n-1]+1);
    }
}
