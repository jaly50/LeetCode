import java.util.Arrays;
import java.util.Stack;
/*
 * LeetCode: 137  Simplify Path 
 * Author: Scarlett
 * 字符串处理题，要用到string.split
 * 主要是处理 . 和..的情况
 * 用stack增加和删除路径
 * 
 * 第一遍没过是因为没有考虑 //的情况下，split会分配给它一个 length=0的string  ---要注理掉
 */

public class SimplifyPath {
	 public String simplifyPath(String path) {
	        if (path==null || path.length()==0) return path;
	        Stack<String> s = new Stack<String>();
	        String[] pos = path.split("/");
	     //   System.out.println(Arrays.toString(pos));
	        for (int i =0 ; i< pos.length; i++) {
	            if (pos[i].equals(".") || pos[i].length()==0) {
	                continue;
	            }
	            else if (pos[i].equals("..")) {
	                if (!s.isEmpty()) s.pop();
	            }
	            else {
	                s.push(pos[i]);
	            }
	        }
	        StringBuffer ans = new StringBuffer();
	        while (!s.isEmpty()) {
	        	ans.insert(0, '/'+s.pop());
	        }
	        if (ans.length()==0) ans.append('/');
	        return ans.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/..."));
	}

}
