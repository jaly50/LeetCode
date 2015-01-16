/**
 * LeetCode 4 Reverse Integer 
 * @author Scarlett
 * @date 2014/8/31
 * Requirement:Reverse digits of an integer.
 */

public class Reverse {
	 public static int reverse(int x) {
		 int y = 0;
		 while (x!=0) {
			 y += x % 10;
			 x =x / 10;
			if (x!=0) 
				y = y * 10;
	    }
		 return y;
	 }
	 public static void main(String args[]) {
		 int x= 1000000003;
		 System.out.println(reverse(x));
	 }
	
}
