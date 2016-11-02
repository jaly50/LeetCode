/*
 * Scarlett Chen
 * 10/17/2016 Mon 11:59
 * diet pepsi的方法很不错：
 * https://discuss.leetcode.com/topic/33738/share-my-solution
 * 牛逼得很...
 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // Get sums first
        long[] sums = new long[n+1];
        for (int i=0; i<n; i++) 
                sums[i+1] = sums[i] + nums[i];
        // From 0 to n+1 (exclusive)
        return mergeSort(sums, 0, n+1, lower, upper);
    }
    private int mergeSort(long[] array, int start, int end, int low, int up) {
    	// When they have only one difference, the mid will be the same as start, then it will never end
        if (end - start <= 1 ) return 0;
        int mid = (start + end) /2 ;
        int count = mergeSort(array, start, mid, low, up) + mergeSort(array, mid, end, low, up);
        int k=mid, j=mid, t=mid;
        long[] cache = new long[end - start];
        for (int i=start, r=0; i<mid; i++, r++) {
            while (k < end &&  array[k] - array[i] < low) k++;
            while (j<end && array[j] - array[i] <= up) j++;
            // j-k are the length for the sums who low<=sums[x] - sums[i]<= up
            count += j-k;
            // Sort for the part of the array，这种排序法可学！！
            while (array[t] < array[i]) cache[r++] = array[t++];
            cache[r] = array[i];
        }
        System.arraycopy(cache, 0, array, start, t-start);
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
