/*
 * Scarlett Chen
 * Sat 1:10 PM 10/22/2016
 * 363. Max Sum of Rectangle No Larger Than K
 * 
 */
public class MaxSumSubmatrix {
	// Sat 1:30 PM  Brute Force,可以过。算出所有的sum, time: o((nm)^2)
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        // prevent that the input might be empty
        if (n<1) return 0;
        int m = matrix[0].length;
        int maxsum = Integer.MIN_VALUE;
        int[][] sum = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sum[i][j] = matrix[i][j];
                if (i>0) sum[i][j] += sum[i-1][j];
                if (j>0) sum[i][j] += sum[i][j-1];
                if (i>0 && j>0) sum[i][j] -= sum[i-1][j-1];
                if (sum[i][j] == k) return k;
                if (sum[i][j] < k && sum[i][j] > maxsum) maxsum = sum[i][j];
            }
        }
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++) {
                for (int a=i; a<n; a++) {
                    for (int l=j; l<m; l++) {
                        int rect;
                        rect = sum[a][l];
                        if (j>0) rect -=sum[a][j-1];
                        if (i>0) rect -= sum[i-1][l];
                        if (i>0 && j >0) rect += sum[i-1][j-1];
                        if (rect == k) return k;
                        if (rect < k && rect > maxsum) maxsum = rect;
                    }
                }
            }
        }
       return maxsum; 
    }

}
