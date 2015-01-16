/*
 * LeetCode 135
 * Author: Scarlett Chen
 * Thought: DP
 * I did it myself, though I used a lot of time to think the equation of dynamic programming
 * Be careful for the edge situation.
 */
public class DistinctSubsequence {
	 public int numDistinct(String S, String T) {
	        int lens = S.length();
	        int lent = T.length();
	        if (lent > lens) return 0;
	        if (lent==lens) {
	            if (T.equals(S)) return 1;
	            else return 0;
	        }
	        if (lent==0) return 1;
	        int[][] f = new int[lens][lent];
	        for (int i=0; i<lens; i++) {
	            f[i][0] = S.charAt(i)==T.charAt(0)?1:0;
	            // What I missed at first
	            if (i>0) {
	                f[i][0] +=f[i-1][0];
	            }
	        }
	        for (int i=1; i<lens; i++) {
	            for (int j=1; j<=i&& j<lent; j++) {
	               char s = S.charAt(i);
	               char t = T.charAt(j);
	               // The equation of DP
	               if (s==t) f[i][j] = f[i-1][j-1] + f[i-1][j];
	               else f[i][j] =f[i-1][j];
	            }
	        }
	       return f[lens-1][lent-1]; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2147483645; 
		boolean answer = false;
		int p = 1;
		while (p <= x) {
		System.out.println("Testing " + p); 
		if (x/p==p) {
			answer = true;
			break;
		}
		else if (x/p>p) {
			p = p*2;
		}
		else if (x/p<p) {
			answer = false;
			break;
		}
		//if (p == x) answer = true;
		//p = p * 2;
		}
		System.out.println("Answer is: "+answer); 

	}

}
