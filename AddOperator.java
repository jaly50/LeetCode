/*
 * 282. Expression Add Operators
 * date: 9/23/2016 4:16 PM -5
 * 
 * Path could be char, can also be String.
 * Didn't say it is in integer range, should deal it as Long to take care of value like: "2147483648"
 * Reference: True
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddOperator {
	// Add one element to store last result of calculation, since * should always have the priority
    public void dfs(List<String> res, String path, int pos,  long value, String num, int target, long last) {
        if (pos == num.length()) {
            if (value == target) res.add(path); 
            return;
        }
        else {
            long ele = 0;
            for (int i=pos; i < num.length(); i++) {
            	// Corner case consideration: 05 cannot be deal as 5, so we will delete any elements start with 0 but only only one digit
            	if (i!=pos && num.charAt(pos) == '0') break;
                 ele = ele * 10 + Character.getNumericValue(num.charAt(i));
                if (pos ==0) 
                	dfs(res, path +  ele, i+1, value + ele, num, target, ele );
                else {
	                dfs(res, path + "+" + ele, i+1, value + ele, num, target, ele );
	                dfs(res, path + "-" + ele, i+1, value - ele, num, target, -ele );
	                dfs(res, path + "*" + ele, i+1, value - last + last*ele, num, target, last * ele );
                }
                
            }
        }
    }
	
	
    public List<String> addOperators(String num, int target) {
        // The result list
        List<String> res = new LinkedList<String>();
        // Always remember to deal with corner case
        if (num == null || num.length() <1) return res;
        // Current solution
        String path="";
        int value=0;
        dfs(res, path, 0, value, num, target, 0);

        return res;
        
    }
}
