/*
 * LeetCode 70   Word Ladder 
 * Date: 2014/10/11
 * ���˺þã��������accept�˺ü�����
 * ��bfs�Ϳ����������ˡ�������һ��ʼ����bfs��ôд�ˣ�
 * ��ȥ�о���dijsktra�㷨��
 * С�Ż��� ��������ʵ�����һ�����ʣ����� ������һ�����ʵĿ����� : Time =word.length * 26
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	
	public static int ladderLength(String start, String end, Set<String> dict) {
		if (start == end)
			return 1;
		Queue<String> que = new LinkedList<String>();
		que.add(start);
		dict.add(end);
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
						que.add(s);
						if (s.equals(end)) {
							return dist.get(s);
						}
				}
			}

		}
		return 0;
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

	private static boolean diff1(String start, String end) {
		for (int i = 0; i < start.length(); i++) {
			if (!(start.charAt(i) == end.charAt(i))) {
				return (start.substring(0, i).equals(end.substring(0, i)) && (start
						.substring(i + 1).equals(end.substring(i + 1))));
			}
		}
		return false;
	}
//�Լ��õ���ֵ�dijsktra�㷨�������������ֺ���̫�б�Ҫ
	public static int ladderLength_TimeExceedLimit(String start, String end,
			Set<String> dict) {
		if (start == end)
			return 1;
		if (diff1(start, end))
			return 2;
		// dict.add(start);
		// dict.add(end);
		Iterator<String> it = dict.iterator();
		int n = dict.size() + 2;
		String[] graph = new String[n];
		int index = 0;
		graph[index] = start;
		// ��ͼ O(n)
		while (it.hasNext()) {
			graph[++index] = it.next();
		}
		graph[++index] = end;

		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);
		visit[0] = true;
		List<Integer> s = new ArrayList<Integer>();
		// Set<Integer> s = new HashSet<Integer>();
		s.add(0);
		boolean[][] connect = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (diff1(graph[i], graph[j])) {
					connect[i][j] = true;
					connect[j][i] = true;
				} else {
					connect[i][j] = false;
					connect[j][i] = false;
				}
			}
		}
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			if (connect[0][i]) {
				dist[i] = 1;
				s.add(i);
			} else
				dist[i] = Integer.MAX_VALUE;
		}
		index = 0;
		int i = 0;
		while (index < s.size()) {
			i = s.get(index);
			if (!visit[i]) {
				for (int j = 1; j < n; j++) {
					if (connect[i][j]) {
						dist[j] = Math.min(dist[j], dist[i] + 1);
						s.add(j);
						if (j == n - 1)
							return dist[j] + 1;
					}
				}
				visit[i] = true;
			}
			index++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		//System.out.println(ladderLength("hit", "cog", dict));
		// System.out.println(diff1("cakeqd", "cakead"));
		dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		dict.add("hog");
		System.out.println(ladderLength("hot", "dog", dict));
		//System.out.println(findLadders("hot", "dog", dict));
	}

}

/*
 * ���ϵı����� Set<String> set = new HashSet<String>(); Iterator<String> it =
 * set.iterator(); while (it.hasNext()) { String str = it.next();
 * System.out.println(str); }
 * 
 * 2.forѭ�������� for (String str : set) { System.out.println(str); }
 */