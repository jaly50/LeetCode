/**
 * 1. o(n^2) brute force
 * 2. set<10-digit-string>, if contains, means more than once;  o(n)space, o(n) time
 * 3. multiply prime:  map<number, position>, lower the space complexity <ACGT to prime ==> small map?>
 * 4. bit malipulation: 1(01) 3(11) 7(111) 13(1010)  ==3 digit difference; 10 digit *3 = 30 smaller than integer length
 *     time complexity(o(n)) space(o(n)) map<integer, boolean>
 * Scarlett Chen
 * Fri 7:48 7/3/2015
 * 
 * 
 * */
 
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        //the 10-letter-long sequences (substrings) 
        if (len<=10) return res;
        int t = (s.charAt(0)-64) % 5;
        for (int i=1; i<len; i++) {
            // <<  level 6;  & level 9
             t = (t<<2 & 0xfffff)|((s.charAt(i)-64) % 5);
             // the length of dna is 10, so i need to >=9
             if (map.containsKey(t) && i>=9) {
               if (map.get(t)) {
                   res.add(s.substring(i-9,i+1));
                   // After add the ele
                   map.put(t,false);
               }  
             }
             else {
                 map.put(t,true);
             }
        }
      return res;  
    }
}
