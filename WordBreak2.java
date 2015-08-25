/**
 * Scarlett Chen, Aug 25th Tue 4:07 PM
 * Word Break 2
 * dp + backtracking : used dfs before
 * I wan na use bfs, using queue this time
 * 
 **/ 
public class Solution {
public List<String> wordBreak(String s, Set<String> wordDict) {
        // mark means next word position
        int len = s.length();
        List<List<Integer>> mark = new ArrayList<List<Integer>>();
        for (int i=0; i<len; i++) mark.add(new ArrayList<Integer>());
        for (int i=s.length(); i>=0; i--) {
            if (i<len && mark.get(i).isEmpty()) continue;
            for (int j=i-1; j>=0; j--) {
                if (wordDict.contains(s.substring(j,i))){
                    mark.get(j).add(i);
                }
            }
        }
        
        Queue<String> strings = new LinkedList<String>();
        
        List<String> ans = new ArrayList<String>();
        if (mark.get(0).isEmpty()) return ans;
        //using bfs to back tracking
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0); // initial situation
        
        String cur="";
        while (!que.isEmpty()) {
            int pos = que.poll();
            if (strings.isEmpty()) cur="";
            else cur = strings.poll()+" ";
            for (int i:mark.get(pos)) {
                if (i>=len) {
                    ans.add(cur+s.substring(pos, i));
                }
                else {
                strings.add(cur+s.substring(pos, i));
                que.add(i);
                }
            }
        }
        return ans;
        
        
    }
}
