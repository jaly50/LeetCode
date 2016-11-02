/*
 * Scarlett Chen 10/19/2016 5:25 PM
 * 354. Russian Doll Envelopes
 * thought: sort by width, 
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    // Scarlett Chen 10/19/2016 5:44 PM
    public int maxEnvelopes(int[][] envelopes) {
        // first sort, then get longest increase subsequence through binary search 
        // sort by width, if width is equal, sort by height from big to small..  [then if h[i] > h[j], i>j, then w[i] must > w[j]]
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                  return b[1] - a[1];
                else return a[1] - b[1];
            }
        });
        int n = envelopes.length;
        // longest increasing subsequence
        // We don't need to worry about width, it is already sorted
        int[] tail = new int[n];
        int size=0;
        for (int[] a: envelopes) {
            int l =0, h=size, mid = 0;
            while (l<h) {
                mid = l+(h-l)/2;
                if (tail[mid] >= a[1]) h= mid;
                else l = mid+1;
                
            }
            tail[l] = a[1];
            if (l>= size) size++;
        }
        return size;
        

}
    
}