//481. Magical String  2/22/2017
// 主要是array manipulation吧..
public class Solution {
    public int magicalString(int n) {
        if (n<1) return 0;
        if (n<=3) return 1;
        int[] f = new int[n];
        f[0] = 1; f[1] = 2; f[2] = 2;
        int idx = 2, cur = 3, num = 1, count = 1;
        while (cur < n) {
            for (int i=0; i<f[idx]; i++) {
                f[cur] = num;
                if (num==1 && cur < n) count++;
                cur++;
                if (cur == n) return count;
            }
            idx++;
            num = num ^ 3;
        }
        return count;
    }
}
