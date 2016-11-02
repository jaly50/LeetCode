/*
 * LeetCode 50 Container With Most Water 
 * Date: 2014/10/1
 * �����Լ�������ģ���Ŀ��˼�ʼ�����ˣ�
 *
 */
public class MaxArea {
	 public int maxArea(int[] height) {
	        int low =0, high = height.length -1, max = 0;
	        while (low < high) {
	            max = Math.max(max, (high - low) * Math.min(height[high], height[low]));
	            if (height[low] < height[high])
	                low ++;
	            else high --;
	        }
	       return max;
	    }
}
