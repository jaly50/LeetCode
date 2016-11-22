//Scarlett chen, Tue 9:39 AM, 11/22/2016 这种题，主要要注意细节
public class Solution {
    //直接翻转，每个词再逆序
    public void reverseWords(char[] s) {
        int len = s.length;
       
        for (int i=0, j=len-i-1; i<len/2; i++, j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            
        }

        for (int i=0, begin=0; i<len; i++) {
            if (s[i] ==' ' || i==len-1) {
                int end = s[i]==' '? i-1 : i;
                while (end>begin) {
                    char temp = s[end];
                    s[end] = s[begin];
                    s[begin] = temp;
                    end--;
                    begin++;
                }
                begin = i+1;
            }
        }
    }
}
