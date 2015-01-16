import java.util.Arrays;


public class IsScramble {
	 public boolean isScramble(String s1, String s2) {
	        int len1 = s1.length();
	        int len2 = s2.length();
	        if (len1!=len2 || len1==0) return false;
	        if (s1.equals(s2)) return true;
	        char[] ch1 = s1.toCharArray();
	        char[] ch2 = s2. toCharArray();
	        Arrays.sort(ch1);
	        Arrays.sort(ch2);
	        s1 = String.valueOf(ch1);
	        s2 = String.valueOf(ch2);
	        if (s1.equals(s2)) return true;
	        else return false;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsScramble is = new IsScramble();
		System.out.println(is.isScramble("ab", "ba"));

	}

}
