/*
Scarlett Chen
6/6/2015 Sat 4:47 PM
Candy
Constant space


*/
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        if (n<2) return n;
        // total is tall candies
        // seqlen is the continue decrease numbers
        // curcan is  the currrent candy number
        // gap is the gap from last candy to this one, for examp [5,1], I will store 3---means we miss 4,3,2
        int  total = 1;
        int seqLen = 1;
        int curCan =1;
        int gap = 0;
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                curCan++;
                seqLen = 1;
                gap =0;
            }
            else if (ratings[i] == ratings[i-1]) {
                curCan = 1;
                seqLen =1;
                gap = 0;
            }
            // rating[i] < rating[i-1]
            else{
                if (curCan==1)
                total += seqLen; 
               if (gap >0) {
                   total--;
                   gap --;
               }
                if (seqLen==1) {
                    gap = curCan -1-1;
                }
                curCan = 1;
                seqLen ++;
               
                
                

            }
            total +=curCan;
        }
        return total;
        
    }
}
