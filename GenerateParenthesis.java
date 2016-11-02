/*
 * leetCode  39 Generate Parentheses
 * date 2014/09/23
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
import java.util.*;
public class GenerateParenthesis {
    static List<String> list;
	public static List<String> generateParenthesis(int n) {
		list = new ArrayList<String>();
		if (n <1) return list;
        dfs(n,n,new String());
        return list;
    }

	private static void dfs(int left, int right, String s) {
		// TODO Auto-generated method stub
		if (left ==0 ) {
			StringBuilder t = new StringBuilder();
			while (right > 0) {
				t.append(")");
				right --;
			}
			list.add(s.concat(t.toString()));
		}
		else if (left == right) {
			dfs(left-1,right,s.concat("("));
		}
		//left can not more than right
		else if (right > left) {
			dfs(left-1, right, s.concat("("));
			dfs(left, right-1, s.concat(")"));
		}
	}
	public static void main(String[] args) {
		list =generateParenthesis(2);
		for (int i=0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
