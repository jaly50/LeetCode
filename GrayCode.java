import java.util.ArrayList;
import java.util.List;


public class GrayCode {
    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if  (n==0)  return list;
        int sum = 1;
        int i = 1;
        boolean left = true;
        if (n==1) {
            list.add(1);
            return list;
        }
        while (sum !=0) {
            list.add(sum);
            if (left) i = i << 1;
            else i = i>> 1;
            sum ^= i;
            if (i == (1 << (n-1))) left = false;
            if (i == 1) left = true;
        }
        
        return list;    
    }
    public List<Integer> grayCode2(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        int inc = 0;
        for (int i=0; i<n; i++) {
            inc = 1 << i;
            for (int j = list.size()-1; j>=0; j--) {
                list.add(list.get(j)+ inc);
            }
        }
        return list;
    }
	    public static void main(String[] args) {
	    	ArrayList list = (ArrayList) grayCode(1);
	    	for( int i=0; i<list.size(); i++) {
	    		System.out.println((list.get(i)));
	    		//System.out.println();
	    	}
	    }
}
