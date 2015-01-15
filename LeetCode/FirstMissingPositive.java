import java.util.HashSet;
import java.util.Set;

/*
 * Leetcode 94
 * Date: 10/23/2014
 * I cost more than constant space, it is not a good solution.
 * someone else provides a better solution:
 * o(n) and constant space! Great!
 * 1.Firstly, the number we are looking for must be in 1~n+1
 * so we put every element in A into their according position
 * make A[i]= i+1, if there is element i+1
 * then read the array A again, find the first one which A[i]!=i+1, the answer would be i+1
 * class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        for (int i = 0; i < n; ++i)
        {
            int digit = A[i];
            while (digit <= n && digit > 0 && A[digit - 1] != digit)
            {
                swap(A[digit - 1], A[i]);
                digit = A[i];
            }
        }
        for (int i = 0; i < n; ++i)
        {
            if (A[i] != i + 1)
            {
                return i + 1;
            }
        }
        return n + 1;
    }
};
 */
public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] A) {
	      Set<Integer> set = new HashSet<Integer>();
	      for (int i=0; i<A.length; i++) {
	    	  set.add(A[i]);
	      }
	      int num=1;
	      while (set.contains(num)) {
	          num++;
	      }
	      return num;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
