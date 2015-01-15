/*
 * LeetCode 64  Longest Common Prefix 
 * Date: 2014/10/8
 */
import java.util.Arrays;
import java.util.Collections;


public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
    	if (strs.length ==0) return "";
    	if (strs.length ==1) return strs[0];
    	Arrays.sort(strs);
    	 int len = strs[0].length();
    	 String sub = "";
    	 boolean isFound = false;
        for (int i=0; i<len; i++) {
           sub = strs[0].substring(0, i+1);
        	for (int j=0; j<strs.length; j++) {
        		if (!(strs[j].substring(0, i+1)).equals(sub)) {
        			isFound = true;
        			break;
        		}
        	}
           if (isFound) {
        	   sub =  strs[0].substring(0, i);
        	   break;
           }
        } 
       return sub;
     }
    public static void main(String[] agrs) {
    	System.out.println("   ".substring(0, 0));
    }
}
