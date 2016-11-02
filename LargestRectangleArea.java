import java.util.Stack;

/*
 * @Author: Scarlett Chen
 * @date: 12/27/2014 Sat 11:42 PM
 * LeetCode 156  Largest Rectangle in Histogram
 * 1. o(n^2) + 剪枝可过
 * 2. 线段树，维护线段之中的最小值 +  分治 recursive 可过 http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 * 3. 用栈 保持递增序列
 * 这个讲得特别好：http://blog.csdn.net/doc_sgl/article/details/11805519
 */
public class LargestRectangleArea {
	public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = height.length;
        if (n<1) return 0;
        int largest = height[0];
        for (int i=0; i<=n; i++) {
        	int curHeight = i==n? 0: height[i];
            while (!stack.isEmpty() && height[stack.peek()] > curHeight) {
                int index = stack.pop();
                /*
                 * 拿 0 3 2 5 举例
                 * 之所以要i-stack.peek()-1
                 * 是因为在入栈时，2<3,所以3被踢掉了。但在算2为高度的最大面积时
                 * 就要算从栈内的 0 后面一位直到i：这距离就是 i-stack.peek()【就是0 +1
                 */
                int curArea = height[index] * (stack.isEmpty()? i:i-stack.peek()-1);
                largest = Math.max(largest, curArea);
            }
             stack.push(i);
            }
        return largest;
        }
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
