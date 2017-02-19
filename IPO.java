public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 首先找到all capital which smaller than current ones, then pick one with the most profit 
        // Above:k*n Time Limit Exceeded 50000 data 502. IPO
        // The other option: 用priority queue找到满足当前Capitial的最大profit
        int n = Capital.length;
        boolean[] visited = new boolean[n];
        for (int i=0; i<k; i++) {
            int max_p = 0;
            int max_idx = -1;
            for (int j=0; j<n; j++) {
               if (Capital[j] <= W && max_p < Profits[j] && !visited[j]) {
                   max_p = Profits[j];
                   max_idx = j;
               } 
            }
            if (max_idx < 0) return W;
            W += max_p;
            visited[max_idx] = true;
        }
        return W;
        
    }
    
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 首先找到all capital which smaller than current ones, then pick one with the most profit 
        // Above:k*n Time Limit Exceeded 50000 data
        // The other option: 用priority queue找到满足当前Capitial的最大profit
        // priority Queue complexity: nlogn
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a,b) -> (b[1] - a[1]));
        int n = Capital.length;
        for (int i=0; i<n; i++) pqCap.add(new int[]{Capital[i], Profits[i]});
        for (int i=0; i<k; i++) {
              while (!pqCap.isEmpty()) {
                  int[] pair = pqCap.peek();
                  if (pair[0] <= W) {
                      pqPro.add(pqCap.poll());
                  }
                  else break;
              }
              if (!pqPro.isEmpty()) {
                  int[] pair = pqPro.poll();
                  W += pair[1];
              }
              else return W;
        }
        return W;
        
    }
}
