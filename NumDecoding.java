/*
 * Author: Scarlett chen
 * LeetCode: 133 Decode Ways 
 * Thought: DP
 * be careful about the edge value.. when i=0,i=1
 * when the code is '0' or '00'
 * 
 */
public class NumDecoding {
	  public int numDecodings(String s) {
	      int len = s.length();
	      if (len <1) return 0;
	      int[] f = new int[len];
	      if (s.charAt(0)=='0') return 0;
	      for (int i =0; i<len; i++) { 
	          if (s.charAt(i) !='0') {
	              if (i>0) f[i] = f[i-1];
	              else f[i]= 1;
	          }
	          else f[i] = 0;
	          if (i>0) {
	           int twoDigit = Integer.parseInt(s.substring(i-1,i+1));
	          if (twoDigit<=26 && twoDigit>=10) {
	            if (i>=2) f[i] += f[i-2];
	            else if (i==1) {
	                f[i] += 1;
	            }
	          }
	          else if (twoDigit==0) return 0;
	          }
	      }
	      return f[len-1];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
