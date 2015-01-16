/*
 * LeetCode Jump Game II 
 * 
 * 需要思考，但是实现很容易。一次过~
 * Date:11/25/2014 Tue 10:25 PM
 * 思路：dp
 *    在i的位置上，每次可以跳子距离（0，A[i]) ， 就可以算f[i到i+A[i]]的次数了
 *    f[i+j] = min (f[i+j], f[i]+1)  (j is in [1,A[i]])
 *    再加点优化, if i<j, A[i]>A[j]+distance(i,j), 那么f[j]就不用算
 * 
 */

import java.util.Arrays;


public class Jump {
	public int jump(int[] A) {
        int[] f = new int[A.length];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0]=0;
        int max=0;
      for (int i=0; i<A.length; i++) {
          max = Math.max(A[i],max);
          if (A[i]<max) {
              max = max-1;
              continue;
          }
          for (int j=1; j<=A[i] && i+j<A.length; j++) {
              f[i+j] = Math.min(f[i+j], f[i]+1);
              if (i+j==A.length-1) 
            	  return f[i+j];
          } 
      } 
      return f[A.length-1];
    }
  public static void main(String[] args) {
	  
  }
}
