import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 73  Palindrome Partitioning 
 * date: 2014/10/12
 * ˼·�� list<Integer>��¼ǰ�����������ϵĻ���
 * dp.. s[i] ��¼��s[i-1]Ϊֹ�Ľⷨ
 *    List[i]��¼i֮ǰ�ĵ��ʵ�������ʼλ�ã�������һ��i-1)
 */
public class PalindromePartition {
public List<List<String>> partition(String s) {
     //��һ������¼���л���λ�� 
	//Ȼ�����..
	
	List<List<Integer>> mark = new ArrayList<List<Integer>>();
	List<Integer> pre = new ArrayList<Integer>();
	mark.add(pre);
	for (int i=0; i<s.length(); i++) {
		pre = new ArrayList<Integer>();
		mark.add(pre);
		//mark every single palindrome
		// mark.get(i) means the ith char in S's next palindromes's index
		mark.get(i).add(i+1);
		if ((i<s.length()-1)&&(s.charAt(i) == s.charAt(i+1))) explore(s,i,i+1,mark);
		if ((i<s.length()-2)&& (s.charAt(i) == s.charAt(i+2))) explore(s,i,i+2,mark);
	}
	List<String> path = new ArrayList<String>();
	List<List<String>> ans = new ArrayList<List<String>>();
	display(0,mark,s,path, ans);
	return ans;
    }
// print out
	private void display(int index, List<List<Integer>> mark, String s,
		List<String> path, List<List<String>> ans) {
	// TODO Auto-generated method stub
		if (index == s.length()) {
			ans.add(new ArrayList(path));
		}
		String part;
		int next;
		for (int i=0; i<mark.get(index).size(); i++) {
			next =mark.get(index).get(i);
			part = s.substring(index,next);
			path.add(part);
			display(next,mark,s,path,ans);
			path.remove(path.size()-1);
		}
	
}
	private void explore(String s, int i, int j, List<List<Integer>> mark) {
	// TODO Auto-generated method stub
	while (s.charAt(i) == s.charAt(j)) {
		i--;
		j++;
		mark.get(i+1).add(j);
		if ((i<0) || (j>=s.length())) break;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s="aabaaba";
      PalindromePartition p =new PalindromePartition();
      System.out.println(p.partition(s));
	}

}
