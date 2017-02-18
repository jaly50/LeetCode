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
}
