public class Solution {
    public boolean isIsomorphic(String s, String t) {
    // if s[i] and t[i] are pair, they will point to one index
        int[] sArray = new int[256];
        int[]tArray = new int[256];
        // intialization
        Arrays.fill(sArray,-1);
        Arrays.fill(tArray,-1);
        if (s.length() !=t.length()) 
        return false;
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // The character has never visited
            if (sArray[c1] == -1 && tArray[c2]==-1) {
                sArray[c1] = i;
                tArray[c2] = i;
            }
            else if (sArray[c1]!=tArray[c2])
            return false;
        
        }
        return true;
        
    }
}
