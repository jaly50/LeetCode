public class NumArray {
//Binary index tree好牛逼啊...Bit manupilation
   int[] nums;
   int[] bit;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        //记住 在class里声明过，这里不能再声明了
        bit = new int[n + 1];
        for (int i=0; i<n; i++) {
            init(i, nums[i]);
        }
        
    }
    // update bit[] tree
    public void init(int idx, int val) {
        idx++;
        while (idx<=nums.length) {
            bit[idx] += val;
            //最后一个1进位， 2->4, 3->4
            idx += (idx & -idx);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
        
    }
    public int getSum(int idx) {
        int sum = 0;
        idx++;
        while (idx >0) {
            sum += bit[idx];
            //去掉最后一个 1-digit
            idx -= (idx & -idx);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
