/*
 * dfs
 * 200. Number of Islands
 * Scarlett Chen
 * 9/29/2016 6:30PM
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
	// The obstable I met:
	// 1. How to get the Int returned? Should I keep the res as static int? Or Integer? Since primitive will only pass by vale.
	// => Each time get into dfs should +1. You don't need to pass the result into dfs
	 public int numIslands_dfs(char[][] grid) {
	        int ans=0;
	        for (int i=0; i< grid.length; i++) {
	            for (int j =0; j< grid[i].length; j++) {
	                if (grid[i][j]=='1') {
	                    dfs(grid, i,j);
	                    ans +=1;
	                }
	            }
	        }
	        return ans;
	    }
	    private void dfs(char[][] grid, int x, int y) {
	        if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1') {
	        grid[x][y] = '-';
	        dfs(grid, x-1, y);
	        dfs(grid, x, y-1);
	        dfs(grid, x+1, y);
	        dfs(grid, x, y+1);
	        }
	    }
	    
	    
	 //bfs   
	    public int numIslands(char[][] grid) {
	        int ans=0;
	        Queue<Integer> q = new LinkedList<Integer>();
	        int n= grid.length, m =grid[0].length;
	        for (int i=0; i< grid.length; i++) {
	            for (int j =0; j< grid[i].length; j++) {
	                if (grid[i][j]=='1') {
	                    // The first problem I meet for bfs, is how to store (x,y) tuple as one value in the queue
	                    q.offer(i*m+j);
	                    while (!q.isEmpty()) {
	                        int val = q.poll();
	                        int y = val % m, x = val / m;
	                         if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1') {
	                            grid[x][y] = '-';
	                            q.offer((x-1)*m+ y);
	                            q.offer((x*m)+(y-1));
	                            q.offer((x+1)*m+ y);
	                            q.offer(x*m+y+1);
	                    
	                         }
	                         }

	                    ans +=1;
	                }
	            }
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
