/*
 * Leetcode 18
 * @author Scarlett
 * @date 2014/9/9
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
public static int singleNumber(int[] A) {
	 int[] count = new int[32];
	 for (int i=0; i<A.length; i++) {
		 for (int j=0; j<count.length; j++) { 
			count[j] += (A[i]>>j) & 1;
		}
	 }
	 int ans = 0;
	 for (int i=0; i<count.length; i++) {
		 count[i] %= 3;
		 ans |=(count[i]<<i);
	 }
        return ans;
    }
//o(n) without extra space
public static int singleNumber2(int[] A) {
	int one=0, two =0,three=0;
	for (int i=0; i<A.length; i++) {
       two |=one & A[i];
	   one  ^= A[i];
	   three = one & two;
	   one &= ~three;
	   two &= ~ three;
	}
	return one;
}
public static void main(String args[]) {
	/*
	System.out.println(1<<31);
	System.out.println(Integer.MAX_VALUE);
	int a,b;
	a = 78;
	b = 35;
	a ^=b;
	b ^= a;
	a ^=b;
	System.out.println(a+" "+b);
	System.out.println(a^b);
	int x = a^b;
	System.out.println(10&7);

	 for (int i=0; i<32; i++) {
		 System.out.print((-5>>i)&1); 
	 }
	 System.out.println();
	 	*/
	System.out.println(singleNumber2(new int[]{-2,3,3,3,-2,-45,-2})) ;
	
	
}
}
