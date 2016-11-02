
public class ThirdMax {
    private int getmax(int[] nums) {
        int max = Integer.MIN_VALUE;
       for (int ele: nums) {
           if (ele > max) max = ele;
       }
       return max;
   }
   public int thirdMax(int[] nums) {
      int n = nums.length;
      if (n<3) return getmax(nums);
      int sec = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
      int maxv = sec;
      for (int ele: nums) {
          if (ele > maxv) {
              third = sec;
              sec = maxv;
              maxv = ele;
          }
      }
      if (third != Integer.MIN_VALUE) return third;
      return maxv;
      
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
