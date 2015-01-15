/*
 * LeetCode 116  Merge Intervals 
 * Date: 11/09/2014 Sun 1:52 AM
 * Knowledge: Comparator, inner class, arrayList
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeInterval {
    
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Interval> merge(List<Interval> intervals) {
	     List<Interval> list = new ArrayList<Interval>();  
	     Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.start, o2.start);
			}
	    	 
	     });
	     if (intervals.size()<1) return list;
	     list.add(intervals.get(0));
	     for (int i=1; i<intervals.size();i++) {
	    	 Interval last = list.get(list.size()-1);
	    	 Interval cur = intervals.get(i);
	    	if (last.end >= cur.start) {
	    		//Forgot some situation
	    		if (last.end >=cur.end) continue;
	    		Interval temp = new Interval(last.start,cur.end);
	    		list.set(list.size()-1, temp);
	    	}
	    	else list.add(cur);
	     }
	     return list;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
