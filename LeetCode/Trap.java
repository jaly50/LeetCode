/*
 * Leetcode 112  Trapping Rain Water 
 * date: 11/6/2014 Thu 7:00 PM
 * 从左到右，从右到左，找到最大值〜
 * Ｏ（Ｎ）
 */
public class Trap {
	public int trap(int[] A) {
        int ans= 0;
        int left = 0;
        int max = 0, max_pos=0;
        for (int i=0; i<A.length; i++) {
        	if (max < A[i]) {
        		max = A[i];
        		max_pos = i;
        	}

        }
        for (int i =0; i<max_pos; i++ ) {
           if (A[i]< left) {
        	   ans +=left-A[i];
           }
           else {
        	   left = A[i];
           }
            }
        int right = 0;
        for (int i=A.length-1; i>max_pos; i--) {
        	if (A[i]<right) {
        		ans +=right -A[i];
        	}
        	else right = A[i];
        }
       return ans;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Trap t = new Trap();
    //int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    int[] A = new int[]{0,1,0,0,1,3};
    System.out.println(t.trap(A));
	}

}
