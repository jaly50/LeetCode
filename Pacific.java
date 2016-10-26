/*
 * Scarlett Chen
 * Tue 9:38 PM Oct 18, 2016
 * 变量值怎么取也很重要，用什么数据结构最简便 
 * 从哪个方向来找答案最快？
 */
import java.util.ArrayList;
import java.util.List;

public class Pacific {
    static int[][] pos = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0,1}};
    
    public boolean dfs1(int i, int j, int[][] matrix, int[][] arrive) {
    	//System.out.println("i= "+ i + " j= "+ j +":  "+ matrix[i][j]);
        if (arrive[i][j] == -1) return false;
        if (i==0 || j==0) arrive[i][j] |=1;
        if (i==matrix.length-1 || j==matrix[0].length-1) arrive[i][j] |=2;
        if (arrive[i][j]==3) return true;
        for (int[] a: pos) {
            int x = a[0] + i;
            int y = a[1] + j;
            if (x<0 || x >= matrix.length || y< 0 || y>=matrix[0].length) continue;
            if (matrix[x][y] <= matrix[i][j]) {
            	if (arrive[x][y] == 0) {
            		dfs(x,y, matrix, arrive);
            	}
            	if (arrive[x][y] == -1) continue;
            	else {
            		arrive[i][j] |= arrive[x][y];
            		if (arrive[i][j] == 3) return true;
            	}
            }
        }
        arrive[i][j] = -1;
        return false;
    }
    
    
    public List<int[]> pacificAtlantic1(int[][] matrix) {
        List<int[]> ans = new ArrayList<int[]>();
        // if matrix[]= Max_integer, int means it couldn't arrive
        // if matrix[] <0 means it can arrive, and its value = abs()
        // arrive[][] = 1 -> pacific, 2-> atlantic, 3-> yes
        
        int n = matrix.length;
        if (n<1) return ans;
        int m = matrix[0].length;
        int[][] arrive = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dfs(i,j, matrix, arrive) ) {
                  ans.add(new int[]{i,j});
                  System.out.println("i= "+ i + " j= "+ j +":  "+ matrix[i][j]);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, int height, boolean[][] visited, int[][] matrix ) {
    	visited[i][j] = true;
        for (int[] a: pos) {
            int x = a[0] + i;
            int y = a[1] + j;
            if (x<0 || x >= matrix.length || y< 0 || y>=matrix[0].length || matrix[x][y] < height || visited[x][y]) continue;
            dfs(x, y, matrix[x][y], visited, matrix);
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<int[]>();
        int n = matrix.length;
        if (n<1) return ans;
        int m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i=0; i<n; i++) {
        	dfs(i,0, matrix[i][0], pacific, matrix);
        	dfs(i, m-1, matrix[i][m-1], atlantic, matrix);
        }
        for (int i=0; i<m; i++) {
        	dfs(0, i, matrix[0][i], pacific, matrix);
        	dfs(n-1, i, matrix[n-1][i], atlantic, matrix);
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (pacific[i][j] && atlantic[i][j] ) {
                  ans.add(new int[]{i,j});
                  //System.out.println("i= "+ i + " j= "+ j +":  "+ matrix[i][j]);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		Pacific p = new Pacific();
		List<int[]> ans = p.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
		System.out.println(ans);

	}

}
