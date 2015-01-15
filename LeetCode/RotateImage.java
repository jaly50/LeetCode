/*
 * LeetCode 109 Rotate Image
 * date:11/05/2014 Wed 10:09 AM
 * easy
 */
public class RotateImage {
	 public void rotate(int[][] matrix) {
	        int n=matrix.length-1;
	        int temp;
	        for (int i=0;i<=n/2; i++) {
	        	//made a mistake at where to end j
	            for (int j=i; j<=n-i-1; j++) {
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[n-j][i];
	                matrix[n-j][i] = matrix[n-i][n-j];
	                matrix[n-i][n-j]= matrix[j][n-i];
	                matrix[j][n-i] = temp;
	            
	            }
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
