/*
 * Author: Scarlett
 * LeetCode:Insert Interval 
 * date:11/29/2014 Sat 2:33 AM
 * 设(x,y)为newInterval, （a,b)为当前比较的interval
 * 要考虑的情况包括： (x<a,y<a);(x<a,a<y<b);(x<a,y>b);(a<x<b,a<y<b);(a<x<b,y>b);(x>b)
 * 一开始先把newinterval加进list里
 * 注意list不能边改边删，所以要复制list再进行遍历
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Be careful for the null list~~~!!
 * 要想清楚，要分情况！！
 */

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        intervals.add(0,newInterval);
	        List<Interval> copy = new LinkedList<Interval>(intervals);
	        Interval pre=newInterval;
	        for (int i=1; i<copy.size(); i++) {
	            Interval list = copy.get(i);
	            if (pre.start < list.start) {
	            	if (pre.end < list.start) {
	            		return intervals;
	            	}
	            	else if (list.start<=pre.end && list.end >=pre.end ) {
	            		list.start = pre.start;
	            		intervals.remove(pre);
	            		return intervals;
	            	}
	            	else if (pre.end > list.end) {
	            		intervals.remove(list);
	            		continue;
	            	}
	            }
	            else if (list.start<=pre.start && list.end>=pre.start) {
	            	if (list.start <=pre.end && list.end >=pre.end) {
	            		intervals.remove(pre);
	            		return intervals;
	            	}
	            	else if (pre.end >list.end) {
	            		pre.start = list.start;
	            		intervals.remove(list);
	            		continue;
	            	}
	            }
	            else if (pre.start > list.end) {
	            	int a = intervals.indexOf(pre);
	            	int b =intervals.indexOf(list);
	            	intervals.set(a, list);
	            	intervals.set(b, pre);
	            	continue;	
	            }
	            
	        }
	        return intervals;
	}
	           
	            	
	/*            	
	            	
	            	
	            	
	           pre = list;
	           //Begining of the newInterval is within the list
	        if (newInterval.start >=list.start && newInterval.start <=list.end ) {
	            if (newInterval.end<=list.end) return intervals;
	            left = list;
	        }
	        else 
	        //To delete a interval within the newInterval
	          if (newInterval.start <= list.start && newInterval.end >=list.end ) {
	              intervals.remove(list);
	        }
	        // The end of the newInterval in within the list
	        if (newInterval.end >=list.start && newInterval.end <=list.end ) {
	            list.start = left.start;
	            intervals.remove(left);
	            return intervals;
	        }
	        
	       }
	       if (intervals.size()!=0) {
	        Interval last = intervals.get(intervals.size()-1);
	       if (newInterval.start<=last.end && newInterval.end>last.end) {
	    	   last.end = newInterval.end;
	       }
	       else if (newInterval.start >=last.end)
	                          intervals.add(right);
	       
	       }
	       else intervals.add(0,left);
	       return intervals;
	    }
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		Interval newInterval = new Interval(6, 8);
		InsertInterval s = new InsertInterval();
		System.out.println(s.insert(intervals, newInterval));

	}

}
