/*
 * LeetCode 33
 * author : Scarlett
 * date: 2014/9/18
 */
import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
	    List<Integer> innerList;
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        for (int i=0; i<numRows; i++) {
        	innerList = new ArrayList<Integer>(i+1);
            innerList.add(0,(Integer)1);
            if (i!=0) innerList.add((Integer)1);
            for (int j=1; j<i; j++) {
                innerList.add(j,(Integer)((list.get(i-1).get(j-1)) + (list.get(i-1).get(j))));
            }
            list.add(innerList);
        }
        return list;
        
    }
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
}
