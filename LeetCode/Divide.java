/*
 * LeetCode 85  Divide Two Integers 
 * Divide two integers without using multiplication, division and mod operator.
 * Date: 2014/10/18
 * 直接/可以过
 * 用减法会TLE
 * best:减法+位操作  log(n)
 * 如果不能用long的话，可以对int的极值进行处理一下。。 就是min_int 先处理掉一个divisor,然后结果加一个offset就行
 */
public class Divide {
	
	public static int divide(int dividend, int divisor) {
		// Notice here.. 
		//abs should firstly turn it into Long, otherwise the min_int would overflow
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		  boolean sign = (dividend >0) ^ (divisor >0); 
		long c,ans=0;
		while (a>=b) {
			c =  b;
			for (int i=0; a>=c; i++, c<<=1) {
				a -= c;
				ans +=1<<i;
			}
		}
		if (sign) return (int) (-ans);
		else return (int) ans;
	}
	//minus --TLE
	 public static int divideTLE(int dividend, int divisor) {
		 int ans = 0;
		 System.out.println(dividend/divisor);
	        boolean sign = (dividend >0) ^ (divisor >0); 
	        dividend = Math.abs(dividend);
	        divisor = Math.abs(divisor);
	        while (dividend >= divisor) {
	            dividend -= divisor;
	            ans ++;
	        }
	        return sign? -ans:ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(divide(-2147483648, 1));
	}

}
