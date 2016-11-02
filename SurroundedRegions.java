public class Solution {
//Scarlett Chen
// 6/15/2015 Mon 8:55
//Surrounded Regions
// DFS ++ optimization at edge case
    public void solve(char[][] board) {
        // 0 in the edge; mark it as -1
        // if -1, mark as 0, else if 0, mark as X
        int n = board.length;
        if (n<=2) return;
        int m = board[0].length;
        if (m<=2) return;
        // dfs to -1
        for (int i=0; i<n; i++) {
            if (board[i][0]=='O')
            dfs(i,0, board);
             if (board[i][m-1]=='O')
            dfs(i,m-1,board);
        }
        for (int j=1; j<m-1; j++) {
             if (board[0][j]=='O')
            dfs(0,j,board);
             if (board[n-1][j]=='O')
            dfs(n-1,j,board);
        }
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++) {
                if (board[i][j]=='1') {
                    board[i][j]='O';
                }
                else if (board[i][j] =='O'){
                    board[i][j] ='X';
                }
            }
        }
        
    }
    public void dfs(int row, int col, char[][] board) {
        if (row <0 || row >= board.length || col <0 || col>=board[0].length)
            return;
        if (board[row][col]!='O') return;
        board[row][col]='1';
        // 我们考虑 row>1 && row< board.length-2 而非 row>0 && row<board.length-1 为了不重复计算，以及减少栈大小
        //  edge的情况这里不需要考虑。因为我们是从edge过来的，没有访问过的，接下来也会被访问到。
         if (row < board.length-2 && board[row+1][col]=='O')
        dfs(row+1, col, board);
         if (col<board[0].length-2 && board[row][col+1]=='O')
        dfs(row, col+1, board);
         if (row>1 && board[row-1][col]=='O')
        dfs(row-1, col, board);
         if (col >1 && board[row][col-1]=='O')
        dfs(row, col-1, board);

    }
}
