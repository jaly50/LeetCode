/*
 * LeetCode 141 Wild Card
 * Author: Scarlett Chen
 * Time: 12/13/2014 Sat 10:17 PM
 * 二十天以前不会写，参考了别人的答案。
 * 今天用那个dp的思路。发现还有很多细节需要注意
 */
import java.util.HashMap;
import java.util.Map;
//https://oj.leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
public class Wildcard {
	 public boolean isMatch(String s, String p) {
	       int len1 = s.length();
	       int len2 = p.length();
	       int j=0;
	       int i=0;
	       int prej=-1, prei=0;
	       // p串是零的情况
	       if (len1!=0 && len2==0) return false;
	       while (i<len1) {
	           char cs = s.charAt(i);
	           char cp;
	           //直接不匹配 没有＊号的情况
	           if (j==-1) return false;
	           if (j<len2) cp = p.charAt(j);
	           else  cp = ' ';
	           if (cs==cp || cp=='?') {
	               i++;
	               j++;
	           }
	           else if (cp=='*') {
	               prej = j;
	               prei = i;
	               j++;
	               
	           }
	           else {
	             j = prej;
	             i = ++prei;
	           }
	       }
	       //注意这里不只一个值要注意，要看看是不是后面都是＊号，才能放过它。
	       while (j<len2) {
	    	  if (p.charAt(j)=='*') j++; else return false;
	    	  
	       }
	      
	      return true;  
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wildcard w = new Wildcard();
		System.out.println(w.isMatch("aa","aa"));// true
		System.out.println(w.isMatch("aa","a"));//false
		System.out.println(w.isMatch("aaa","aa"));//false
		System.out.println(w.isMatch("aa", "*") +" should be true");
		System.out.println(w.isMatch("ab", "?*"));//true
		System.out.println(w.isMatch("hi", "*?"));
		System.out.println(w.isMatch("b", "?*?")+" = false");
	}
	
	
	public boolean isMatch_fail(String s, String p) {
        //without *
        if (p.indexOf('*')==-1) {
             //check whether they have same length
             if (s.length()!=p.length()) return false;
             for (int i=0; i<s.length(); i++) {
                 if (s.charAt(i)!=p.charAt(i) && p.charAt(i)!='?') return false;
             }
             return true;
        }
        //with *

             //HashMap:  
             Map<Character,Integer> map = new HashMap<Character, Integer>();
              for (int i=0; i<s.length();i++) {
                  char ch = s.charAt(i);
                  if (map.containsKey(ch) ) {
                   map.put(ch,map.get(ch)+1);
               }
               else map.put(ch,1); 
             }
                 for (int i=0; i<p.length(); i++) {
                 char ch = p.charAt(i);
                  if (ch=='*') continue;
                  // improve 2: is p has any character which s doesn't have?
                  if (!map.containsKey(ch) ) {
                      return false;
                  }
                  //  improve 1: is p.length()>s.length() ? (length does not include *)
                  else {
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch)<0) return false;
                  }
                   
               }
              // then search * from (i,p.length) on behalf of length=p.length-i
               int i=0, j=0;
               while (i<s.length()) {
            	   if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
		                j++; 
		                i++;
		                continue;
		            }
            	   else if (s.charAt(i)!=p.charAt(j) && p.charAt(j)!='*') return false;
            	   char ch = p.charAt(j);
            	   // ch == '*'
            	   String right = p.substring(j+1);
            	   for (int x = i; x< p.length()-j; x++){
            		   String left = s.substring(x+1);
            		   if (isMatch(left,right)) return true;
            	   }
            	   return false;
            	   
               }
      
       return false;
          
    }


}
