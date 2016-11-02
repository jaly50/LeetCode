import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    Set<Integer>[] courses = new Set[numCourses];
    for (int i=0; i<numCourses; i++) {
        courses[i] = new HashSet<Integer>();
    }
    for (int[] tuple:prerequisites) {
        courses[tuple[0]].add(tuple[1]);
    }
    // KEY to solve the cyclic problem: only change status in the same round
    boolean[] visited = new boolean[numCourses];
    // Main key to speed up, mark whether it is been visited in the previous round. If it is,
    //we don't check it again in a new round
    boolean[] flag = new boolean[numCourses];
    Arrays.fill(visited, false);
    Arrays.fill(flag,false);
    // run numCourses rounds
    for (int i=0; i<numCourses; i++) {
        if (!flag[i])
        if (!dfs(i, courses, visited, flag)) return false;
    }
    return true;
        
    }
    public boolean dfs(int index, Set<Integer>[] courses, boolean[] visited, boolean[] flag) {
        visited[index] = true;
        flag[index]= true;
        for (int next: courses[index]) {
            if (visited[next]) return false;
            if (!dfs(next, courses, visited,flag)) return false;
        }
        visited[index] = false;
        return true;
    }
}
