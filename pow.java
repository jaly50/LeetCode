//Scarlett Chen
// 6/14/2015
// Binary search
// It can also solved by recursive :  return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
public class Solution {
    public double myPow(double x, int n) {
        double ans =1;
        // deal with negative number
        if (n<0) {
            x = 1/x;
            n = -n;
        }
        while (n!=0) {
            
            if (n%2!=0) ans = ans *x;
            n = n/2;
            x = x*x;
        }
        return ans;
        
    }
}
