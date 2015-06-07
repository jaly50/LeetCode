public class Solution {
    // Scarlett Chen sat 7:52 pm 6/6/2015 - sat 10:43 pm
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        // store <Sorted String, original String>
        Map<String, String> map = new HashMap<String, String>();
        for (String str:strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sorted = chs.length<1? "":Arrays.toString(chs);
            if (map.containsKey(sorted)) {
                res.add(str);
                String yes = map.get(sorted);
                // !='+' means never added the first one
                if (yes.length()<1||yes.charAt(0)!='+') {
                    res.add(yes);
                    // It means the first one has been added, we will not add it again
                    map.put(sorted,"+");
                }
            }
            else map.put(sorted,str);
        }
        return res;
        

}
}
