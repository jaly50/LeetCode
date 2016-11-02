/*
 * Author: Scarlett
 * Date: 11/21/2014 Fri 11:12 PM
 * LeetCode: 110  Anagrams 
 * thought: HashMap
 * If only using HashMap, it will TLE. Since map[i].equals(map[j]) cost m time. (m is the length of a string)
 * Way to improve: To calculate total ASCii in one String, check whether TotalASCII[i]==totalASCII[b], it only cost 1 time.
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Same length? Duplicated group with different length? First step is to clarify the scope.
//TLE QAQ 是不是str如果按长度排序，就可以再少点time consuming
public class Anagrams {
	public List<String> anagrams_buxiele(String[] strs) {
		 List<String> list = new ArrayList<String>();
		 return list;

	}
	public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
		Arrays.sort(strs,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if (o1.length()<o2.length())  return -1;
				else if (o1.length()>o2.length()) return 1;
				return 0;
			}});
		
        int len = strs.length;
        
        //To reduce time, judging whether they are same total accil QAQ
        //it works!!! GREAT!!!!!
        int[] totalAC = new int[len];
        Arrays.fill(totalAC, 0);
        
        //Make every String a map
        Map<Character,Integer>[] map =new HashMap[len];
        for (int i=0; i<len; i++) {
           map[i] = new HashMap<Character,Integer>(); 
           char[] s =strs[i].toCharArray();
           for (char ch:s) {
        	   totalAC[i] += ch-'0';
        	   if (map[i].containsKey(ch) ) {
                   map[i].put(ch,map[i].get(ch)+1);
               }
               else map[i].put(ch,1); 
           }
        }
        //Try some methods to reduce consuming time QAQ 
        //Mark strings which are already in the groups
        boolean[] mark = new boolean[len];
        Arrays.fill(mark, false);
        
        
        
        // To detect whether they are anagrams by compare map
        for (int i=0; i<len; i++) {
        	if (!mark[i])
            for (int j=i+1; j<len; j++) {
                if (strs[i].length()!=strs[j].length()) break;
                if (totalAC[i] !=totalAC[j]) continue;
                if (map[i].equals(map[j])) {
                	 if (!mark[i])  list.add(strs[i]);
                    list.add(strs[j]);
                    mark[i] = true;
                    mark[j] = true;
                }
            }
        }
        return list;
    }
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		String[] strs = new String[]{"dog","cat","god","tac"};
		System.out.println(a.anagrams(strs));
	}

}
