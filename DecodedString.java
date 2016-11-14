// 394 Decoded String, sun 6:23 pm 11/13/2016
public class Solution {
    // idx是否在每个情况都加一了，要检查。
    // Check the position of cutting string
    public String decodeString(String s) {
        // if st(idx) is number
         //   st = decodeString(bracket)
        // for [0, idx), ans.applend(st)
    	//System.out.println(s);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isAlphabetic(s.charAt(idx))) {
               sb = sb.append(s.charAt(idx++));
            }
               // since it is well formed, the other case can only be number
            else {
                // index of the beginning of bracket
                int idx_b = idx;
                //System.out.println(idx_b);
                while (s.charAt(idx_b) !='[') {
                    idx_b++;
                }
                // change the string to number
                int k = Integer.parseInt(s.substring(idx, idx_b));
                int idx_e = idx_b+1;
                int count = 1;
                while (count !=0) {
                    if (s.charAt(idx_e)=='[') count++;
                    else if (s.charAt(idx_e)==']') count--;
                    idx_e++;
                }
                String sub = decodeString(s.substring(idx_b+1, idx_e-1));
                for (int i=0; i<k; i++) {
                    sb = sb.append(sub);
                }
                idx = idx_e;
            }
        }
        return sb.toString();
    }
}
