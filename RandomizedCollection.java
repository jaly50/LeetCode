import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        int pos = list.size()-1;
        Set<Integer> set;
        if (map.containsKey(val)) {
            set = map.get(val);
            set.add(pos);
            return false;
        }
        else {
            set = new HashSet<Integer>();
            set.add(pos);
            map.put(val, set);
            return true;
        }
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if (!map.containsKey(val)) return false;
    	//System.out.println(" remove: "+val + " map: "+ map);
    	/*
    	 * 需要考虑的corner case是当前set和另一个other的处理
    	 * 如果要删掉的val刚好是list的last_element
    	 * 那么我们要取出set = map.get(last_element), 把里面location大的那个值删掉
    	 */
        Set<Integer> set;
        int loc;
        Set<Integer> other = new HashSet<Integer>();
        // last element position
        int pos = list.size()-1;
	     set = map.get(val);
	     loc = set.iterator().next();
	     if (pos != loc && pos >=0) {
	        int last_ele = list.get(pos);
	        list.set(loc, last_ele);
	        // change location for last ele
	        // it should contains
	        //if (map.containsKey(last_ele)) {
	        other = map.get(last_ele);
	        other.remove(pos);
	        // Add the new postition for the last element
	        other.add(loc);
	     }
	     list.remove(pos);
	     if (other != set) set.remove(loc);
	     //System.out.println(" remove: "+val + " map: "+ map);
	     if (set.isEmpty()) map.remove(val);
	    
         return true;   

    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int pos = rand.nextInt(list.size());
        return list.get(pos);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
