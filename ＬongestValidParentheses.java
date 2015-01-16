import java.util.Arrays;
import java.util.Stack;

/*
 * LeetCode  97 Longest Valid Parentheses
 * date: 10/25/2014
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * Thought: DP, a little bit tricky! 
 * I did myself, but we can also have a review.
 * 
 * There is better solution without stack.
 *  He uses the number of f[n] as stack, actually.
 */
/*
 *  Here below is the better code.
 * int longestValidParentheses(string s) {
            if(s.length() <= 1) return 0;
            int curMax = 0;
            vector<int> longest(s.size(),0);
            for(int i=1; i < s.length(); i++){
                if(s[i] == ')'){
                    if(s[i-1] == '('){
                        longest[i] = (i-2) >= 0 ? (longest[i-2] + 2) : 2;
                        curMax = max(longest[i],curMax);
                    }
                    else{ // if s[i-1] == ')', combine the previous length.
                        if(i-longest[i-1]-1 >= 0 && s[i-longest[i-1]-1] == '('){
                            longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                            curMax = max(longest[i],curMax);
                        }
                    }
                }
                //else if s[i] == '(', skip it, because longest[i] must be 0
            }
            return curMax;
        }
 */
public class ＬongestValidParentheses {
	 public static int longestValidParentheses(String s) {
		 if (s.length()<2) return 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        int[] f =new int[s.length()];
	        Arrays.fill(f, 0);
	        int index = 0;
	        int len = 0, max = 0;
	        char c;
	        while (index < s.length()) {
	            c = s.charAt(index);
	            if (c=='(') stack.push(index);
	            // if (c==')')
	            else {
	                if (!stack.isEmpty()) {
	                	int pre = stack.pop();
	                	// The below 3 row are most important part.
	                	f[index] =2;
	                   if (index - pre >1) f[index] +=f[index-1];
	                   if (pre-1>=0) f[index] += f[pre-1];
	                }
	                else {
	                	stack.removeAllElements();
	                }
	            }
	            max = Math.max(max, f[index]);
	            index++;
	        }
	       
	      
	      return max;  
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("()(()"));

	}

}
