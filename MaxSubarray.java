/*
 * leetcode 18
 * author: scarlett
 * date:2014/9/10
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

/*
  o(n) answer:
  public class Solution {
    public static int maxSubArray(int[] A) {
        int sum=Integer.MIN_VALUE, cur =Integer.MIN_VALUE;
        for(int i:A) {
            if (cur <0) cur = i;
            else cur +=i;
            if (sum < cur)
             sum =cur;
            
        }
      return sum;
    }
}
 */
public class MaxSubarray {
	 public static int maxSubArray(int[] A) {
		 if (A.length <1) return 0;
		 int ans = cal(A,0,A.length-1);
		 //分而治之：左串，右串，还是中间向两边的中间串？
		return ans;
        
	    }
	 private static int  cal(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		 int ans =Integer.MIN_VALUE;
		 for (int i=low; i<=high; i++) {
			 ans = max(cal(a,low,i), cal(a,i,high));
		 }
		return 4;
	}
	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return a>b?a:b;
	}
	public static void main(String args[]) {
		 System.out.println(maxSubArray(new int[]{4,-1,2,1})) ;
	 }
}




//cur means the array after max ends. 
/*
 * A failed method 
int  cur =A[0], max = A[0];
for (int i=1;i<A.length; i++) {
 // all negative situation
	if (max <0) {
		max = max(max,A[i]);
	}
	else if (max >=0) {
		// if  ith is negative, it keeps in cur temporary
		if (A[i]<0) {
			cur +=A[i];
		}
}
	
}
return max;   
*/ 
