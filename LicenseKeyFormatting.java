public class Solution {
    public String licenseKeyFormatting(String S, int k) {
        // 超简单啊 不就是string manipulation吗
        int n = S.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=n-1; i>=0; i--) {
            char a = S.charAt(i);
            if ( a =='-') continue;
            if (count==k) {
                count = 0;
                sb = sb.insert(0, '-');
            }
            if (count < k) {
                sb = sb.insert(0, Character.toUpperCase(a));
                count++;
            }

            
        }
        return sb.toString();
    }
}
