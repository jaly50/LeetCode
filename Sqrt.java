/*
 * LeetCode 132
 * Author: Scarlett
 * thought: binary and bit operation
 */
public class Sqrt {
	 public int sqrt_Binary(int x) {
	        int low=0, high=x, mid=low;
	        int ans = mid;
	        if (0 == x) return 0;
	        if(x == 1) return 1;
	        while (low <=high) {
	            mid = low + (high-low)/2;
	            if (mid ==0) return 0;
	            if (mid!=0 && x/mid>=mid) {
	                low = mid +1;
	                ans = mid;
	            }
	            else if (mid!=0 && x/mid <mid) {
	                high = mid-1;

	            }
	        }
	     return ans;   
	    }
	 public int sqrt(int x) {
		 long bit = 1l<<16;
		 int ans = 0;
		  while (bit>0) {
			  ans |=bit;
			  if (x / ans < ans)  {
				  ans ^=bit;
			  }
			  bit >>=1;
		  }
		 return ans;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Sqrt s =new Sqrt();
     System.out.println(Math.sqrt(Integer.MAX_VALUE));
     System.out.println(s.sqrt(2100032132));
     System.out.println(s.sqrt(1));
     System.out.println(s.sqrt(28));
	}

}
