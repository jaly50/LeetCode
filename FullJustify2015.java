// Sat 7:02 pm - 7:44pm
// Scarlett Chen
// Text Justification
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> ans = new LinkedList<String>();
       int n = words.length;

       int i=0, w=0,strlen=0, space=0, extra=0;
       for (; i<n; i=w) {
           int len = -1;
           StringBuilder sb = new StringBuilder(words[i]);
           for (w=i; w<n && len+words[w].length()+1<=maxWidth; w++) {
               len +=words[w].length()+1;
           }
           if (len!=-1 && w<n && w!=i+1) {
            space = (maxWidth - len)/(w-i-1)+1;
            extra = (maxWidth - len)%(w-i-1);
           }
           else {
               // last line: w==n
               space=1; extra=0;
           }
           for (int x=i+1; x<w; x++) {
               for (int t=space; t>0; t--) sb.append(' ');
               if (extra-->0) sb.append(' ');
               sb.append(words[x]);
           }
           
           int left = maxWidth - sb.length();
           while (left-->0) sb.append(' ');
           
           ans.add(sb.toString());
       }
      return ans; 
    }
}
