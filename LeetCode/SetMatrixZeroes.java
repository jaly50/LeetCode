import java.util.Arrays;
/*
 * Leetcode 137 Set Matrix Zeroes 
 * Author: Scarlett
 * 要求：Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

  这道题常见的误区可能是 会在matrix里直接改值，这样会导致错误。比如我因为matrix[1][2]==0，
  就把row[1] col[2]全设零，那么当数组遍历到 matrix[other number][2]时，也会把相应行全设为零。这就不是我们要的。
  
  O(mn)的方法很直接，就是再设一个boolean或int二维数组，用original的数组去判断是否修改，用新数组存改后的值
  o(m+n)的方法就是下面第一个， 用两个boolean数组(长度分别为m和n)判断该行或该列是否已被设为零
  
  O(1)的方法，这个不错：https://oj.leetcode.com/discuss/16190/is-there-any-constant-space-solution-with-just-one-pass
  其实就是用了状态转移，通过左边和上面的状态修改当前状态；通过当前状态修改本行和上面的状态。这样储存的东西少一些。....但感觉代码不如o(m+n)的清晰

 */

public class SetMatrixZeroes {
	/*
	 *  extra space: o(m+n)
	 *  用两个boolean数组(长度分别为m和n)判断该行或该列是否已被设为零
	 *  Date: 12/12/2014 Fri 7:15 PM
	 */
    public void setZeroes_OmPlusN(int[][] matrix) {
        int n = matrix.length;
        if (n==0) return;
        int m = matrix[0].length;
        boolean[] rowIsZero = new boolean[n];  
        boolean[] colIsZero = new boolean[m];
        Arrays.fill(rowIsZero, false);
        Arrays.fill(colIsZero, false);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j]==0) {
                    rowIsZero[i] = true;
                    colIsZero[j] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (rowIsZero[i] || colIsZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
      }
    
    /*   本来以为constant space solution可以用位运算，放两个字符串，分别代表row和col，每个数的每一位都代表具体的某一行或某一列，值可能有0或1
   其实就是利用了发现o(m+n)的方法里多的数组的值其实只有0和1  才能再进一步升级为位运算
     * 于是试图用bit operation写...
      发现n和m的长度超出20位...要用string的话。。我觉得就和上面那个O(m+n)没有什么本质区别了
      宣告失败= =
   */
    public void setZeroes_bitOperation_fail(int[][] matrix) {
        int n = matrix.length;
        if (n==0) return;
        int m = matrix[0].length;
        long rowIsZero = 0;  
        long colIsZero = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j]==0) {
                    rowIsZero |= 1<<i;
                    colIsZero |= 1<<j;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if ((rowIsZero & 1<<i) !=0 || (colIsZero &1<<j) !=0) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
