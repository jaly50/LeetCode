import java.util.Arrays;

/*
 * Leetcode 98  Valid Sudoku
 * thought: part of thought
 * Time: small scope of data, n always equal to 9*9
 * To reduce more time, we could use bit operation
 */
public class IsValidSudoku {
	/*
	public void bit() {
		int[] row = new int[9]; Arrays.fill(row,0);
		int[] col = new int[9];Arrays.fill(col,0);
		int[] block = new int[9];Arrays.fill(block,0);
		for (int i=0; i< 9; i++) {
            for (int j =0; j< 9; j++) {
            	 if (board[i][j] !='.') {
            		 if (row[i] ^ 1<<j)
            	 }
            
	}
	*/
	public boolean isValidSudoku(char[][] board) {
        boolean pass;
        for (int i=0; i< 9; i++) {
            for (int j =0; j< 9; j++) {
                if (board[i][j] !='.') {
                pass = left(i,j,board) && up(i,j,board) && leftup(i,j,board);
                if (!pass) {
                	//System.out.println(i+" "+j+" "+board[i][j]);
                	return false;
                }
                }
            }
        }
       return true; 
    }
	private boolean rightup(int i, int j, char[][] board) {
		int x= i-1;
		int y = j+1;
		if (x>=0 && y<board[0].length)
			if (board[x][y]==board[i][j]) return false;
		x=x-1;
		y=y+1;
		if (x>=0 && y<board[0].length)
			if (board[x][y]==board[i][j]) return false;
		return true;
	}
	private boolean leftup(int i, int j, char[][] board) {
		int x= i / 3 * 3;
		int y = j/3 * 3;
		for (int n=x; n<i; n++)
			for (int m=y; m<y+3 && m<9; m++)
			if (board[n][m]==board[i][j]) return false;
		return true;
	}
	private boolean up(int i, int j, char[][] board) {
		for (int x=0; x<i; x++)
			if (board[x][j] == board[i][j]) return false;
		return true;
	}
	private boolean left(int i, int j, char[][] board) {
		// TODO Auto-generated method stub
		for (int x=0; x<j; x++)
			if (board[i][x] == board[i][j]) return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(5/3*3);
		String[] s = new String[]
				{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
				//{"..5.....6","....14...",".........",".....92..","5....2...",".......3.","...54....","3.....42.","...27.6.."};
	      char[][] board = new char[s.length][s[1].length()];
		for (int i=0; i<s.length; i++) {
			board[i] =s[i].toCharArray();
			System.out.println(s[i]);
		}
		IsValidSudoku x = new IsValidSudoku();
		System.out.println(x.isValidSudoku(board));

	}

}
