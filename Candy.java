/*
 * leetCode  63 Candy 
 * date: 2014/10/08
 * ��Ȼ�Լ������0(n)time, o(1)space���㷨����ֱҪ���ˣ�
 * ����debug̫���ˣ�����
 * ��ϵ�ܼ򵥣����Ǳ�ǰ��Ĵ���С�� ��Ļ���ô����С�Ļ���ô����
 */
public class Candy {
    public  static int candy(int[] ratings) {
        int total = ratings.length, candy = 0;
        int down = 0;
       // When that index get much more candies than others
       boolean isGap = false;
       int gap = 0;
       for (int i=1; i< ratings.length; i++) {
           if (ratings[i] >= ratings[i-1]) {
        	   total = ratings[i]>ratings[i-1] ? total + (++candy): total + (candy = 0);
               down = 0;
               isGap = false;
           }
           else if (ratings[i] < ratings[i-1]) {
               if (candy >1) {
                   gap = candy-1;
                   isGap = true;
               } 
               else if (candy <= 1) {
                   if (isGap) {
                     if (gap > 0) gap--;
                     // When that big number doesn't still keep advance in that line
                     // we should add him next time (mark in down)
                     else {
                       down ++;
                       isGap = false;
                       }
                   }
                   down++;
                   total = candy < 1 ? (total + down): total;
               }
               candy = 0;
           }
          
       }
       return total; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] num = new int[]{7,5,4,8,12,17,2,1,0,-1};
       //System.out.println("it should be 26, it is "+candy(num));
      // System.out.println("it should be 9, it is "+candy(new int[]{ 4,3,3,2,1 }));
      // System.out.println("it should be 9, it is "+candy(new int[]{ 1,2,4,4, 3 }));
       System.out.println("it should be 13, it is "+candy(new int[]{ 1,3,4,3,2,1 }));
	}

}
