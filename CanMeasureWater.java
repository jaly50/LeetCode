/*
 * Scarlett Chen
 * Sat 12:56 PM 10/22/2016
 * 365. Water and Jug Problem
 * 灌水问题，只能用数学方法解决。看是否 是 两个罐子的最大公约数的倍数
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x+y) return false;
        if (z==x || z==y || z==x+y) return true;
        return z % gcd(x,y) == 0;
    }
    private int gcd(int x, int y) {
    	while (y!=0) {
    		int temp = x % y;
    		y = x;
    		x = temp;
    	}
    	return x;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
