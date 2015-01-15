/*
 * LeetCode 117
 * Date 11/12/2014 11:54 AM WED
 * A easy algorithm
 * be careful: 1. matrix is n*n, so actually there is n*n element 2. think about the result when n==0,n==1
 * 
 */
import java.util.Arrays;


public class GenerateMatrix {
    static int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
       int[][] a = new int[n][n];
       for (int i=0; i<n*n; i++) Arrays.fill(a[i], 0);
       int x=0, y=0, index= 0;
       for (int i=1; i<=n; i++) {
    	 a[x][y] = i; 
    	 x = x+pos[index][0];
    	 y= y+pos[index][1];
    	 if (x==n || x<0 ||y==n ||y<0 || a[x][y]!=0) {
    		 x = x-pos[index][0];
    		 y=y-pos[index][1];
    		 index = (index+1)%4;
    		 x = x+pos[index][0];
    		 y=y+pos[index][1];
    	 }
       }
       return a;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateMatrix g = new GenerateMatrix();
		System.out.println(Arrays.toString(g.generateMatrix(1)));

	}

}
