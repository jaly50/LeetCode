public class StringtoInteger {
	public static int atoi(String str) {
	    if (str.length() == 0) return 0;   
		int answer = 0;
		int i =0;
		boolean positive = true;
		while (str.charAt(0) == ' ')  str=str.substring(1);
		if (str.charAt(0)=='-') {
			positive = false;
			str=str.substring(1);
		}
		else if (str.charAt(0)=='+') {
			positive = true;
			str=str.substring(1);
		}
		 if ((str.charAt(0)<'0') || (str.charAt(0)>'9')) 	return 0;
		 else {
			 while ((str.length()>0) && (str.charAt(0)>='0') && (str.charAt(0)<='9')) {
				 if ((answer>>28 >0)||(answer > answer*10+str.charAt(0)-'0'))  {
					 if (positive) return Integer.MAX_VALUE;
					 else return Integer.MIN_VALUE;
				 }
				 else
					 answer = answer *10 + str.charAt(0)-'0';
				 str= str.substring(1);
			 }
		 }	 
	       if (!positive) return -answer; 
	       else return answer;
	    }
	
	public static void main(String args[]) {
		System.out.println(atoi("    30522545459"));
		System.out.println(atoi("-2147483648"));
		System.out.println(2<<28);
	}
}
