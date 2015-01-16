/*
 * LeetCode 87 Triangle 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 最简单的动态规划。。
 * date: 2014/10/20
 */
import java.util.Arrays;
import java.util.List;


public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
	       int len = triangle.size();
	       int[] f = new int[len];
	       Arrays.fill(f,0);
	       List<Integer> list;
	       int min=Integer.MAX_VALUE;
	       for (int i=0; i<len; i++) {
	           list = triangle.get(i);
	           for (int j=list.size()-1; j>=0; j--) {
	               if ((j==list.size()-1)&& (j-1>=0)) f[j] = f[j-1];
	               f[j] +=list.get(j);
	               if (j-1>=0) f[j]=Math.min(f[j],f[j-1]+list.get(j));
	            if (i==len-1) min= Math.min(f[j],min);
	           }
	       }
	       return min;
	    }
	   public static void main(String[] args) {
		   Triangle t= new Triangle();
		   
	   }
}
