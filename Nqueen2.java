import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Leetcode 26
 * date:2014/9/13
 * Author:Scarlett
 * requirement: Given an integer n, return the number of all distinct solutions to the n-queens puzzle.
 *  no two queens share the same row, column, or diagonal.
 */
public class Nqueen2 {
    private static int ans;
    private static long all;
    
    // two dimention method
	private static void dfs(byte[][] b, int n) {
		byte[][] c;
		if (n==0) {
          ans++;
          return;
		}
		//when there is n queen left, we have gone to row i  
		int i = b.length -n;
		  for (int j=0; j<b.length; j++) {
			  if (b[i][j] ==0) {
				  b[i][j] = 1;
				  //mark the b table now
				  c = new byte[b.length][b.length];
				  for (int h=0; h<b.length; h++) {
					  c[h] = Arrays.copyOf(b[h],b[h].length);
				  }
				  // turns some places unavailable
				  // the same row
				 // Arrays.fill(b[i],(byte)-1);
				  // the same column
				  for (int x=0; x<b.length; x++) {
					  if (x!=i)
					  b[x][j] = -1;
				  }
				  // the diagonal--right and down
				  int x=1;
				  while ((i+x<b.length) && (j+x <b.length)) {
					  b[i+x][j+x] = -1;
					  x++;
				  }
				  // left and down
				  x =1;
				  while ((i+x<b.length) && (j-x >=0)) {
					  b[i+x][j-x] = -1;
					  x++;
				  }
				  
				  dfs(b,n-1);
				// turns those places available
				  b = c;
				  
			  }
			  
		  }
		
	}
	public static int totalNQueens(int n) {
         ans =0;
	     if ((n<1) || (n==2) || (n==3)) return ans;
	     all = (1 << n) -1;
	     //Deep first search 
	    dfs(0,0,0);
	     return ans;
	  }
	// bite-wise method
	//和一维数组法的时间复杂度是一样的，就是省了空间  n!
	private static void dfs(long row, long l, long r) {
		// TODO Auto-generated method stub
		long pos,p;
		if (row == all) {
			ans++;
		}
		else {
			pos = all & (~(row | l| r));
			while (pos >0) {
				p = pos & ((~pos) +1);
				pos = pos - p;
				dfs(row|p, (l|p)<<1, (r|p)>>1);
			}
		}
	}
    public static void main(String[] args) {
    		System.out.println(totalNQueens(8));
    }




}
