/*
 * LeetCode 115 Multiply Strings 
 * Date: 11/9/2014
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * YOU NEED TO DO IT AGAIN!!!
 * I use int[] to calculate it. There are many other ways to solve the problem.
 */

/*
 * #2 way: BigInteger
 * #3 way:
 * procedurekaratsuba(num1,num2) */
//if(num1<10)or(num2<10)
//returnnum1*num2
///*calculatesthesizeofthenumbers*/
//m=max(size(num1),size(num2))
//m2=m/2
//high1,low1=split_at(num1,m2)
//high2,low2=split_at(num2,m2)
//*3callsmadetonumbersapproximatelyhalfthesize*/
//z0=karatsuba(low1,low2)
//z1=karatsuba((low1+high1),(low2+high2))
//z2=karatsuba(high1,high2)
//return(z2*10^(m))+(（z1-z2-z0）*10^(m/2))+(z0)
 

import java.util.Arrays;


public class Multiply {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		  int len2 = num2.length();
		  if (len1<10 && len2<10) {
			  long x = Long.parseLong(num1);
		      long y =Long.parseLong(num2);
		      long ans = x*y;
		      return String.valueOf(ans);  
		  }
		int[] a = stringToInts(num1);
		int[] b = stringToInts(num2);
		int[] c = new int[num1.length()+num2.length()];
		Arrays.fill(c, 0);
		int xstart = a.length-1;
		int ystart = b.length-1;
		int carry = 0;
		for (int x=xstart; x>=0; x--) {
			carry = 0;
			for (int y=ystart; y>=0; y--) {
				int k = y+x+1;
				int product = a[x]*b[y]+carry+c[k];
				c[k] = product %10;
				carry = product/10;
			}
			c[x] +=carry;
		}
		return intToString(c);
	}
	private String intToString(int[] c) {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer();
		for (int i:c) {
			s.append(i);
		}
		while (s.substring(0, 1).equals("0")) s=s.delete(0,1);
		return s.toString();
	}
	private int[] stringToInts(String num) {
		// TODO Auto-generated method stub
		
		int[] a = new int[num.length()];
		for (int i=0; i<num.length(); i++) {
			a[i]= Integer.parseInt(num.substring(i, i+1));
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiply m = new Multiply();
	    long x,y;
	    x = 987654321;
	    y= 23515;
	    System.out.println( m.multiply("987654321", "23515")+"  =  "+(long)(x*y));
	    x = 33;
	    y = 9;
	    System.out.println( m.multiply("33", "9")+"  =  "+(x*y));
	    x = 999999;
	    y = 999999;
	    System.out.println( m.multiply("999999", "999999")+"  =  "+(long)(x*y));
	    x = 18582506;
	    y = 0;
	    System.out.println( m.multiply("18582506933032752", "366213329703")+"  =  "+(long)(x*y));
	}

}
