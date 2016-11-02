/*
 * Scarlett Chen
 * 11/1/2016 
 * 42. Trapping Rain Water 
 * two pointer, time: o(n),自己写的。
 */
package leetcode;

public class Trap {
    public int trap(int[] height) {
        //左右两个pointer
        int n = height.length;
        int i =0, j=n-1;
        int cur = 0;
        int total = 0;
        while (i<j) {
            while (i<j && height[i] <= cur) {
                total += cur - height[i];
                i++;
            }
            while (j>i && height[j] <= cur) {
                total += cur - height[j];
                j--;
            }
            if (i>=j) return total;
            cur = Math.min(height[i], height[j]);
        }
        return total;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
