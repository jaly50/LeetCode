package leetcode;

//thoughts: split by 3 digits(int->String); give the title from right to left, t=O(n) s=o(n)
public class Solution {
    static final String[] title = new String[]{" Billion ", " Million ", " Thousand ", ""};
    static final String[] basic = new String[]{" Zero", " One", " Two", " Three", " Four", 
    										   " Five", " Six", " Seven", " Eight", " Nine",
    										   " Ten", " Eleven", " Twelve", " Thirteen", 
    										   " Fourtean", " Fifteen", " Sixteen", " Seventeen", 
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
        }
        return words.trim();
    }
    public String help(int num){
        if (num==0) return "";
        if (num <= 20) return basic[num];
        if (num < 100) return tens[num / 10] + help(num % 10);
        return basic[num/100] + " Hundred" + help(num % 100);
    }
}