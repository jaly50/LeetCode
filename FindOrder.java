import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode 185
 * 5/16/2015
 * Course Schedule II 
 * 	There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * **Referring Discuss
 * Thoughts: Inlink of PostCourses, Set[] for Precourses, visited--mark whether has been sorted, Topological sort
 * time complexity: o(n^2)
 * space complexity: o(n^2)
 * 
 */
public class FindOrder {
    @SuppressWarnings("unchecked")
   
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	
    	int[] inlink = new int[numCourses];
    	Arrays.fill(inlink, 0);
    	Set<Integer>[] nextCourses = new Set[numCourses];
    	//initialize those sets
    	for (int i=0; i<numCourses; i++) {
    		nextCourses[i] = new HashSet<Integer>();
    	}
    	//Intialize the inlink(record pres) and sets(mark nexts)
    	int next, pre;
        for (int[] pair: prerequisites) {
            next = pair[0];
            pre = pair[1];
            //Error Once: It is to prevent duplicate pair
            if (!nextCourses[pre].contains(next)) {
            inlink[next]++;
            nextCourses[pre].add(next);
            }
        }
        //mark whether it is vsited
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);
        int[] ordering = new int[numCourses];
    	int pointer=0;
    	int prev = pointer;
    	while (pointer < numCourses) {
    		prev = pointer;
    		for (int i=0; i<numCourses; i++) {
    			if (inlink[i]==0 && !visited[i]) {
    				ordering[pointer] = i;
    				visited[i] = true;
    				pointer++;
    				//remove inlinks of nextcourses of i
    				for (int x: nextCourses[i]) {
    					inlink[x]--;
    				}
    			}
    		}
    		//Error Once: new int[] <---this is so-called empty array.
    		if (prev ==pointer) return new int[0];
    	}
        
        return ordering;
        
    }
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{0,1},{1,0}};
		findOrder(2, prerequisites);
		
	}

}
