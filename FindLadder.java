import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/*
 * LeetCode 71 Word Ladder 2
 * Date: 2014/10/11
 * 花了很长时间debug!追踪小错误..
 * 好多map..因为要以string为index,就不得不用map.所以用了好多高级的数据结构！就觉得有点乱
 * 本质是图题：
 * 用的bfs+ 存储路径和 追踪路径
 * 对于List而言，作为传入参数，引入的是reference而非value,所以在新的method里改变value时，原来的那个reference里的内容也会变哦！
 */

public class FindLadder {
	/*
	 * Dist: Store the shortest distance from start point
	 * start: start point
	 * end: end point
	 * dict: start.....end point,stores points in the path
	 * map: store the previous points which lead to the current point as the shortest path
	 * que: stores points who already connected the start points
	 * 
	 */
	 public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		 List<List<String>> ans = new ArrayList<List<String>>();
		 List<String> path = new ArrayList<String>();
		 if (start == end) {
			 path.add(start);
			 ans.add(path);
			 return ans;
		 }
		 Map<String,List<String>> map = new HashMap<String,List<String>>();
				
			Queue<String> que = new LinkedList<String>();
			que.add(start);
			dict.add(end);
			//Map stores paths coming that point
			Map<String, Integer> dist = new HashMap<String, Integer>();
			dist.put(start, 1);
			String point;
			Set<String> words;
			while (!que.isEmpty()) {
				point = que.poll();
				words =dif(point, dict);
				for (String s: words) {
					if (!dist.containsKey(s)) {
							dist.put(s, dist.get(point) + 1);
							path = new ArrayList<String>();
							path.add(point);
							
							map.put(s,path);
							//System.out.println("point:  "+point+ " relate words:" +words);
						//System.out.println("dist:" +dist);
						//	System.out.println("map: "+map);
							que.add(s);
					}
					else {
						if (dist.get(s) == dist.get(point)+1) {
							path = map.get(s);
							path.add(point);
						}
						else if (dist.get(s) < dist.get(point)+1) {
							if (s.equals(end))  
								return getAnswer(map,start,end);
						}
					}
				}

			}
			if (dist.containsKey(end)) return getAnswer(map,start,end);
			else return ans;   
	    }
	private static List<List<String>> getAnswer(Map<String, List<String>> map,
			String start, String end) {
		// TODO Auto-generated method stub
		List<String> path = new LinkedList<String>();
		List<List<String>> ans = new ArrayList<List<String>>();
		//System.out.println("map: "+map);
		getAnswer(map,start,end,path,ans);
		
		return ans;
	}
	private static void getAnswer(Map<String, List<String>> map, String start,
			String end, List<String> path, List<List<String>> ans) {
		// TODO Auto-generated method stub
		if (start == end) {
			path.add(0,end);
			//System.out.println(path);
			ans.add(new LinkedList<String>(path));
			path.remove(end);
			return;
		}
		List<String> list = map.get(end);
		path.add(0,end);
		for (int i=0; i<list.size();i++) {
		  String connect = list.get(i);
		  getAnswer(map,start,connect,path,ans);
		}
		path.remove(end);
		
	}
	private static Set<String> dif(String point, Set<String> dict) {
		// TODO Auto-generated method stub
		String test;
		Set<String> result = new HashSet<String>();
		for (int i=0; i<point.length(); i++) {
			for (char c='a'; c<='z'; c++) {
				if (c != point.charAt(i)) {
				test = point.substring(0,i)+c+point.substring(i+1);
				if (dict.contains(test)) {
					result.add(test);
				}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		dict.add("hog");
		//System.out.println(ladderLength("hot", "dog", dict));
		System.out.println(findLadders("hot", "dog", dict));
	}

}
