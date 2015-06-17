// Scarlett Chen 6/17/2015 Wed 1:50 pm
// Bit manipulation
// 都得转long
public class Solution {
    public int mySqrt(int x) {
        if (x<=0) return 0;
        long ans=0;
        int bit= 1 <<16;
        while (bit >0) {
            ans |=bit;
            if (ans * ans > x) {
                ans ^=bit;
            }
            bit >>=1;
        }
        return (int)ans;
    }
}
