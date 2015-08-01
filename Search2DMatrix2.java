/**
 * Scarlett Chen 7/31/2015 Fri 10:36 PM
 * time complexity: m+n, search from left bottom to right top
 * 
 * 
 **/
 public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int x = matrix.length-1;
       if (x<0) return false;
       int m = matrix[0].length;
       int y=0;
       while (x>=0 && y<m) {
           if (matrix[x][y]== target) return true;
           else if (matrix[x][y] < target) {
               y++;
           }
           else x--;
       }
        return false;
    }
}

/**
 * Scarlett Chen 7/31/2015 Fri 10:36 PM
 * time complexity: m+n, search from top right to bottom left
 * 
 * 
 **/
    public boolean searchMatrix(int[][] matrix, int target) {
       int n = matrix.length;
       if (n<1) return false;
       int y = matrix[0].length-1;
       int x=0;
       while (x<n && y>=0) {
           if (matrix[x][y]== target) return true;
           else if (matrix[x][y] < target) {
               x++;
           }
           else y--;
       }
        return false;
    }
