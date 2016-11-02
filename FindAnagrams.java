package LeetCode;
/*
 * Scarlett Chen
 * Tue 8:27 PM
 *  11/1/2016 
 *  438. Find All Anagrams in a String  
 *  最naive的方法： 对于s的每一个char,选取P的长度，排序，看是否与sorted(p)一样， 时间复杂度： len(s)*len(p)log len(p)
 *  2.建 一个int[] 的字母表，从s开始，如果char在字母表里，就减， 并记录长度； 否则，把字母表复原； 时间复杂度 len(s), 空间 int[26]
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int len1 = s.length();
        int len2 = p.length();
        if (len1 < len2)  return res;
        // create the alphabet table
        //Strings consists of lowercase English letters only
        int[] chs = new int[26];
        for (int i=0; i <len2; i++) {
            chs[p.charAt(i) - 'a'] +=1;
        }
        int[] match = new int[26];
        int count = 0;
        for (int i=0; i<len1; i++) {
            int pos = s.charAt(i)-'a';
            if (chs[pos] == 0 ) {
                match = new int[26];
                count = 0;
            }
            else {
                match[pos] ++;
                count++;
                while (match[pos] > chs[pos] && count>0) {
                    match[s.charAt(i-count+1)-'a']--;
                    count--;
                }
                
            }
            if (count == len2) {
                res.add(i-count+1);
            }
            
            
            
        }
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
