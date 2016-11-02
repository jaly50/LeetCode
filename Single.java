/**
 * Leetcode: Single Number; AC rate:45%
 * @author Scarlett
 * 	Requirement: Given an array of integers, every element appears twice except for one. Find that single one.
 * Data Structure: MergeSort
 */
public class Single {
	    public static int singleNumber(int[] A) {
	    	int len= A.length;
	    	if (len ==1) return A[0];
	    	else if (len==0) return -1;
	      mergesort(A,0,len-1);
	      //System.out.println();
	      //for (int i:A) { System.out.print(" "+i); }
	        int counter = 0;
	        while (counter < len-1) {
	        	if (A[counter] != A[counter+1]) return A[counter];
	        	else counter +=2;
	        }
	      return A[len-1];
	    }

		private static void mergesort(int[] a, int low, int high) {
			// TODO Auto-generated method stub
			if (low < high) {
				int mid = low + (high - low)/2;
				mergesort(a,low,mid);
				mergesort(a,mid+1,high);
				merge(a,low,mid,high);
			}
		}

		private static void merge(int[] a, int low, int mid, int high) {
			// TODO Auto-generated method stub
			int j=mid+1;
			int i = low;
			// A little improvement
			if (a[mid] < a[mid+1]) return; 
			int[] aux = new int[high-low+1];
			int counter = 0;
			while ((i <= mid) && (j<=high)) {
				if (a[i]>a[j]) {
				   aux[counter] = a[j];
				   j ++;
				}
				else {
					aux[counter] = a[i];
					i++;
				}
				counter ++;
			}
			while (i<=mid) {aux[counter]=a[i]; counter++; i++;}
			while (j<=high) {aux[counter]=a[j]; counter++; j++;}
			for (i=low; i<=high; i++) {
				a[i]=aux[i-low];
			}
		}


		public static void main(String[] args) {
			
			int[] a=new int[]{5,4,3,2,-1,2,4,5,-1};
			//mergesort(a,0,a.length-1);
			//for (int i:a) System.out.println(i);
			System.out.println(singleNumber(a));
		}
	}

