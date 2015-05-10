class TrieNode {
    // Initialize your data structure here.
	//有单词的地方就存string as item
	// if there is no word, we just keep children, and mark their prefix character
    TrieNode[] children = new TrieNode[26];
    String item;
    public TrieNode() {
        item = null;
        children = new TrieNode[26];
        
    }
        public TrieNode(String item) {
        this.item = item;
        children = new TrieNode[26];
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch:chs) {
            TrieNode newNode = cur.children[ch-'a'];
            if (newNode ==null)
            cur.children[ch-'a']= new TrieNode();
            cur = cur.children[ch-'a'];
        }
        cur.item = word;
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch:chs) {
             TrieNode newNode = cur.children[ch-'a'];
              if (newNode ==null) return false;
            cur = cur.children[ch-'a'];
        }
        return cur.item.equals(word);
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
         char[] chs = prefix.toCharArray();
          TrieNode cur = root;
        for (char ch:chs) {
             TrieNode newNode = cur.children[ch-'a'];
              if (newNode ==null) return false;
            cur = cur.children[ch-'a'];
        }
        return true;
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
