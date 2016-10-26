import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanCross {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i=0; i<n; i++) map.put(stones[i], new HashSet<Integer>());
        Set<Integer> s = new HashSet<Integer>();
        s.add(0);
        map.put(stones[0], s);
        for (int i=0; i<n; i++) {
            if (!map.containsKey(stones[i])) continue;
            s = map.get(stones[i]);
             for (Integer step: s) {
                for (int jump=Math.max(step-1, 1); jump<=step+1; i++) {
                    int stone = stones[i] + i;
                    if (stone == stones[n-1]) return true;
                    if (map.containsKey(stone)) {
                        Set<Integer> value = map.get(stone);
                        value.add(i);
                    }
                }
            }           
        }
        
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
