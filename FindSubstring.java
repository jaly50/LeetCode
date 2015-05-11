import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//第一反应是  l 全排列，然后s.isIndexOf(), it would be slow is l is long
//Best solution uses hashtable, and time complexity is<= s*len(l)


public class FindSubstring {
	/*
	 * @param: 
	 *   single: length of each word in L
	 *   total: total length of L
	 *   len: length of S
	 *   map: a dictionary map storing words in L
	 *   path: a map to record how many words in L has been visited
	 */
	 public List<Integer> findSubstring(String S, String[] L) {
	        int len = S.length();
	        int single = L[0].length();
	        int total = single *L.length;
	        Map<String,Integer> map = new HashMap<String, Integer>();
	        List<Integer> ans = new ArrayList<Integer>();
	        if (total >len) return ans;
	        for (String s:L) {
	          if (map.containsKey(s))
	        	  map.put(s, map.get(s)+1);
	          else map.put(s, 1);
	        }
	        Map<String,Integer> path = new HashMap<String, Integer>();
	        String word;
	        for (int i=0; i<len-total+1; i++) {
	            int cur = i;
	            path = new HashMap<String, Integer>();
	            while (cur - i < total) {
	            	word = S.substring(cur,cur+single);
	            	if (map.containsKey(word)) {
	            		if (path.containsKey(word))
	            			path.put(word, path.get(word)+1);
	            		else path.put(word, 1);
	            		if (path.get(word)> map.get(word)) break;
	       
	            	}
	            	else break;
	            	cur = cur+single;
	            }
	            if (cur-i >=total) ans.add(i);

	            }
	        return ans;
	        }
	        
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubstring fs = new FindSubstring();
		String s="abcddefdd";
		String[] l=new String[]{"bc","ef","dd","dd"};
		System.out.println(fs.findSubstring(s, l));
	}

}
