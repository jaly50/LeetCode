/*
 * LeetCode 75   Implement strStr() 
 * KMP算法:改进子串
 * Date: 2014/10/14
 * 
 */
public class StrImplementation {
	// The method embedded in java
	 public String strStr1(String haystack, String needle) {
	        int k = haystack.indexOf(needle);
	        if (k>=0) {
	            return haystack.substring(k);
	        }
	        else return null;
	    }
	 public String strStr(String haystack, String needle) {
	        int[] next = getNext(needle);
            if (needle.length()<1) return haystack;
	        if (needle.length()>haystack.length()) return null;
	        for (int i=0; i<haystack.length()-needle.length()+1; i++) {
	        	int s = i, p = 0;
	        	while (haystack.charAt(s) == needle.charAt(p)) {
	        		s++; p++;
	        		if (p==needle.length()) return haystack.substring(s-needle.length());
	        		if (s == haystack.length()) return null;
	        		while ((p>0) && (!(haystack.charAt(s) == needle.charAt(p))))  p = next[p];
	        		
	        	}
	        }
	        return null;
	    }
	 // make:  next[j] = next[k],  when  needle[0~~~k-1] = needle[j~~k, j-1]
	private int[] getNext(String needle) {
		// TODO Auto-generated method stub
		int[] next = new int[needle.length()+1];
		next[0] = -1;
		int k=-1,j=0;
		while (j<needle.length()) {
			if ((k==-1) || (needle.charAt(j) == needle.charAt(k))) {
				k++;
				j++;
				next[j] = k;
			}
			else k = next[k];
		}
		return next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrImplementation s = new StrImplementation();
		System.out.println(s.strStr("aaaabbbababb","ba"));
	}

}
