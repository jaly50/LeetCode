/*
2015.03.03
Scarlett chen
bitwise+ hashset
repeated DNA Sequences

*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> list = new ArrayList<String>();
        Set<Integer> set = new HashSet<Integer>();
        int t=0;
        for (int i=0; i<s.length(); i++) {
            t= (t<<3 & 0x3FFFFFFF) | (s.charAt(i) & 7);
            String sub = s.substring(Math.max(i-9,0),i+1);
            if (set.contains(t)) {
            if (!list.contains(sub))
            list.add(sub);
            }
            else set.add(t);
            
        }
        return list;
        
    }
}