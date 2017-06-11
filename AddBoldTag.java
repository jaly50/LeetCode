/**
https://leetcode.com/contest/leetcode-weekly-contest-36/problems/add-bold-tag-in-string/
Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

**/
public class Solution {
    public String addBoldTag(String s, String[] dict) {
        // change string[] to dict
        // Store Intervals
        List<int[]> intervals = new ArrayList<int[]>();
        for (String word:dict){
           int idx = -1;
           while (true) {
               idx = s.indexOf(word, idx+1);
               if (idx <0) break;
               intervals.add(new int[]{idx, idx+word.length()}); // exclusive
           } 
        }
        Collections.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                if (i1[0] !=i2[0]) return i1[0]-i2[0];
                return i1[1] - i2[1];
            }
        });
        // merge Intervals
        if (intervals.size() < 1) return s;
        StringBuffer res = new StringBuffer(s.substring(0, intervals.get(0)[0]));
        intervals.add(new int[]{s.length(), s.length()});
        int idx = 0;
        while (idx < intervals.size()-1) {
            int begin = idx;
            int s_end = intervals.get(idx)[1];
            while (idx+1 < intervals.size() && s_end >= intervals.get(idx+1)[0]) {
                idx++;
                s_end = Math.max(s_end, intervals.get(idx)[1]);
            }
            //System.out.println(idx+" "+intervals.get(idx)[1]);
            res.append("<b>"+s.substring(intervals.get(begin)[0], s_end)+"</b>");
            if (idx+1 < intervals.size()) 
                res.append(s.substring(intervals.get(idx)[1], intervals.get(idx+1)[0]));
            idx++;
        }
        //res.append(s.substring(intervals.get(idx-1)[1]));
        return res.toString();
    }
}
