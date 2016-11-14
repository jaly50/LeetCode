// Sun 7:48 PM Nov 13, 2016, 395
public class Solution {
    //先拿到一个总的字母表，再遍历整个string,遇到a时，count[a]--,同时indi[a]++, if count[x] + indi[x] < k
    //  那么indi清零，从x+1开始再算...这个做法不行， 有些count>k but in the part, indi[] < k
    // using divide and conquer, complete it in nlog(n)
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (k > n) return 0;
        return helper(s, 0, n, k);
    }
    public int helper(String s, int start, int end, int k) {
        int n = end -start;
        if (k > n) return 0;
        int[] count = new int[26];
        for (int i=start; i<end; i++) count[s.charAt(i)-'a']++;
        for (int i=0; i<26; i++) {
            if (count[i]==0) continue;
            if (count[i] < k) {
                for (int j=start; j<end; j++) 
                    if (s.charAt(j)-'a' == i) {
                          int left = helper(s, start, j, k);
                          int right = helper(s, j+1, end, k);
                          return Math.max(left, right);
                    }
            }
        }
        return end-start;
    }
}
