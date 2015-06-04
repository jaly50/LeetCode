import java.util.Arrays;
/*
 * Scarlett Chen
 * 6/3/2015
 * LeetCode shortest Palindrome
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * 思路： reverse the string; 最后几个字母和要 s的前几个字母一样。这样才能删掉一半。
 * 于是就拼s+p, 用kmp对应前一个 从0开始至今一样的位置〜
 */
public class Solution_shortestPalindrome {
    public String shortestPalindrome(String s) {
        String p = new StringBuilder(s).reverse().toString();
        String ps = new String(s+p);
        int[] pt = new int[ps.length()];
        if (s.isEmpty()) return s;
        pt[0]=-1;
        //System.out.println(ps);
        for (int i=1; i< ps.length(); i++) {
            char c = ps.charAt(i);
            int j = pt[i-1];
            while (j>=0 && c!=ps.charAt(j+1)) {
                j = pt[j];
            }
            if (c==ps.charAt(j+1)) {
                pt[i] = j+1;
            }
            else
             pt[i] = -1;
        }
        // pt[]要＋1,因为pt存的是index.我们要删的是个数
        int pos = s.length() - Math.max(pt[ps.length()-1]+1,0);
        //System.out.println(Arrays.toString(pt));
        return p.substring(0,pos)+s;
        
    }
    public static void main(String[] args) {
        Solution_shortestPalindrome s = new Solution_shortestPalindrome();
        System.out.println(s.shortestPalindrome("aacecaaa"));
    }
}
