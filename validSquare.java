//593. Valid Square
//Scarlett Chen, 5/20/2017 LeetCode weekly contest 33
//可以把复杂的问题简单化，具体的问题抽象化，概括化。真的是好厉害的能力。
// Try to simplify the complex, generalize the specific issue.
public class Solution {
    long dist(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) *(p2[0] - p1[0]) + (p2[1] - p1[1])*(p2[1] - p1[1]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    // 验证正方形的方式就是 四条相同的短边，2条相同长边。
    //  4 same short length and 2 same long length is the way to verify a square.
        long[] dists = new long[]{dist(p1,p2), dist(p1,p3), dist(p1,p4), dist(p2, p3), dist(p2, p4), dist(p3, p4)};
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // distance and number
        long min=dists[0], max=dists[0];
        for (long distance: dists) {
            int old_value = map.getOrDefault(distance, 0);
            map.put(distance, old_value+1);
            min = Math.min(min, distance);
            max = Math.max(max, distance);
        }
        if (map.get(min) !=4 || map.get(max) !=2 ) return false;
        return true;
        
    }
}
