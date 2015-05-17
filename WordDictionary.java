import java.util.HashSet;
import java.util.Set;
/*
 * Add and Search Word - Data structure design 
 * Tries
 * LeetCode 186 
 * 5/16/2015
 */

public class WordDictionary {
	class TrieNode {
	    // Initialize your data structure here.
		//Mark the end of a string as true to save time and space
		// if there is no word, we just keep children, and mark their prefix character
	    TrieNode[] children = new TrieNode[26];
	    boolean end;
	    public TrieNode() {
	        end = false;
	        children = new TrieNode[26];
	        
	    }

	}

	
	
         private TrieNode root = new TrieNode();
         
             public WordDictionary() {
        root = new TrieNode();
    }

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch:chs) {
            TrieNode newNode = cur.children[ch-'a'];
            if (newNode ==null)
            cur.children[ch-'a']= new TrieNode();
            cur = cur.children[ch-'a'];
        }
        cur.end = true;
	        
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
        char[] chs = word.toCharArray();
        return dfs(chs, 0, root);
	        
	    }
	    public boolean dfs(char[] chs, int index, TrieNode cur) {
	        if (cur ==null) return false;
	        if (index >=chs.length) 
	        	return cur.end;
	        char ch = chs[index];
	        if (ch!='.') {
	           return dfs(chs, index+1, cur.children[ch-'a']);
	        }
	        else {
	            boolean ans = false;
	            for (int i=0; i<26 && !ans; i++) {
	                ans =ans || dfs(chs, index+1, cur.children[i]);
	                
	            }
	            return ans;
	        }
	    }
	    public static void main(String[] args) {
	    	WordDictionary wordDictionary = new WordDictionary();
	     wordDictionary.addWord("word");
	     wordDictionary.addWord("at");
	     wordDictionary.addWord("and");
	     wordDictionary.addWord("an");
	     wordDictionary.addWord("add");
	 	System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search(".at"));
		
	    }
	    
	}


	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");