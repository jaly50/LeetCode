/*
 * Scarlett Chen
 * 6/9/2015 Tue 2:24 pm
 * 写完一次过...自己写的bitwise  solution..也是蛮厉害的（≧∇≦）
 */
public class SolveSukudo {
    public void solveSudoku(char[][] board) {
    	int n = board.length;
    	//bit int[]. row[0] means values in row[0], for example, if row[0]=5=000000101, it means row[0] already exist 1 and 3
    	int[] row = new int[n];
    	int[]col  = new int[n];
    	int[] dig = new int[n];
    	//We set the current value in the row, col and diagonal
    	for (int i=0; i<9; i++) {
    		for (int j=0; j<9; j++) {
    			if (board[i][j]!='.') {
    				int value = board[i][j] -'0';
    				row[i] = row[i]| (1<<(value-1));
    				col[j] = col[j] |(1<<(value-1));
    				int dp = i/3*3 +j/3;
    				dig[dp] = dig[dp] |(1<<(value-1));
    				
    			}
    			
    					
    		}
    	}
        dfs(board,0,row,col,dig);
    }
    public boolean dfs(char[][] board, int idx, int[] row, int[] col, int[] dig) {
    	int x=0, y=0;
        do {
        if (idx >=81) return true;
          x = idx /9;
          y = idx % 9;
         idx++;
        } while(board[x][y]!='.');
          int dagP = x/3 * 3+y/3;
         
          // To find all positions we can put in board[x,y]
         int pos = ((1<<9)-1) & (~(row[x] | col[y] | dig[dagP]));
         while (pos >0) {
             //the rightmost one
             int p = pos  & ((~pos) +1);
             pos = pos - p;
             board[x][y]= (char) (log2x(p)+'0');
             row[x] = row[x]|p;
             col[y] = col[y]|p;
             dig[dagP] = dig[dagP]|p;
             if (dfs(board, idx, row, col, dig)) return true;
              row[x] = row[x]-p;
             col[y] = col[y]-p;
             dig[dagP] = dig[dagP]-p;
             
         }
         board[x][y]='.';
         return false;
        
        
         
    }
    int log2x(int x) {
        int ans =1;
        while ((x>>1) >0) {
            ans ++;
            x = x>>1;
        }
        return ans;
    }
	public static void main(String[] args) {
		SolveSukudo s = new SolveSukudo();
		System.out.println(Math.l)
		

	}

}
