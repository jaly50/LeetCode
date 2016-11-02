
public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <2) return n;
        int k=1;
        int count = 1;
        //当数列一样时，规则不再适用
        while (k<n && nums[k]==nums[k-1]) k++;
        if (k==n) return count;
        boolean  big = (nums[k] > nums[k-1]);
// 如何发现此规律？ 当连续两个元素不符合规则时，必删其中之一。
        for (int i =1; i< n; i ++) {
            if ((big && nums[i] > nums[i-1]) ||(!big && nums[i] < nums[i-1] )) {
                big = !big;
                count ++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
