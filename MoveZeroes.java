package leetcode;

public class MoveZeroes {
    // need to keep order
    // 9/23/2016, 5:38 -5:53 
	// Reference: False
	// 要是都是那么简单的题就好了...count zero..
	// Array, two pointers
    public void moveZeroes(int[] nums) {
        int v_pos = 0;
        for (int i=0; i<nums.length; i++) {
            while (v_pos < nums.length && nums[v_pos]==0 ) v_pos++;
            if (v_pos >= nums.length) {
                nums[i]=0;
                continue;
            }
            nums[i] = nums[v_pos++];
        }
    }
}
