import java.util.Arrays;

/*
 * LeetCode 43 Longest Substring Without Repeating Characters 
 * date: 2014/9/28
 * Given a string, find the length of the longest substring without repeating characters. 
 */
public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
        int[] st = new int[256];
        Arrays.fill(st, -1);
        if (s.length() <=1) return s.length();
        int len= 0,max =1;
        for (int i =0; i< s.length(); i++) {
          if (st[s.charAt(i)] >= 0) {
        	  len = Math.min(len+1, i-st[s.charAt(i)]);
            }
          else {
        	  len++;
        	  
          }
          st[s.charAt(i)] = i;
          max = Math.max(max, len);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(lengthOfLongestSubstring("abcbca"));
      System.out.println(lengthOfLongestSubstring("abcbcabadfeadbdfeab"));
	}

}
