import java.util.Arrays;

/*
 Leetcode 105 
 10/31/2014
 time: (9*9*9*9)

 */
/*
 * Tips, be careful:
 * * When you find answer, remember to stop all of process asap.
 * 
 */

public class SolveSudoku_TLE {
	char[][] ans;
	boolean isans;
	
	int[] rows = new int[9];
	int[] cols = new int[9];
	int[] block = new int[9];

	public void solveSudoku(char[][] board) {
		
		Arrays.fill(rows,0);
		Arrays.fill(cols, 0);
		Arrays.fill(block, 0);
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++) 
				if (board[i][j]!='.')
			{
				int x = board[i][j]-'0';
				rows[i] |= 1<<x;
				cols[j] |= 1<<x;
				int a=i/3, b=j/3;
				block[a*3+b] |=1<<x;
			}
		
		isans = false;
		ans = new char[9][9];
		dfs(0, 0, board);
		board = ans;
		// print(board);
	}

	private void dfs(int i, int j, char[][] board) {

		if (j >= 9)
			dfs(i + 1, 0, board);
		else if (i >= 9) {
			for (int n = 0; n < 9; n++) {
				for (int m = 0; m < 9; m++) {
					ans[n][m] = board[n][m];
				}
			}
			isans = true;
			return;
		} else if (board[i][j] != '.')
			dfs(i, j + 1, board);
		else
		// if (board[i][j] =='.' )
		{
			for (int x = 1; x <= 9; x++)
				// try every possible number
				if (test(i, j, x, board)) {
					board[i][j] = (char) (x + '0');
					dfs(i, j + 1, board);
					if (isans)
						return;
					board[i][j] = '.';
				}
		}
	}

	// now board[i][j]=='.'
	// we want to test whether we could put x here
	private boolean test(int i, int j, int y, char[][] board) {

		int x = (char) (y + '0');
		for (int a = 0; a < 9; a++)
			if (board[a][j] == x)
				return false;
		for (int b = 0; b < 9; b++)
			if (board[i][b] == x)
				return false;
		int a = i / 3 * 3;
		int b = j / 3 * 3;
		for (int c = 0; c < 3; c++)
			for (int d = 0; d < 3; d++)
				if (board[a + c][b + d] == x)
					return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(5/3*3);
		System.out.println(1<<1);
		int t = 5 + '0';
		System.out.println('0' == '0');
		System.out.println((char) (5 + '0'));
		String[] s = new String[] { "..9748...", "7........", ".2.1.9...",
				"..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.",
				"........6", "...2759.." };
		// {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		// {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		// {"..5.....6","....14...",".........",".....92..","5....2...",".......3.","...54....","3.....42.","...27.6.."};
		char[][] board = new char[s.length][s[1].length()];
		for (int i = 0; i < s.length; i++) {
			board[i] = s[i].toCharArray();
			System.out.println(s[i]);
		}
		SolveSudoku_TLE x = new SolveSudoku_TLE();
		x.solveSudoku(board);

	}

	private void print(char[][] board) {
		// TODO Auto-generated method stub
		System.out.println("--------Here is the ans.-------");
		for (int n = 0; n < 9; n++) {
			for (int m = 0; m < 9; m++) {
				ans[n][m] = board[n][m];
				int x, y;
				x = ans[n][m];
				y = board[n][m];
				System.out.print(ans[n][m]);
			}
			System.out.println();
		}
	}
}
