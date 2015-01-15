/*
 * LeetCode 104 Search for a Range
 * 除了一个compile error, it is one pass
 * 10/29/2014
 * binary search
 * 
 * My algorithm would be O(n) in the worst time
 * A better solution is:
 *   to find the left bound and right bound respectively
 *   Time:O(2logn)
 * public int[] searchRange(int[] A, int target) {
        int s, e, mid;
        int[] arr = new int[2];
        arr[0] = searchLeft(A, target);
        arr[1] = searchRight(A, target);
        return arr;
    }
 */
public class SearchRange {
	public int[] searchRange(int[] A, int target) {
	       int low,high,mid;
	       low =0; high = A.length-1;
	       while (low <= high) {
	           mid = low + (high -low)/2;
	           if (A[mid]<target) low=mid+1;
	           else if (A[mid]>target) high = mid -1;
	           else if (A[mid]==target) {
	               low = mid-1; high=mid+1;
	               while (low>=0 && A[low]==target) 
	                low--;
	               while (high<=A.length-1 && A[high]==target) 
	                high++;
	               return new int[]{low+1,high-1};
	           }
	       }
	       return new int[]{-1,-1};
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
