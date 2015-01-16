/*
 * LeetCode 45 Longest Palindromic Substring 
 * 主要的方法是自己想出来的。但是没有优化导致时间复杂度变成 o(n^3)
 * 优化方法：不用记录字串，只需要记录子串的起始位置。
 * 最后时间复杂度：o(n^2)
 * o（n）方法的参考文献：http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 * date:2014/9/29
 */
import java.util.Arrays;


public class LongestPalindrome {
	 static int maxlen;
     static String maxS;
 	 static int  begin;
 	 
 	 // 把所有的回文都变成奇数格式
 	public static String longestPalindrome2(String s) { 
 		if (s.length() <=1) return s;
 		StringBuilder st = new StringBuilder("#");
 		for (int i =0; i<s.length(); i++) {
 			st.append(st.charAt(i)+"#");
 		}
 		int i = 0;
 		while (i < st.length()) {
 			if ((i >1) && (st.charAt(i) == st.charAt(i-2))) 
        		explore1(st,i-2,i);
        	i++;
 		}
 		 return s.substring(begin/2, (maxlen+begin)/2); 
 		
 	}
 	 private static void explore1(StringBuilder st, int left, int i) {
		// TODO Auto-generated method stub
		explore1(st.toString(),left,i);
	}
	// O(2n *n)
	public static String longestPalindrome1(String s) {
        if (s.length() <=1) return s;
        int i = 0;
        maxlen =1;
        begin = 0;
        while (i< s.length()) { 
        	if ((i>=1) && (s.charAt(i) == s.charAt(i-1)))
        		explore1(s,i-1,i);
        	if ((i >1) && (s.charAt(i) == s.charAt(i-2))) 
        		explore1(s,i-2,i);
        	i++;
        }   
            return s.substring(begin, maxlen+begin); 
        }
       
	private static void explore1(String s, int left, int right) {
		// TODO Auto-generated method stub
		  while ((left > 0) && (right < s.length()-1) 
       		   && (s.charAt(right +1 ) == s.charAt(left -1)))
			   { right +=1; left -=1;};
       	  if (right - left +1  > maxlen) {
       	      maxlen = right - left +1;
       	      begin = left;
       	  } 
	}
	public static String longestPalindrome(String s) {
        if (s.length() <=1) return s;
        int i = 0;
        String temp;
        int left,right;
        maxlen =1;
        maxS = s;
        while (i< s.length()) { 
        	if ((i>=1) && (s.charAt(i) == s.charAt(i-1)))
        		explore(s,i-1,i);
        	if ((i >1) && (s.charAt(i) == s.charAt(i-2))) 
        		explore(s,i-2,i);
        	i++;
        }   
            return maxS; 
        }
       
	private static void explore(String s, int left, int right) {
		// TODO Auto-generated method stub
		 String temp = s.substring(left,right+1);
		  while ((left > 0) && (right < s.length()-1) 
       		   && (s.charAt(right +1) == s.charAt(left-1))) {
            temp = s.charAt(--left) + temp + s.charAt(++right);
          }
         if (temp.length() > maxlen) {
               maxS = temp;
               maxlen = temp.length();
            }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s = longestPalindrome2("abcba");
      System.out.println(s);
	}

}
