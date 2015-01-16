import java.util.Arrays;

/*
 * LeetCode 161  Maximum Gap 
 * @author: Scarlett chen
 * @date: 12/28/2014 Sun 2:40
 * 找到(max-min)/(n-1) 根据平均差装箱
 */
public class MaximumGap {
    public static int maximumGap(int[] num) {
    //Get the average distance between two successive elements
    int n = num.length;
    if (n<2) return 0;
    int max= num[0], min = num[0];
    // get Max and min in the array
     for (int i:num) {
         max = i>max? i:max;
         min = i<min? i:min;
     }   
     //必须是ceil,否则 min*aveDis(n-1)会小于最大值的~后面就会溢出
     int aveDis =(int)(Math.ceil((double)(max-min)/(n-1)));
     if (aveDis==0) return 0; // all numbers are same value
     // put elements into array based on the average distance
     int[] maxA= new int[n+1], minA = new int[n+1];
     Arrays.fill(maxA, -1);
     Arrays.fill(minA, -1);
     int index = 0;
     for (int e:num) {
        index = (e-min)/aveDis; 
        if (maxA[index]==-1) 
        	maxA[index] = e;
        else maxA[index] = e>maxA[index]? e: maxA[index];
        if (minA[index]==-1)
        	minA[index] = e;
        else minA[index] = e< minA[index]? e: minA[index];
     }
     int gap = 0;
     int gapLeft=min, gapRight=0;// left would be maxA[i-1], right is minA[i]
     for (int i=0; i<= n; i++) {
    	 if (minA[i]!=-1)
    		 gapRight = minA[i];
    	 gap = Math.max(gap, gapRight-gapLeft);
    	 if (maxA[i]!=-1)
    		  gapLeft = maxA[i];
    	
     }
     return gap;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(maximumGap(new int[]{}));
      String version1= "s";
     
	}

}
