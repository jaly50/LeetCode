import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Scarlett Chen
 * 336. Palindrome Pairs  
 * Wed 11:17 PM 10/26/2016
 * The most naive solution is  n^2*k, get any two word, and check whether they are palindrome
 * 
 */
public class PalindromePairs {
	   private boolean isPalindrome(String s) {
	        int i=0, j= s.length()-1;
	        if (s.length() < 2) return true;
	        while (i<j && s.charAt(i) == s.charAt(j)) {
	            i++;
	            j--;
	            
	        }
	        //System.out.println(s+" i: "+i+" j: "+j);
	        return i>=j;
	        
	    }
	    public List<List<Integer>> palindromePairs2(String[] words) {
	        // the most naive
	        int n = words.length;
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> path;
	        for (int i=0; i<n; i++) {
	            for (int j=0; j<n; j++) {
	                if (i==j) continue;
	                if (isPalindrome(words[i]+words[j])) {
	                    path = new ArrayList<Integer>();
	                    path.add(i);
	                    path.add(j);
	                    ans.add(path);
	                }
	            }
	        }
	       return ans; 
	    }
	    
	    public List<List<Integer>> palindromePairs(String[] words) {
	        // try to use n* k^2 solution
	        int n = words.length;
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> path;
	        String rev;
	        //String and the location
	        HashMap<String, Integer> map = new HashMap<String,Integer>();
	        for (int a=0; a<n; a++) {
	           map.put(words[a], a);
	        }
	        for (int a=0; a<n; a++) {
	            String word = words[a];
	            int len = word.length();
	            for (int i=0; i<= len; i++) {
	                //note, when i ==len, part2 will be empty
	                String part2 = word.substring(i);
	                String part1 = word.substring(0, i);
	                int len1 = part1.length();
	                int len2 = part2.length();
	                
	                String rev1 = new StringBuilder(part1).reverse().toString();
	                String rev2 =new StringBuilder(part2).reverse().toString();
	                // make sure part1 is not empty,
	                // when part1 is empty, we get the whole word, which will check later
	                if (isPalindrome(part1) && part1.length()>0) {
	                	if (map.containsKey(rev2) && map.get(rev2) !=a) {
	                		path = new ArrayList<Integer>();
	                        path.add(map.get(rev2));
	                        path.add(a);
	                        ans.add(path);
	                	}
	                }
	                //if part2 is empty, then rev1 is palindrome of part1
	                if (isPalindrome(part2) && (map.containsKey(rev1) && map.get(rev1) !=a)) {
	                		path = new ArrayList<Integer>();
	                        path.add(a);
	                        path.add(map.get(rev1));
	                        ans.add(path);
	                	}
	                }                  
	            }
	        return ans; 
	        }
	       

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
