/*
 * Leetcode 15
 * @date 2014/9/8 -complete at 2014/9/9 11:29
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
	public static int romanToInt(String s) {
		int ans=0;
         if (s.length()< 1) return 0;
         while (s.length()>0) {
        	 switch (s.charAt(0)) {
        	 case 'M':
        		 ans += 1000;
        		 s = s.substring(1);
        		 break;
        	 case 'D':
        		 ans += 500;
        		 s = s.substring(1);
        		 break;
        	 case 'C':
        			 if ((s.length()>1)&&(s.charAt(1)=='D')) {
        				 ans += 400;
        				 s = s.substring(2);
        			 }
        			 else if ((s.length()>1)&&(s.charAt(1)=='M')) {
        				 ans += 900;
        				 s = s.substring(2);
        			 }
        			 else {
                		 ans += 100;
                		 s = s.substring(1);
        			 }


        		 break;
        	 case 'L':
        		 ans += 50;
        		 s = s.substring(1);
        		 break;
           	 case 'X':
        			 if ((s.length()>1)&&(s.charAt(1)=='L')) {
        				 ans += 40;
        				 s = s.substring(2);
        			 }
        			 else if ((s.length()>1)&&(s.charAt(1)=='C')) {
        				 ans += 90;
        				 s = s.substring(2);
        			 }
    				 
        		 else {
        			 ans += 10;
        			 s = s.substring(1);
           		 	}
           		 break;
           	 case 'V':
           		 ans += 5;
           		 s = s.substring(1);
           		 break;
        	 case 'I': {
        			 if ((s.length()>1)&&(s.charAt(1)=='V')) {
        				 ans += 4;
        				 s = s.substring(2);
        			 }
        			 else if ((s.length()>1)&& (s.charAt(1)=='X')) {
        				 ans += 9;
        				 s = s.substring(2);
        			 }
        			 else {
        		  ans += 1;
        		 s = s.substring(1);}
        		 break;
        	 }
        	 default: 
        		 s = s.substring(1);
        		 break;
        	 
        	 }
         }
         return ans;
         
	}
	public static void main(String args[]) {
		System.out.println(romanToInt(""));
		System.out.println("1 = " + romanToInt("I"));
		System.out.println("8 = " + romanToInt("VIII"));
		System.out.println("65 = " + romanToInt("LXV"));
		System.out.println("999 = " + romanToInt("CMXCIX"));
		System.out.println("1976 = " + romanToInt("MCMLXXVI"));
		System.out.println("2420 = " + romanToInt("MMCDXX"));
	}

}
