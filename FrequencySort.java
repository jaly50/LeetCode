//Scarlett Chen, Tue 9:13 AM, Nov 22, 2016
public class Solution {
    //最好的方法就是排序，可以建一个class
    class Wc implements Comparable<Wc> {
        char word;
        int count;
        Wc(char word, int count) {
            this.word = word;
            this.count = count;
        }
        public int  compareTo(Wc that) {
            return that.count - this.count;
        }

    }
    public String frequencySort(String s) {
        int[] counts = new int[256];
        for (char ch: s.toCharArray()) {
            counts[ch]++;
        }
        List<Wc> list = new ArrayList<Wc>();
        for (int i=0; i<256; i++) {
            if (counts[i] >0) {
                Wc wc =new Wc((char)i, counts[i]);
                list.add(wc);
            }
        }
        Collections.sort(list);
        StringBuilder st = new StringBuilder();
        for (Wc wc: list) {
            for (int i=0; i<wc.count; i++)
            st = st.append(wc.word);
        }
        return st.toString();
    }
}
