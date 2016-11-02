/**
 * Scarlett Chen 7/31/2015 Fri 11:52 PM
 *  Recursive way, Divide and Conquer
 * 
 * 
 **/ 
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = input.length();
        for (int i=0; i<len; i++) {
            char ch = input.charAt(i);
            int res= 0;
            if (ch=='+' || ch=='-' || ch=='*') {
            	//Break at i, get left part and right part
                List<Integer> lefts = diffWaysToCompute(input.substring(0,i));
                 List<Integer> rights = diffWaysToCompute(input.substring(i+1));
                 // Traverse all possibilities in left part and right part,  and combine them together
                 for (int left:lefts) {
                     for (int right:rights) {
                        switch (ch){
                            case '+':res=left+right;
                            break;
                            case '-':res= left-right;
                            break;
                            case '*': res=left * right;
                            break;
                            
                        }
                        ans.add(res);
                    
                     }
                 }
                 
            }
        }
        if (ans.size()==0) ans.add(Integer.valueOf(input));
        return ans;
    }
}
