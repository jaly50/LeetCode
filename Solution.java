<<<<<<< HEAD
package leetcode;

//thoughts: split by 3 digits(int->String); give the title from right to left, t=O(n) s=o(n)
public class Solution {
    static final String[] title = new String[]{" Billion ", " Million ", " Thousand ", ""};
    static final String[] basic = new String[]{" Zero", " One", " Two", " Three", " Four", 
    										   " Five", " Six", " Seven", " Eight", " Nine",
    										   " Ten", " Eleven", " Twelve", " Thirteen", 
    										   " Fourtean", " Fifteen", " Sixteen", " Seventeen", 
    										   " Eighteen", " Nineteen", " Twenty"};
    static final String[] tens = new String[] {"", " Ten", " Twenty", " Thirty", " Forty", 
    										   " Fifty", " Sixty", " Seventy", " Eighty", 
    										   " Ninety"};
    public String numberToWords(int num) {
        if (num==0) return "Zero";
        String words = "";
        int digit = 3;
        while (num >0) {
            if (num %1000 !=0) {
                words =help(num % 1000) + title[digit] + words;
            }
        }
        return words.trim();
    }
    public String help(int num){
        if (num==0) return "";
        if (num <= 20) return basic[num];
        if (num < 100) return tens[num / 10] + help(num % 10);
        return basic[num/100] + " Hundred" + help(num % 100);
    }
}
=======
/*
 * LeetCode 10,11,12
 * @author Scarlett
 * @date 2014/9/7
 * 注意static用完后要清零；或者每次使用前要清零。否则数据还是上一个object留下的。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public static int ladderLength(String start, String end, Set<String> dict) {
		if (start == end)
			return 1;
		if (diff1(start, end))
			return 2;
		Queue<String> que = new LinkedList<String>();
		que.add(start);
		dict.add(end);
		Map<String, Integer> dist = new HashMap<String, Integer>(
				dict.size() + 1);

		String point;
		while (!que.isEmpty()) {
			point = que.poll();
			for (String s : dict) {
				if (!dist.containsKey(s)) {
					if (diff1(point, s)) {
						dist.put(s, dist.get(point) + 1);
						que.add(s);
						if (s.equals(end)) {
							return dist.get(s);
						}
					}
				}
			}

		}
		return 0;
	}

	private static boolean diff1(String start, String end) {
		// TODO Auto-generated method stub
		for (int i = 0; i < start.length(); i++) {
			if (!(start.charAt(i) == end.charAt(i))) {
				return (start.substring(0, i).equals(end.substring(0, i)) && (start
						.substring(i + 1).equals(end.substring(i + 1))));
			}
		}
		return false;
	}

	static ArrayList list = new ArrayList();
	static Stack s;

	public static List<Integer> inorderTraversal(TreeNode root) {
		list = new ArrayList();
		traverse(root);
		return list;
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		list = new ArrayList();
		s = new Stack();
		while ((root != null) || (!s.empty())) {
			while (root != null) {
				list.add(root.val);
				s.push(root);
				root = root.left;
			}
			if (!s.empty()) {
				root = (TreeNode) s.pop();
				root = root.right;
			}

		}
		return list;
	}

	private static void traverse(TreeNode root) {
		if (root != null) {
			traverse(root.left);
			list.add(root.val);
			traverse(root.right);
		}
	}

	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 */
	public static List<List<Integer>> threeSum(int[] num) {
		list = new ArrayList();
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; (j < num.length - 1); j++) {
				for (int k = j + 1; (k < num.length); k++) {
					if (num[i] + num[j] + num[k] == 0)
						list.add(new int[] { num[i], num[j], num[k] });
				}
			}
		}
		return list;

	}

	public static void main(String args[]) {
		// TreeNode tree = new TreeNode(1);
		// tree.left = new TreeNode(2);
		// tree.right = new TreeNode(4);
		// System.out.println(preorderTraversal(tree));
		ArrayList lt = (ArrayList) threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		System.out.println();
		for (int i = 0; i < lt.size(); i++) {
			System.out.println(((Arrays) lt.get(i)));
		}
	}
}
>>>>>>> 9e167c55d864cf3146ad28826cc342c1157a4669
