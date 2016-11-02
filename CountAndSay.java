/*
 * LeetCode 107 Count and Say 
 * date: 11/4/2014 11:28PM
 * 题目不难，但做得太慢！
 */
public class CountAndSay {
	 public String countAndSay(int n) {
	        if (n==0) return "";
	        StringBuffer key=new StringBuffer("1"), pre=new StringBuffer("1");
	        int index, count;
	        char digit;
	        for (int i=1; i<n; i++) {
	           index = 0;
	           key = new StringBuffer("");
	           while (index < pre.length()) {
	               digit = pre.charAt(index);
	               count = 1;
	               while (index+1<pre.length() &&  pre.charAt(index) == pre.charAt(index+1)) {
	                   index++;
	                   count++;
	               }
	               key.append(String.valueOf(count));
	               key.append(digit);
	               
	               //forgot to add one!
	               index++;
	           }
	           pre = key;
	           //System.out.println(key);
	        }
	        return key.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CountAndSay cas = new CountAndSay();
       System.out.println(cas.countAndSay(15));
	}

}
