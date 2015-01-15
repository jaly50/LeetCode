/*
 * Leetcode 37  Reverse Words in a String 
 * date:2014/09/21
 * requirement:Given an input string, reverse the string word by word.
 */
public class ReverseWords {
	 public static String reverseWords(String s) {
		 StringBuilder t = new StringBuilder();
		 s = s.trim();
		 if (s.length() <1) return "";
		 String[] st = s.split(" ");
		 for (int i=st.length-1; i>=0; i--) {
			 if (st[i].length() >0)
			 t =t.append(st[i].trim()+" ");
		 }
		return t.toString().trim();
	        
	    }
	 public static void main(String[] args) {
		 String s = new String("the sky is blue");
		 System.out.println(reverseWords(s));
		 System.out.println(reverseWords("   ds ds    ew    "));
	 }

}
