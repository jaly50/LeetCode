/*
 * LeetCode 110 Search a 2D Matrix
 * easy
 * binary search twice, first by row, second by col
 * date: 11/05/2014 Wed 10:27 PM
 * 
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int low,high,mid,row;
        int n=matrix.length, m=matrix[0].length;
        low = 0; high = n-1; mid = low;
        // Be careful: whether there should be equal operator..
        while (low <= high) {
            mid = low + (high-low)/2;
            if (matrix[mid][0] > target) high = mid-1;
            else if (matrix[mid][m-1] < target) low = mid+1;
            else break;
                    
            }
        low = 0; high = m-1; row = mid;
        while (low<= high) {
           mid = low +(high-low)/2;
           if (matrix[row][mid] > target) high = mid-1;
           else if (matrix[row][mid] < target) low = mid +1;
           else return true;
        }
        return false;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
