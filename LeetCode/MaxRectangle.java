import java.util.Stack;
/*
 * LeetCode 157 Maximal Rectangle 
 * @Author: Scarlett Chen
 * @date: 12/28/2014 Sun 12:44 AM
 * o(n*m) 有些想法自己怎么就是想不到呢~
 * 就是largestRectangle的多层版！！对每一行都进行栈的维护，作为底边，找最大rectangle!
 */

public class MaxRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n <1) return 0;
        int m = matrix[0].length;
        //+1 is the fake final one
        // to maintain the height of each col when their base is the current row
        int[] height = new int[m+1];
        height[m] =0 ; // the fake one for the stack maintainance
        Stack<Integer> stack = new Stack<Integer>();
        int h,row,largest=0,curArea=0;
        for (int i=0; i<n; i++) {
           for (int j=0; j<m; j++) {
               //Set the height attributes
               h = 0;
               row = i;
               while (row>=0 &&matrix[row][j]=='1') {
                   row--;
                   h++;
               }
               height[j] = h;
           }
           for (int j=0; j<=m; j++) {
               //Get the maximum rectangle area by stack
              while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                  h = stack.pop();
                  curArea = height[h] * (stack.isEmpty()? j: j-stack.peek()-1);
                  largest = Math.max(curArea, largest);
                  
              }
              stack.push(j);
           }
           stack.removeAllElements();
           }
          
  
      return largest;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(maximalRectangle(new char[][] {{'1'}} ));
	}

}
