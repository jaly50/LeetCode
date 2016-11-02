//Scarlett Chen 8/1/2015 Sat 9:14
public class Solution {
    // HashMap time:o(n) space:o(n) ==> using array as hashmap
     public boolean isAnagram(String s, String t) {   
        int slen= s.length();
        int tlen= t.length();
        if (slen!=tlen) return false;
        // string only contains lowercase alphabets
        int[] freq= new int[26];
        Arrays.fill(freq, 0);
        for (int i=0; i<slen; i++) {
            int index = s.charAt(i)-'a';
            freq[index]++;
        }
        for (int i=0; i<tlen; i++) {
           int index = t.charAt(i)-'a'; 
           freq[index]--;
           if (freq[index]<0) return false;
        }
        return true;
         
         
         
     }
  //  sort: n=s.length(); time complexity: nlogn
    public boolean isAnagram(String s, String t) {
        int slen= s.length();
        int tlen= t.length();
        if (slen!=tlen) return false;
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        for (int i=0; i<slen; i++) {
            if (sch[i]!=tch[i]) return false;
        }
        return true;
        
    }
}
