/*
 * Scarlett Chen
 * 10/11/2016 12:05 PM -12：33PM
 * way1: BFS: using visit to store all of possibilities then existed before
 *  本题点睛之笔是 保证target_len <= currrent_str.length()，一旦target_len比当前值大，说明误入下一层了。
 *  呆会试试dfs.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthese {
	
	private boolean valid(String str) {
		int count = 0;
		for (int i=0; i< str.length(); i++) {
			if (str.charAt(i) == '(') count--;
			else if (str.charAt(i) == ')') count ++;
			if (count > 0 ) return false;
		}
		return count==0;
	}
	
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        q.offer(s);
        visited.add(s);
        int target_len = -1;
        while (!q.isEmpty()) {
        	String str = q.poll();
        	// Will add all possibilities in this level
        	if (valid(str) && target_len <= str.length()) {
        		res.add(str);
        		target_len = str.length();
        	}
        	// if found, we are not going to explore to the next 2 level
        	// But we still need to consider the way that past value has already geneted the next level
        	if (target_len >=0 ) continue;
        	// Explore the next state by deleting one element
        	for (int i=0; i< str.length(); i++) {
        		String new_str = str.substring(0, i) + str.substring(i+1);
        		if (!visited.contains(new_str)) {
        			q.offer(new_str);
        			visited.add(new_str);
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
