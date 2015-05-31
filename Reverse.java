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
	 /*  Think about overflow problem.  5/28/2015*/
	     public  static int reverse(int x) {
        int result = 0, current =0;
        while (x!=0) {
            int tail = x % 10;
            current = result *10 +tail;
            System.out.println(current+" <- current, tail: "+tail+" x:"+x);
            if ((current -tail )/10 != result) {
                return 0;
            }
            result = current;
            x = x/10;
        }
        return result;
        
    }
	 public static void main(String args[]) {
		 int x= 1000000003;
		 System.out.println(reverse(x));
	 }
	
}
