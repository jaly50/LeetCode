/*
 * LeetCode 49  Minimum Path Sum 
 * Date:2014/9/30
 * 简单题，自己做的。
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
import java.util.Arrays;


public class MinPathSum {
	 public static int minPathSum(int[][] grid) {
	        int nRow, nCol;
	        nRow = grid.length;
	        nCol = grid[0].length;
	        int[][] sum = new int[nRow+1][nCol+1];
	        Arrays.fill(sum[0],Integer.MAX_VALUE);
	        for (int i=0; i<= nRow; i++) {
	            sum[i][0] = Integer.MAX_VALUE;
	        }
	        sum[0][1] = 0;
	        sum[1][0] =0;
	        for (int i = 1; i<= nRow; i++) {
	            for (int j=1; j<= nCol; j++) {
	                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1])+grid[i-1][j-1];
	            }
	        }
	        return sum[nRow][nCol];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] s = new int[][]{{1,2},{1,1}};
       System.out.println(minPathSum(s));
	}

}
