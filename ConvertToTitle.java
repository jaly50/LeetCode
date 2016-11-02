/*
 * Leetcode 158
 * @author: Scarlett Chen
 * @date: 12/28/2014 Sun 10:19 AM
 * Time(n)  easy
 * 一开始的想法就是 换进制，换成26进制数嘛。
 * 但是需要注意的是，这里的数从1-26.和之前从0-n-1是不一样的~ 所以我们手动把数转成n-1
 */
public class ConvertToTitle {
	public static String convertToTitle(int n) {
        StringBuffer s = new StringBuffer();
        char[] tablet = new char[26];
        for (int i=0; i<tablet.length; i++) 
          tablet[i]=(char) ('A'+i);
        int carry=0;
        while (n>0) {
            carry = (n-1) % 26;
            n = (n-1)/ 26;
            s.insert(0,tablet[carry]);
        }
      return s.toString();   
    }
	/*
	 * Leetcode 159 Excel Sheet Column Number 
	 * 比上一题更简单 确实是转进制问题
	 * 就是要+1
	 * @date: 12/28/2014 Sun 1:22 PM
	 */
	public static int titleToNumber(String s) {
		int len = s.length();
		int number = 0;
		for (int i=len-1; i>=0; i--) {
			number +=(s.charAt(i)-'A'+1)*Math.pow(26, len-1-i);
		}
	    return number;
		
	}
	public static void main(String args[]) {
		System.out.println(convertToTitle(324)+"-->"+titleToNumber("LL"));
	}
}
