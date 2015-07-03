public class Solution {
    // you need to treat n as an unsigned value
    //无符号数，只能用无符号位移和位运算，不能加减
    public int hammingWeight(int n) {
       int ans = 0;
       while ( n!=0) {
           ans += n &1;
           n = n >>> 1;
           
       }
       return ans; 
    }
    // using mark, 每位对齐
        public int hammingWeight(int n) {
       int mask = 1;
       int ans =0;
       for (int i=0; i<32; i++) {
           if ((n & mask) !=0) {
               ans+=1;
           }
           mask = mask <<1;
       }
       return ans;
    }
}
