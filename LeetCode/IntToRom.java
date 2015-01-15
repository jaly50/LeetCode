/*
 * leetcode 20
 * date 2014/9/10
 * author scarlett
 * Given an integer, convert it to a roman numeral.
 * [Using switch would be better]
 */
public class IntToRom {
	 public static String intToRoman(int num) {
		 String ans="";
		 while (num >= 1000) {
			 ans +='M';
			 num -=1000; 
		 }
		 if (num >=900) {
			 ans +="CM";
			 num -=900;
		 } else 
		 if (num >= 500) {
			 ans +="D";
			 num -= 500;
			 
		 } else 
		 if (num >=400) {
			 ans +="CD";
			 num -=400;
		 } 
		 while (num >= 100) {
			 ans +='C';
			 num -=100; 
		 }
		 if (num >=90) {
			 ans +="XC";
			 num -=90;
		 } else 
		 if (num >= 50) {
			 ans +="L";
			 num -= 50;
			 
		 } else 
		 if (num >=40) {
			 ans +="XL";
			 num -=40;
		 }
		 while (num >= 10) {
			 ans +='X';
			 num -=10; 
		 }
		 if (num >=9) {
			 ans +="IX";
			 num -=9;
		 } else 
		 if (num >= 5) {
			 ans +="V";
			 num -= 5;
			 
		 } else 
		 if (num >=4) {
			 ans +="IV";
			 num -=4;
		 }
		 while (num >= 1) {
		 ans +='I';
			 num -=1; 
		 }
		 
	        return ans;
	    }
	 public static void main(String args[]) {
			System.out.println(intToRoman(0));
			System.out.println("I = " + intToRoman(1));
			System.out.println("VIII = " + intToRoman(8));
			System.out.println("65 = LXV " + intToRoman(65));
			System.out.println("999 =CMXCIX " + intToRoman(999));
			System.out.println("1976 =MCMLXXVI  " + intToRoman(1976));
		System.out.println("2420 =MMCDXX " + intToRoman(2420));
		}
}
