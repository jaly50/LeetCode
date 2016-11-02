/**
 * Reference: true
 * date: 09/20/2016
 * 273. Integer to English Words
 * thoughts: split by 3 digits(int->String); give the title from right to left, t=O(n) s=o(n)
 * 要学会化繁为简，Get used to using recursive and existing method to get your answer
 */
package leetcode;

public class NumberToWords {
    static final String[] title = new String[]{" Billion", " Million", " Thousand", ""};
    static final String[] basic = new String[]{" Zero", " One", " Two", " Three", " Four", 
    										   " Five", " Six", " Seven", " Eight", " Nine",
    										   " Ten", " Eleven", " Twelve", " Thirteen", 
    										   " Fourteen", " Fifteen", " Sixteen", " Seventeen", 
    										   " Eighteen", " Nineteen", " Twenty"};
    static final String[] tens = new String[] {"", " Ten", " Twenty", " Thirty", " Forty", 
    										   " Fifty", " Sixty", " Seventy", " Eighty", 
    										   " Ninety"};
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        String words = "";
        int digit = 3;
        while (num >0) {
            if (num %1000 !=0) {
                words =help(num % 1000) + title[digit] + words;
            }
            num = num / 1000;
            digit -=1;
        }
        return words.trim();
    }
    public String help(int num){
        if (num==0) return "";
        if (num <= 20) return basic[num];
        if (num < 100) return tens[num / 10] + help(num % 10);
        return basic[num/100] + " Hundred" + help(num % 100);
    }
	// Stupid code 09/20/2016
//	 public String numberToWords(int num) {
//	     String sn = Integer.toString(num);
//	     String[] sns = new String[4];
//	     for (int i=sn.length()-3, j=3; i>=0 && j>=0; i-=3, j--) {
//	         sns[j] = sn.substring(i, i+3);
//	     }
//	     for (int i=0; i<4; i++) {
//	         if (sns[i]=="") continue;
//	         //remove the first zero
//	         StringBuilder value = new StringBuilder(sns[i]);
//	         while (value.length()>0  && value[0]=='0') value=value.substring(1);
//	         if (value.length==0) continue;
//	         String name = "";
//	         // Deal with hundreds
//	         if (value.length ==3) {
//	             name = basic[value[0].toInt] + "Hundred";
//	             value = value.substring(1);
//	         } 
//	         if (value.length ==2) {
//	             num_v = value.toInt;
//	             if (num_v <=20) {
//	                 name= name + " "+ basic[num_v];
//	                 continue;
//	             }
//	             else {
//	                 name = name + " "+ tens[num_v/10];
//	             }
//	         }
//	         
//	     }
//	     
//	     
//	 }

}
