import java.math.BigInteger;



/*
 * Cheating version
 * public String multiply(String num1, String num2) {
    java.math.BigInteger b1 = new java.math.BigInteger(num1);
    java.math.BigInteger b2 = new java.math.BigInteger(num2);
    return b1.multiply(b2).toString();
}
 * 
 */
public class Multiply_v1_failed {
	public String multiply(String num1, String num2) {
		BigInteger b1 = new BigInteger(num1);
		java.math.BigInteger b2 = new java.math.BigInteger(num2);
		b1.multiply(b2);
	  int len1 = num1.length();
	  int len2 = num2.length();
	  if (len1<10 && len2<10) {
		  long x = Long.parseLong(num1);
	      long y =Long.parseLong(num2);
	      long ans = x*y;
	      return String.valueOf(ans);  
	  }
	  // Make the longer number at the top
	  if (len1<len2) {
		  String temp = num2;
		  num2 = num1;
		  num1 = temp;
		  len1 = num1.length();
		  len2 = num2.length();
	  }
	 // calculate
	  int x,y,ans;
	  int p=0;
	  StringBuffer total=new StringBuffer();
		for (int j=len2-1; j>=0; j--) {
			y = Integer.parseInt(num2.substring(j, j+1));
			for (int i=len1-1; i>=0; i--) {
				String part = num1.substring(i, i+1);
				x = Integer.parseInt(part);
				ans = x * y+p;
		       String ansStr = String.valueOf(ans);
		       if (ansStr.length()> part.length()) {
		    	  p = Integer.parseInt(ansStr.substring(0,1));
		    	  ansStr = ansStr.substring(1);
		       }
		       else p = 0;
		      total.insert(0, ansStr);
		}
			if (p!=0) total.insert(0, p);
			StringBuffer cur=new StringBuffer();
			add(cur,total,len2-j-1);
	  }
     return total.toString();
    }
	// cur is one digit left than total
	private void add(StringBuffer cur, StringBuffer total, int i) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println(Long.MAX_VALUE);
    Multiply_v1_failed m = new Multiply_v1_failed();
    long x,y;
    x = 987654321;
    y= 23515;
    System.out.println( m.multiply("987654321", "23515")+"  =  "+(long)(x*y));
    x = (long)333733321*10;
    y = 9;
    System.out.println( m.multiply("3337333210", "99")+"  =  "+(long)(x*y));
	}

}


