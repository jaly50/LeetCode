/**
https://leetcode.com/contest/leetcode-weekly-contest-37/problems/task-scheduler/
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

**/
public class Solution {
    class Node{
        int key;
        int value;
        int next;
        Node(int key, int value, int next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] t_c = new int[26];
        for (char t: tasks) {
            t_c[t-'A']++;
        }
        Arrays.sort(t_c);

        //System.out.println(Arrays.toString(t_c));
        int[] pos = new int[26];
        PriorityQueue<Node> p = new PriorityQueue<Node>(26, new Comparator<Node>(){
            public int compare(Node n0, Node n1) {
                return n1.value - n0.value;
            }
        });
        for (int i=25; i>=0 && t_c[i]>0; i--) {
            p.add(new Node(i, t_c[i], 25-i+1));
            
        }
        Set<Integer> set =new HashSet<Integer>();
        int max=p.size();
        while (!p.isEmpty()) {
            Node ele = p.remove();
            int idx = ele.next;
            while (set.contains(idx)) idx++;
            set.add(idx);
            max = Math.max(max, idx);
            idx += n+1;
            ele.value--;
            ele.next = idx;
            if (ele.value>0) p.add(ele);
            
        }
        return max;
        
    }
}
