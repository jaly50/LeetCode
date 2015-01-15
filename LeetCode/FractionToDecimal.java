import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
 * LeetCode 163 Fraction to Recurring Decimal
 * @author : Scarlett chen
 * @date: 12/28/2014 Sun 8:10 PM
 * 需要注意的地方：符号， 整数部分为零的时候符号
 * 极值情况 如 -2147483648 的余数，商 都有可能超过整数范围
 * 【最后一道leetCode  好激动！任务圆满完成！
 */


public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
    	long remainder, num;
    	// the long is for :fractionToDecimal(-2147483648,-1)
    	long intPart = (long)numerator/ denominator;
    	remainder = numerator % denominator;
    	if (remainder ==0) return String.valueOf(intPart);
    	//if the ans is not zero, the sign has already been given.
    	StringBuffer ans = new StringBuffer(String.valueOf(intPart));
    	ans.append('.');
    	
    	long fractionPart = 0;
    	
    	//consider the zero situation
    	if (Math.signum(remainder)*Math.signum(denominator) <0 && intPart==0) ans.insert(0, "-");
    	remainder = Math.abs(remainder);
    	//the long is for  fractionToDecimal(-1,-2147483648)
    	long den = Math.abs((long)denominator);
    	 Map<Long,Integer> map = new HashMap<Long,Integer>();
    	while (remainder!=0) {
    		map.put(remainder,ans.length());
    		num = remainder * 10;
    		fractionPart = num / den;
    		remainder = num % den;
    		ans.append(fractionPart);
    		if (map.containsKey(remainder)) {
    			ans.append(')');
    			ans.insert(map.get(remainder), "(");
    			return ans.toString();
    		}
    		
    	}
        return ans.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(fractionToDecimal(-2147483648,-1));
	}

}
