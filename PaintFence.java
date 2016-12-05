public class Solution {
//276. Paint Fence
// Sun 8:11 PM, Scarlett Chen, 不知道为什么是easy,其实不好想到。以后要回头来看。
    public int numWays(int n, int k) {
        if (n==0 || k==0 || (k==1 && n>2)) return 0;
        if (n==1) return k;
        int same = k;
        int diff = k*(k-1);
        for (int i=2; i<n; i++) {
            int temp = diff;
            diff = (same + diff) * (k-1);
            same = temp;
        }
        return diff+same;
        
    }
}
