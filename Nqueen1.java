/*
 * dfs + backtracking + space (O(N))(one dimension array)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Leetcode 25
 * date:2014/9/12
 * Author:Scarlett
 * requirement: Given an integer n, return all distinct solutions to the n-queens puzzle.
 *  no two queens share the same row, column, or diagonal.
 */
public class Nqueen1 {
    private static List<String[]> list;
	private static void dfs(byte[] b, int n) {
		byte[] c;
		if (n==0) {
			String[] st =new String[b.length];
          for (int i=0; i<b.length; i++) {
        	  st[i] ="";
        	  for (int j =0; j<b.length; j++) {
        		  if (b[i] == j) {
        			  st[i] = st[i].concat("Q");
        		  }
        		  else 
        			  st[i] = st[i].concat(".");
        	  }
        	  
          }
          list.add(st);
          return;
		}
		//when there is n queen left, we have gone to row i  
		int i = b.length -n;
		  for (int j=0; j<b.length; j++) {
			  if (place(b, i, j)) {
				  b[i] = (byte) j;
				  dfs(b,n-1);
				  b[i]=-1;
			  }  
			}
			  
		  }
	
	// To judge whether we can put queen at i row j col
	 private static boolean place(byte[] b, int i, int j) {
		// Judge whether queen at 0~i-1 row is on the same col with j or not
		 // judge diagonal situation in the 0~i-1
		for (int x=0; x<i; x++) 
			if ((b[x]==j) || (x-b[x] == i-j) || (x+b[x] == i+j))
				return false;
		return true;
	}

	public static List<String[]> solveNQueens(int n) {
         list =  new ArrayList<String[]>();
	     if ((n<1) || (n==2) || (n==3)) return list;
	     //b is an array to mark the table
	     //b[i]=x means We put a queen at i row x col
	     byte[] b = new byte[n];
	     Arrays.fill(b,(byte)-1);
	     //Deep first search 
	    dfs(b,n);
	     
	     return list;
	  }
    public static void main(String[] args) {
    	list = solveNQueens(8);
    	for( int i=0; i<list.size(); i++) {
    		for (int j=0; j<list.get(i).length; j++) 
    		System.out.println((list.get(i))[j]);
    		System.out.println();
    	}
    }

 

}
