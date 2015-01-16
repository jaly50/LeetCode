/*
 * LeetCode 139 Permutation Sequence 
 * Author: Scarlett
 * Date: 12/12/2014 Fri 9:55 PM
 * 得到长度为n的第k个排列。
 * 我的方法是研究k个排列的规律，比如 1-6之间，就只有最后3位变化。
 * 所以我先把 k=k-max(x!<k)  （1<x<n）, 同时得到x位的新值，把x后面的值往后挪。重复这样做，就可以得到第K个值。
 * 有点儿算是十进制换成二进制的思路呢。如65>64,就先把第6位的值改为1。
 * 更复杂一点点，因为这里不只有1和0两种变化。
 * 2！=2 ，3！=6  如果k是5的话，就要减去2次的2，于是第三位的值就会加两次，变成3.  
 * 
 * 和别人的思路差不多，但是人家用recursive的方法，清楚简单多了：https://oj.leetcode.com/discuss/5568/does-anyone-have-better-idea-share-accepted-python-code-here
 */
public class PermutationSequence {
public String getPermutation(int n, int k) {
        StringBuffer ans = new StringBuffer();
        for (int i=1; i<=n; i++) 
        	ans.append(i);
        k= k-1; //The current one is the first one. So we make it begin from 0
        while (k>0) {
        int pos =1;
        int maxValue = 1;
        //求最大阶乘
        while (maxValue * pos <= k) {
        	maxValue = maxValue * pos++;
        }
        char posValue, newPosValue;
        posValue = ans.charAt(n-pos);
        newPosValue= posValue;
        int posOld, posNew;
        posOld = n-pos;
        posNew = posOld;
        //算算有多少 (x-1)!的变化，当前位的值就要从后面几个拿。
        //其实是取商和取余的过程= =
        while (k>=maxValue) {
        k = k - maxValue;
        posNew++;
        }
        newPosValue = ans.charAt(posNew);
        
        ans.deleteCharAt(posNew);
        ans.insert(posOld,newPosValue);
        
      //  System.out.println("maxValue= "+maxValue+" k="+k+" pos= "+ pos+" s1= "+newPosValue+" s2= "+posValue+"  --> "+ans.toString());
        }
     return ans.toString();        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char v ='1';
		//System.out.println(++v);
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 1));
		System.out.println(p.getPermutation(3, 4));
	}

}
