
public class NumberArithmetic {
    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n<=2) return 0;
        int i =1;
        int count = 0;
        int dif = 0;
        while (i< n-1) {
        	//System.out.println(i+" n: "+ n);
            while (i<n-1 && A[i]-A[i-1] == A[i+1] - A[i]) {
                count += ++dif;
                i++;
            }
            //System.out.println(i+" n: "+ n);
            dif = 0;
            i++;
        }
        System.out.println(count);
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberArithmetic.numberOfArithmeticSlices(new int[]{2,3,5,7});
	}

}
