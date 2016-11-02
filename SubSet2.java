/*
 * Time:12/14/2014 Sun 1:34 PM
 * Author: Scarlett Chen
 * LeetCode 145 Subsets II 
 * 题本身不难，比非duplicate就是多两行判重的代码〜
 * 要注意的就是path加了以后，要记得删掉〜因为它是object，在method里call的时候不会自己变值
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubSet2 {
	 List<List<Integer>> ans;
	 int[] num;
	 int len;
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
        ans = new ArrayList<List<Integer>>();
        this.num = num;
        this.len = num.length;
        ans.add(new ArrayList<Integer>());
        List<Integer> path= new ArrayList<Integer>();
       
            for (int i=0; i < len; i++) {
            	 for (int count=1; count<=len-i; count++) {
                    
            	if (i>0 && num[i]==num[i-1]) continue;
                path = new ArrayList<Integer>();
                search(i,count,path);
            }
        }
        return ans;
        
    }
    private void search (int index, int countLeft,  List<Integer> path) {
        if (countLeft==1) {
            path.add(num[index]);
          // System.out.println("Ans "+path);
            ans.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        else {
             path.add(num[index]);
              for (int i=index+1; i<len; i++) {
            	  if (i>index+1 && num[i]==num[i-1]) continue;
            	 // System.out.println(path+ " countLeft="+countLeft);
                  search(i, countLeft-1, path);
              } 
              path.remove(path.size()-1);
            }
        }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSet2 s= new SubSet2();
		//System.out.println(s.subsetsWithDup(new int[]{}));
		//System.out.println(s.subsetsWithDup(new int[]{1}));
		//System.out.println(s.subsetsWithDup(new int[]{1,2}));
		//System.out.println(s.subsetsWithDup(new int[]{2,1,1}));
		System.out.println(s.subsetsWithDup(new int[]{1,2,3}));

	}

}
