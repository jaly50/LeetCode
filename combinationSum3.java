/*
* Scarlett Chen
* 6/4/2015 Thu 2:14 PM
* Combination Sum III 
* Basic dfs
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n || k*9<n || k>9) return res;
        List<Integer> path = new ArrayList<Integer>();
        dfs(k,n,1,path, res);
        return res;
        
    }
    public void dfs(int k, int n, int idx, List<Integer> path, List<List<Integer>> res) {
        if (k==0 && n==0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=idx; i<10-k+1; i++) {
            if (k*i <=n && k*9>=n) {
            path.add(i);
            dfs(k-1, n-i, i+1, path, res);
            path.remove(path.size()-1);
            }
        }
    }
}
