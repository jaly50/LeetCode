/*
2015.04.17
Number of Islands


*/
public class Solution {
    // simple dfs
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length<1) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int num=0;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++) 
        Arrays.fill(visited[i], false);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && grid[i][j]=='1') {
                    dfs(grid,i,j,visited);
                     num++;   
                }
                
            }
        }
        return num;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if (grid[i][j]=='0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid, i-1, j, visited);
         dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
         dfs(grid, i, j+1, visited);
        
        
    }
}
