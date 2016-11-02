
/*
 * Scarlett Chen
 * 10/21/2016 2:58 PM
 * 214. Shortest Palindrome
 *  如果全都不一样, center could be the first letter
 *  else: traverse from the middle to the left
 *  10/26/2016 4:11 PM
 */
package leetcode;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
    	if (s.isEmpty()) return s;
    	//reverse the string
        String p = new StringBuilder(s).reverse().toString();
        // make last part of sp = first part of sp
        String sp = new String(s+p);
        int[] pt = new int[sp.length()];
        pt[0] = -1;
        for (int i=1; i< sp.length(); i++) {
        	int j = pt[i-1];
        	char c = sp.charAt(i);
        	if (j+1 >= s.length()) j=pt[j];
        	while (j>=0 && c!=sp.charAt(j+1) ){
        		j = pt[j];
        	}
        	if (c== sp.charAt(j+1)) {
        		pt[i] = j+1;
        	}
        	else pt[i] = -1;

        	System.out.print(pt[i]);
        }
        
        //Delete the first part of s, since it is the same as the last part of p
        int pos = pt[sp.length()-1]+1;
        // The minimum length is s itself
        return p + s.substring(pos);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("aba"));
	}

}
