/*
 * Scarlett Chen
 * 10/21/2016 2:38 PM
 * 409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * 思路： 建一个char[26], ele存出现的counts, if count %2==0, ans += count ;
 * easy
 * 别人的做法：还可以使用hashset.
 * 
 */
package leetcode;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // char[] 52
        int[] counts = new int[52];
        for (int i=0; i<s.length(); i++ ) {
            char cur = s.charAt(i);
            // note: ascii[a]=97, ascii[A]=65
            if (cur >= 'a') counts[cur-'a'+26]++;
            else counts[cur-'A']++;
        }
        int ans = 0;
        //在palinder的中间可以再放一个值
        boolean one=false;
        for (int count: counts)  {
        	//如果该字母出现次数为奇数的话，只加它偶数的那些
            if (count %2 ==1) {
                one = true;
                ans +=count-1;
            }
            else ans+=count;
            
        }
        return one? ans+1: ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
