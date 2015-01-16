/*
 * @author Scarlett
 * @date 2014/9/5
 * 
 */
public class NumTree {
	public static int numTrees(int n) {
		int answer =0;
		if (n==0) return 1;
		if (n==1) return 1;
		else if (n==2) return 2;

		for (int i=0; i<n; i++) {
			answer += numTrees(i) * numTrees(n-i-1);
		}
        return answer;
    }
	public static void main(String args[]) {
		System.out.println(numTrees(4));
	}
}
