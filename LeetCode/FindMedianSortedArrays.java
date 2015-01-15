/*
 * Leetcode 40
 * date: 2014/9/27
 * algorithm: kth number in two sorted array
 * spend time:4 h
 * reference: true
 */
import java.util.Arrays;


public class FindMedianSortedArrays {
	static int n;
public static double findMedianSortedArrays(int A[], int B[]) {
	int nA = A.length;
	int nB = B.length;
	int total = nA+nB;
	Arrays.sort(A);
	if (total % 2 == 1) return getk(A,B,total/2+1);
	else  
		return (getk(A,B,total/2) + getk(A,B,total/2+1))/2;
    }

public static double getk(int[] a, int[] b,int  k) {
	int nA = a.length;
	int nB = b.length;
	if (nA > nB) 
		return getk(b,a,k);
	if (nA == 0) 
		return b[k-1];
	if (k == 1) 
		return Math.min(a[0],b[0]);
	int l = Math.min(nA, k/2);
	int r =  k - l;
	if (a[l-1] < b[r -1 ]) {
		return getk(Arrays.copyOfRange(a, l, a.length),b,k-l);
	}
	else if (a[l-1] > b[r-1]) {
		return getk(a,Arrays.copyOfRange(b, r, b.length),k-r);
	}
	else return a[l-1];

}

    // failure QAQ:return  find(A,B,left,right);
   private static double find(int[] a, int[] b, int left, int right) {
	int ma,mb;
	int[] smallA,smallB;
	ma = a[a.length/2];
	mb = b[b.length/2];
	if (ma <= mb) {
		smallA =Arrays.copyOfRange(a, a.length/2+1, a.length);
		smallB =Arrays.copyOfRange(a, 0, b.length/2);
		if (left + a.length/2+1 >= n/2+1) {
			return find(smallA,n-2*left);
		} 
		else if (right +b.length-b.length/2 >= n/2+1) {
			return find(smallB, smallB.length * 2 -(n-2*right));
		}
		else 
		return find(smallA,smallB,left+a.length/2+1, right+b.length-b.length/2);
	}
	//if ma > mb
	else {
		smallA =Arrays.copyOfRange(a, 0, a.length/2);
		smallB =Arrays.copyOfRange(a, b.length/2+1, b.length);
		if (left + b.length/2 >= n/2+1) {
			return find(smallB,n-2*left);
		} 
		else if (right +a.length-a.length/2 >= n/2+1) {
			return find(smallA, smallA.length * 2 -(n-2*right));
		}
		else 
		return find(smallA,smallB,left+b.length/2+1, right+a.length-a.length/2);
	}
   }
private static double find(int[] a, int s) {
	// TODO Auto-generated method stub
	if (s % 2 ==0 ) 
		return (a[s/2] + a[s/2+1])/2;
	else return a[s/2];
	}

public static void main(String[] args) {
	  int[] A =new int[] {1,3,9,18,27, 36,50};
	  int[] B = new int[] {4, 8, 23};
	  System.out.print(findMedianSortedArrays(A,B));
   }
}
