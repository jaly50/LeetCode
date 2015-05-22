/*
 * LeetCode 212 Word Search II
 * 5/21/2015
 * Using Trie
 */
import java.util.ArrayList;
import java.util.List;



public class FindWords {
	 public List<String> findWords(char[][] board, String[] words) {
	       Trie tree = new Trie();
	       for (String s: words) {
	    	   tree.insert(s);
	       }
	       List<String> ans = new ArrayList<String>();
	       int n = board.length;
	       int m = board[0].length;
	       boolean[][] visited  = new boolean[n][m];
	       for (int i=0; i<n; i++) {
	    	   for (int j=0; j<m; j++) {
	    		   dfs(board, i,j,tree.root, visited,ans);
	    		  
	    	   }
	       }
	       return ans;
	       
	    }
	 private void dfs(char[][] board, int i, int j, TrieNode root,boolean[][] visited, List<String> ans) {
		 if (i<0 || i>=board.length || j<0 || j>=board[0].length) return;
		 if (visited[i][j]) return;
		 TrieNode cur = root.children[board[i][j]-'a'];
		if (cur!=null) {
			visited[i][j] = true;
			if (cur.item!=null) {
				ans.add(cur.item);
				cur.item = null;
				// No return; Because there could be anther words with prefix of this word
			}
			
			dfs(board, i+1, j, cur, visited, ans);
			dfs(board, i-1, j, cur, visited, ans);
			dfs(board, i, j+1, cur, visited, ans);
			dfs(board, i, j-1, cur, visited, ans);
			
			visited[i][j] = false;
		}
		
	}
	class TrieNode{
		 TrieNode[] children = new TrieNode[26];
		 String item = null;
		 
		  public TrieNode() {
			  children = new TrieNode[26];
			  item = null;
		  }
	 }
	 class Trie{
		 TrieNode root;
		 public Trie() {
			 root = new TrieNode();
		 }
		 public void insert(String s) {
			char[] chs  = s.toCharArray();
			TrieNode cur = root;
			for (char ch:chs) {
				TrieNode newNode = cur.children[ch-'a'];
				if (newNode ==null)
						cur.children[ch-'a'] = new TrieNode();
				cur = cur.children[ch-'a'];
				
			}
			cur.item = s;
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 FindWords fw = new  FindWords();
		
	}

}
