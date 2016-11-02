/*
 * LeetCode 94  Word Search 
 * Date: 10/23/2014
 * typical grid dfs, not difficult, be careful about the board
 */
public class ＷordInGrid {
	 boolean ans;
	 char[][] board;
	 int n,m; // n is number of rows; m is number of columns
	 String word;
	    public boolean exist(char[][] board, String word) {
	    	this.board = board;
	    	this.word = word;
	    	this.n =board.length;
	    	this.m = board[0].length;
	        ans = false;
	        if (board.length==0) return false;
	        if (word.length()==0) return false; 
	        boolean[][] walked = new boolean[board.length][board[0].length];
	        for (int i=0; i<n; i++)
	          for (int j=0; j<m; j++)
	           walked[i][j] = false;
	        for (int i=0; i<board.length; i++) {
	            for (int j=0; j<board[i].length; j++) {
	            	char c = board[i][j];
	            	char s = word.charAt(0);
	               if (board[i][j]==word.charAt(0)) {
	                 dfs(i,j,board,1,word,walked);
	               }
	            }
	        }
	        return ans;
	    }
	    private void dfs(int i, int j, char[][] board, int index, String word, boolean[][] walked) {
	        if (ans) return;
	        if (index==word.length()) {
	            ans = true;
	            return;
	        }
	        walked[i][j]= true;
	        // If using if..else would  reduce constant time
	        if ((i-1>=0) && (!walked[i-1][j]) && (board[i-1][j]==word.charAt(index))) 
	        	dfs(i-1,j,board,index+1,word,walked);
	        if ((j-1>=0) && (!walked[i][j-1]) && (board[i][j-1]==word.charAt(index))) 
	        	dfs(i,j-1,board,index+1,word,walked);
	        if ((i+1<board.length) && (!walked[i+1][j]) && (board[i+1][j]==word.charAt(index))) 
	            dfs(i+1,j,board,index+1,word,walked);
	         if ((j+1<board[0].length) && (!walked[i][j+1]) && (board[i][j+1]==word.charAt(index))) 
	            dfs(i,j+1,board,index+1,word,walked);
	         walked[i][j]= false;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ＷordInGrid w = new ＷordInGrid();
      String[] b= new String[]{"CAA","AAA","BCD"};
      
      char[][] board = new char[b.length][b[0].length()];
      for (int i=0; i<b.length; i++) {
    	  board[i] = b[i].toCharArray();
      }
      String word ="AAB";
      System.out.println(w.exist(board, word));
      
	}

}
