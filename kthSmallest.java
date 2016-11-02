/*
 * Scarlett Chen
 *  11/12016 3:03 PM
 *  378. Kth Smallest Element in a Sorted Matrix
 *  rows and columns are sorted in ascending order,
 *  1.按对角线找到第K个值，做法可以达到O(1)
 *  发现自己的assumption完全是错的。。哭哭
 *  
 */
package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {
	//还是用刚刚Priority queue的方法
    class Ele implements Comparable<Ele> {
        int ele;
        int i;
        int j;
        Ele(int ele, int i, int j) {
            this.ele = ele;
            this.i = i;
            this.j = j;
        }
        public int compareTo(Ele that) {
            return this.ele - that.ele;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Ele> pq = new PriorityQueue<Ele>();
        for (int i=0; i < Math.min(n, k); i++) pq.offer(new Ele(matrix[i][0], i, 0));
        Ele e=pq.peek();
        while (!pq.isEmpty()  && k>0) {
            e = pq.poll();
            if (e.j + 1 < n) {
            pq.offer( new Ele(matrix[e.i][e.j+1], e.i,e.j+1));
            }
            k--;
        }
        return e.ele;
    }
	
	//找到matrix:右上左下对角线为行中的第K个
    public int find(int row, int k, int[][] matrix) {
        int n = matrix.length;
        int sum = row < n? row+1: 2*n-row-1;
        // assume k<sum
        if (k>sum) System.out.println("Error: K should be one element in the a");
        int[] a = new int[sum];
        int i=0, j= row, h=0;
        while (i<n) {
           if (j<n) a[h++] = matrix[i][j];
            i++;
            j--;
        }
        //n log n
        Arrays.sort(a);
        return a[k-1];
    }
    public int kthSmallest_Wrong(int[][] matrix, int k) {
        int n = matrix.length;
        if (k <= n*(n+1)/2) {
            int row = (int)(Math.sqrt(8* (k-1) + 1) -1);
            return find(row, k- row*(row+1)/2, matrix);
        }
        else {
            k = k-n*(n+1)/2;
            int all = n-1;
            int row = n;
            while (k > all) {
                k-= all;
                row++;
                all--;
            }
            return find(row, k, matrix);
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
