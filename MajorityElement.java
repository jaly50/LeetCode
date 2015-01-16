import java.util.HashMap;
import java.util.Map;


public class MajorityElement {
    public int majorityElement(int[] num) {
        int n = num.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int ele:num) {
            if (map.containsKey(ele)) map.put(ele,map.get(ele)+1);
            else map.put(ele,1);
            if (map.get(ele) > n/2) return ele;
        }

       return num[0];        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
