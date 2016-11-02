/*
 * Scarlett Chen
 * Mon 9:39 PM 10/31/2016
 * 436. Find Right Interval
 * 最naive method is n^2, for each interval, to find the minimum 
 */
package LeetCode;

import java.util.TreeMap;

public class FindRightInterval {
	// 83ms Using TreeMap
    public int[] findRightInterval(Interval[] intervals) {
        // start position
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = intervals.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            map.put(intervals[i].start, i);
        }
        for (int i=0; i<n; i++) {
            Integer tmp =  map.ceilingKey(intervals[i].end);
            res[i] = tmp == null ? -1:(int)tmp;
        }
       return res; 
    }
	// Time Limit Exceeded 
    public int[] findRightInterval1(Interval[] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            int min_pos = -1 , min_start = Integer.MAX_VALUE;
            for (int j=0; j<n; j++) {
                if (intervals[j].start < intervals[i].end) continue;
                if (intervals[j].start < min_start) {
                    min_start = intervals[j].start;
                    min_pos = j;
                }
            }
            res[i] = min_pos;
        }
       return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
