/*
 * LeetCode 78  Letter Combinations of a Phone Number
 * Date: 2014/10/14
 * 深搜与路径记录。。简单题
 */
import java.util.ArrayList;
import java.util.List;


public class LetterCombination {
	private final char[][] dc =new char[][] {{' '},
   		 {},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
   		 {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};   
	 public List<String> letterCombinations(String digits) {
		 List<String> ans = new ArrayList<String>();
	     String path="";
	     dfs(0,digits,path,ans); 
	     return ans;
	    }
	private void dfs(int index, String digits, String path,
			List<String> ans) {
		// TODO Auto-generated method stub
		if (index == digits.length()) {
			ans.add(path);
			return;
		}
		char[] digit = dc[Integer.parseInt(digits.substring(index,index+1))];
	    for (int i=0; i<digit.length; i++) {
	    	dfs(index+1,digits,path+digit[i],ans);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombination l = new  LetterCombination();
		System.out.println(l.letterCombinations("23"));
	}

}
