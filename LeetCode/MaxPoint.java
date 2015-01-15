/*
 * LeetCode 51
 * Date: 2014/10/1
 * 有很多trick要注意：
 *   1. 用斜率算。要注意 垂直线和水平线的处理（要让他们不同）
 *   2. 要注意相同点的处理
 *   3. 要注意Java的除法
 *   4. 注意double的精度
 */
import java.math.BigDecimal;
import java.util.*;


public class MaxPoint {
	   public static int maxPoints(Point[] points) {
			double key;
			int max = 0;
			int same = 0,realmax = 0;
			Map<Double,Integer> map;
			if (points.length <=2) return points.length;
	        for (int i =0 ;i < points.length; i++) {
	        	map = new HashMap<Double, Integer>();
	
	        	same = 0;
	        	max = 0;
	        	
	        	for (int j=i+1; j< points.length; j++) {
	        		key = slant(points[i],points[j]);
	        		
	        		if ( (points[i].x == points[j].x) && (points[i].y == points[j].y)) {
	        		    same ++;
	        		    continue;
	        		}
	            	
	        		if (!map.containsKey(key)) {
	        			map.put(key,1);
	        		}
	        		else map.put(key, map.get(key)+1);
	        		if (max < map.get(key)) {
	        		   max = map.get(key); 
	        		}
	        		//System.out.println(map.toString()+"i="+i+"   j="+j +"  same =" +same);	
	        		
	        	}
	            realmax = Math.max(realmax, max+same+1);
	            map.clear();
	        }
	        return realmax;
	    }
		private static double slant(Point a, Point b) {
			// TODO Auto-generated method stub
			if (a.y- b.y == 0)  return 0.0000001;
			if ( a.x - b.x ==0 ) return 9999999;
			double key = (double)(a.y - b.y)/(double) (a.x -b.x);
			//System.out.println(a.y-b.y+" "+ (a.x-b.x) +" "+ key);
		    return key;
		}
	public static void main(String[] args) {
		BigDecimal s = new BigDecimal(234);
		s.setScale(3);
		System.out.println((double)0.00/(double)34.0);
		//System.out.println(s.divide(new BigDecimal(34)));
		Point a = new Point(84,250);
		Point b = new Point(0,0);
		Point c = new Point(1,0);
		Point d = new Point(0,-70);
		Point e = new Point(1,-1);
		Point f = new Point(21,10);
		Point[] points = new Point[]{a,b,c,d,d,e,f};
		System.out.println(maxPoints(points));
	}
}
