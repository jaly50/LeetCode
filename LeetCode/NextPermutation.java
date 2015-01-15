import java.util.Arrays;

/*
 * LeetCode 95
 * 10/24/2014 Next Permutation
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
        int n = num.length-1;
        if (n<=0) return;
        //be careful for equal element
        // they can be simply seen as one element
        //if elements are equal, we don't replace them with each other, we don't change their position
        while (n-1>=0  && num[n-1] >= num[n]) {
            n--;
        }
        Arrays.sort(num);
        int x = num[n];
        int i=n, j= num.length-1;
        while (i<j) swap(num,i++,j--);
        if (n-1>=0 && num[n-1] < x) {
            for ( i=n; i<num.length; i++)
            	if (num[i]>num[n-1]) {
            		swap(num,i,n-1);
            		return;
            	}
        }
        
        
    }
	private void swap(int[] num, int i, int j) {
		// TODO Auto-generated method stub
		 int temp = num[i];
		num[i]=num[j];
		num[j]=temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
