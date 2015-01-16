/*
 * LeetCode 93 Valid Parentheses 
 * date: 2014/10/21
 * 原来字符串不能用==啊
 * 只能用equal
 * ==是比较对象的引用地址，如果要比较对象的值的话用equal吧！
 */
import java.util.Stack;


public class ValidParentheses {
    public static boolean isValid(String s) {
        char c,d;
        String pair;
        Stack<Character> stack = new Stack<Character>(); 
     for (int i=0; i<s.length(); i++ ) {
         c= s.charAt(i);
         if (c=='(' || c=='[' || c=='{')
          stack.push(c);
          else {
              if (stack.isEmpty()) return false;
              d = stack.pop();
              pair = ""+d+c;
              //学习了正则表达式！感觉自己棒棒哒！
              if (!pair.matches("\\(\\)|\\{\\}|\\[\\]")) return false;
            //  if (pair.equals("()"));
            //  else if (pair.equals("[]"));
            //  else if (pair.equals("{}"));
            //  else return false;
          }
     } 
     return stack.isEmpty();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("[]"=="[]");
		//System.out.println("[]".equals("[]"));
       System.out.println(isValid("([][])"));
	}

}
