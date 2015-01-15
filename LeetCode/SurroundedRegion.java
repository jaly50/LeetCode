import java.util.Arrays;
/*
 * Date:12/21/2014 Sun 5:59 PM
 * @author: Scarlett Chen
 */

public class SurroundedRegion {
	    boolean [] hasEdge;
	    int[] union;
	    /*
	     * 从pittsburgh写到san diego，感觉真不容易~一开始用了recursive dfs, 还发生了stackoverflow.QAQ .
	     * 最后用了algorithm1的unionfind写的~！感觉自己代码实现能力有提高呢！.
	     */
	    public void solve(char[][] board) {
	     int n = board.length;
	     if (n<1) return;
	     int m = board[0].length;
	     hasEdge = new boolean[n*m];
	     union = new int[n*m];
	     int pos;
	     for (int i=0; i<n; i++) {
	    	 for (int j=0; j<m; j++) {
	    		pos = i*m +j;
	    		hasEdge[pos] = (i==0 ||j==0||i==n-1||j==m-1) ? true : false;
	    		union[pos] = pos;
	    		if (i>0 && board[i][j]== board[i-1][j]) {
	    			union(pos, pos-m);
	    		}
	    		if (j>0 && board[i][j] == board[i][j-1]) {
	    			union(pos, pos-1);
	    		}
	    	   
	    	 }
	     }
	     for (int i=0; i<n; i++) {
	    	 for (int j=0; j<m; j++) {
	    		 pos = i*m+j;
	    		 if (board[i][j]=='O' &&  !hasEdge[findRoot(pos)]) {
	    			 board[i][j] = 'X';
	    		 }
	    	 }
	     }
	     for (int i=0; i<board.length; i++) 
				System.out.println(Arrays.toString(board[i]));
	     
	    }
	    
	    private void union(int x, int y) {
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			union[rootX] = rootY;
			boolean hasedge = hasEdge[rootX] || hasEdge[rootY];
			hasEdge[rootY] = hasedge;
	
		}

		private int findRoot(int x) {
			if (union[x]==x) return x;
			else return findRoot(union[x]);
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegion sr = new SurroundedRegion();
		char[][] board = new char[][] {{'X', 'X', 'X', 'X'},
										{'X', 'O', 'O', 'X'},
										{'X', 'X', 'O', 'X'},
										{'X', 'O' ,'X' ,'X'}};
		sr.solve(board);
	}
	
	
	//Failed
	//Limitation in recursion depth
	//sometimes we need to use stack to do bfs or dfs.
	 boolean[][] withEdge;
	    char[][] board;
	    int n;
	    int m;
	public void solve_fail(char[][] board) {
	       n= board.length;
	       this. board = board;
	       if (n<1) return;
	       m = board[0].length;
	       withEdge = new boolean[n][m];
	       for (int i=0; i<n; i++) {
	           Arrays.fill(withEdge[i], false);
	       }
	        for (int i=0; i<n; i++) {
	         if (board[i][0]=='O') {
	             if (!withEdge[i][0]) {
	                 dfs(i,0);
	             }
	         }
	        if (board[i][m-1]=='O') {
	             if (!withEdge[i][m-1]) {
	                 dfs(i,m-1);
	             }
	         }
	        }
	       for (int j=0; j<m; j++) {
	           if (board[0][j]=='O') {
	               if (!withEdge[0][j]) {
	                 dfs(0,j); 
	               }
	           }
	          if (board[n-1][j]=='O') {
	               if (!withEdge[n-1][j]) {
	                 dfs(n-1,j); 
	               }
	           }
	       }
	      for (int i=0; i<n; i++) {
	          for (int j=0; j<board[0].length; j++) {
	              if (board[i][j]=='O' && !withEdge[i][j]) {
	                  board[i][j] = 'X';
	              }
	          }
	      }
	        
	    }
	    public void dfs(int row, int col) {
	    	withEdge[row][col] = true;
	        if (row>0 && board[row-1][col]=='O' && !withEdge[row-1][col]) {
	            dfs(row-1, col);
	        }
	        if (row<n-1 && board[row+1][col]=='O' && !withEdge[row+1][col]) {
	            dfs(row+1, col);
	        }
	        if (col>0 && board[row][col-1]=='O' && !withEdge[row][col-1]) {
	            dfs(row, col-1);
	        }
	        if (col<board[0].length-1 && board[row][col+1]=='O' && !withEdge[row][col+1]) {
	            dfs(row, col+1);
	        }
	    }
	
}
