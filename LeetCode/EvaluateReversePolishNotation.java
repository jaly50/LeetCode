import java.util.Stack;
/*
 * LeetCode 38 Evaluate Reverse Polish Notation 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * date:2014/9/21
 * 
 */
public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		int i=0;
		int num, n1,n2;
		Stack<Integer> nums = new Stack<Integer>();
		if (tokens.length < 1) return 0;
		while (i < tokens.length) {
			if (((tokens[i].length() >1 )|| (tokens[i].charAt(0) >='0') && (tokens[i].charAt(0) <='9'))) {
				num = Integer.parseInt(tokens[i]);
				nums.push(num);
			}
			else if (tokens[i].length() == 1) {
				switch (tokens[i].charAt(0)) {
				case '+':
					nums.push(nums.pop() + nums.pop());
					break;
				case '-':
					n2 = nums.pop();
					n1 = nums.pop();
					nums.push(n1 - n2);
					break;
				case '*':
					nums.push(nums.pop() * nums.pop());
					break;
				case '/':
					n2 = nums.pop();
					n1 = nums.pop();
					nums.push(n1 / n2);
					break;
				default :
				break;
				}
			}
			i++;	
		}
		return nums.pop();
	}
	
	public static void main(String[] args) {
		String[] s = {"4", "13", "5", "/", "+"};
		String[] t = {"0","3","/"};
 		System.out.println(evalRPN(s));
 		System.out.println(evalRPN(t));
	}
}
