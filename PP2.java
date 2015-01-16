import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode 74  Palindrome Partitioning2
 * Date: 2014/10/13
 * 
 */
public class PP2 {
	public int minCut(String s) {
    
		if (s.length()<=1) return 0;
		// score[i] means till s[i],there is score[i] has been cut
		int[] score = new int[s.length()];
		for (int i=0; i<s.length(); i++) {
			score[i] = i;
		}
		for (int i=0; i<s.length(); i++) {
			if (i>0) score[i] = min( score[i], score[i-1]+1);
			if ((i<s.length()-1)&&(s.charAt(i) == s.charAt(i+1))) explore(s,i,i+1,score);
			if ((i<s.length()-2)&& (s.charAt(i) == s.charAt(i+2))) explore(s,i,i+2,score);
		}
		return score[s.length()-1];
    }
	private void explore(String s, int i, int j, int[] score) {
	// TODO Auto-generated method stub
	while (s.charAt(i) == s.charAt(j)) {
		i--;
		j++;
		//means s[0]~s[j-1] is a palindrome
		if (i<0) score[j-1] = 0;
		else score[j-1] = min(score[j-1], score[i]+1);
		//System.out.println("i+1="+ (i+1)+"  j-1=" + (j-1)+ Arrays.toString(score));
		if ((i<0) || (j>=s.length())) break;
	}
}
	private int min(int i, int j) {
		// TODO Auto-generated method stub
		return  i<j?i:j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    PP2 p = new PP2();
    String s = "aabaaba";
    System.out.println(p.minCut(s));
	}

}
