import java.util.ArrayList;
import java.util.List;
/*
 * LeetCode 72  Pascal's Triangle II 
 * 其实用Array也行..代码更简单，反正capacity是预设的！
 * 很简单的一道题 (*￣︶￣)y
 * date: 2014/10/11
 * Requirement:Given an index k, return the kth row of the Pascal's triangle.
 */

public class PascalTriangle2 {
	public static List<Integer> getRow(int rowIndex) {
	     List<Integer> list = new ArrayList<Integer>(rowIndex+1);
	     list.add(1);
	     for (int i=1; i<=rowIndex; i++) {
	         list.add(i,1);
	         for (int j=i-1; j>0; j--) {
	             list.set(j, list.get(j)+list.get(j-1));
	         }
	     }
	     return list;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(getRow(4));
	}

}
