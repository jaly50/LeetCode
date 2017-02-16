public class Solution {
//433. Minimum Genetic Mutation 
    public int minMutation(String start, String end, String[] bank) {
        // 有点像 word ladder呀
        // bfs 广度优先搜索
        Set<String> bset = new HashSet<String>();
        for (String b: bank) bset.add(b);
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        bset.remove(start);
        String[] choice = new String[]{"A", "C", "G", "T"};
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int  a= 0; a < size; a++) {
            String cur = q.poll();
            if (cur.equals(end)) return count;
            for (int i=0; i<cur.length(); i++) {
              for (int j=0; j<choice.length; j++) {
                  String next = cur.substring(0, i) + choice[j] + cur.substring(i+1);
                  if (bset.contains(next)) {
                      q.add(next);
                      bset.remove(next);
                  }
              }
            }
            }
            count += 1;
        }
      return -1;  
    }
}
