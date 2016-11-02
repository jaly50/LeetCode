/*
 * Time: 3:38 pm 9/20/2016 - 3:59 
 * 274 H-Index
 * thoughts: sort from big to small, for each ele, calculate whether it comply to the rule. n^2
 * Using counting-algorithm; the possible value is in [0,n]
 * Reference: True
 * 
 */
package leetcode;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i: citations) {
            if (len <= i) return len;
            else len--;
        }
        return len;
        
    }
    
    
    /*
     * 275: H-index2
     * Thought: binary search, 4:07 - 4:20
     * Reference: False 
     * 
     */
    public int hIndex2(int[] citations) {
        int h = citations.length;
        int count = h;
        int l = 0;
        int max= l;
        while (l < h) {
            int mid = l + (h-l)/2;
            int len = count - mid;
            if (len <= citations[mid]) {
                max = Math.max(len, max);
                h = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return max;
          
      }

}
