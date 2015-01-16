import java.util.Arrays;
/*
 * LeetCode 152 Interleaving String 
 * DP o(n^2)
 * @author: Scarlett.chen
 * @date:12/24/2014 Wed 12:50 PM
 * 注意边界值，len1==0等情况
 * 以及f[i][j]表示s1的前i个和s2的前j个，是不是能构成s3的前i+j个
 */

public class InterLeaving {
	 public boolean isInterleave(String s1, String s2, String s3) {
		 int len1 = s1.length();
		 int len2 = s2.length();
		 int len3 = s3.length();
		 if (len3!=len2+len1) return false;
		 if (len1==0) return s2.equals(s3);
		 if (len2 == 0) return s1.equals(s3);
		 boolean[][] f = new boolean[len1+1][len2+1];
		 
		 for (int i=0; i<=len1; i++) Arrays.fill(f[i], false);
		 f[0][0] = true;
		 for (int i=0; i<=len1; i++) {
			 for (int j=0; j<=len2; j++) {
				 if (i>0 && s1.charAt(i-1) == s3.charAt(i-1+j)) {
					 f[i][j] = f[i-1][j] ||f[i][j]; 
				 }
				 if (j>0 && s2.charAt(j-1) == s3.charAt(i+j-1)) {
					 f[i][j] = f[i][j-1] ||f[i][j];
				 }
				 
			 }
		 }
		 
         return f[len1][len2];
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterLeaving il = new InterLeaving();
		System.out.println(il.isInterleave("ab", "aa", "abaa"));
	}

}
