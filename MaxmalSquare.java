//可以优化为o(n) space,在[j-1］处记录[i-1]［j-1］的值，存为一个变量。在[j]的时候利用起来。
//Scarlett Chen
// 6/4/2015 Thu 10:12 PM
//Maximal Square
public class Solution {
    public int maximalSquare(char[][] matrix) {
        // After seeing the tag, I know how to do the dp
        int n = matrix.length;
         if (n<1) return 0;
         int largest = 0;
        int m = matrix[0].length;
        int[][] square = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j =0; j<m; j++) {
                square[i][j]= matrix[i][j]-'0';
                //一直在想着左边上面，左上角要是1.却忘了 [i][j]是也是需要保证的！
               if (i>0 && j>0 && square[i][j]>0) {
                   square[i][j] =Math.min(Math.min(square[i-1][j], square[i][j-1]),square[i-1][j-1])+square[i][j];
               } 
               largest = Math.max(largest, square[i][j]);
              
            }
        }
        return largest*largest;
    }
}
