/*
 * 279. Perfect Squares
 * 9/21/2016 11:53 AM
 * Dynamic Programming
 * a1,a2,a3,a4.....   f[i]=min(a4+f[i-a4], a3+f[i-a3]]
 * What if n is too large?
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumSquares {
	
	// The basic dynamic programming, o(n*sqrt(n))
    public static int numSquares0(int n) {
        int[] f = new int[n+1];
        for (int i=1; i<=n; i++) {
            f[i] = i;
            for (int j=1; j*j<=i; j++) {
                f[i] = Math.min(f[i], 1+f[i-j*j]);
            }
        }
        return f[n];
    }
    
    /*
     *  9/23/2016 4:02 PM
     *  space: o(n)
     *  t:o(n*sqrt(n))
     */
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int step = 0;
        set.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            step +=1;
            for (int a=0; a<size; a++) {
                int x = q.remove();
                for (int i=1; i*i+x <=n; i++) {
                    if (i*i+x==n) return step;
                    if (set.contains(i*i+x)) continue;
                    set.add(i*i+x);
                    q.add(i*i+x);
                }
            }

        }
        return step;
    }
    
    public static void main(String[] args){
    	System.out.println(NumSquares.numSquares0(21000000));
    }

}
