import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode 119   Unique Binary Search Trees II 
 * Date:11/21/2014 Fri 7:49 PM
 * Author: Scarlett
 * Note: Be careful about the extreme situation, for example, 0. should not return null, but return {{}}
 * Method: Traverse left and right possibilities; Same situation, why do we need to recurse twice? Because though the amount is same, but number is different.
 * 
 * A better method not to repeatedly recurse the same situation for bigger number, using DP and clone which in small number:
 * https://oj.leetcode.com/discuss/9790/java-solution-with-dp
 * 
 * n=0 means we want the set of size 0 trees. It doesn't mean the set has size 0. The set is not empty, as it still contains an empty tree with root==null
 */


public class GenerateTrees {
	public List<TreeNode> generateTrees(int n) {
		  List<TreeNode> list = new ArrayList<TreeNode>();
			if (n==0) {
			    list.add(null);
			    return list;
			}
		
		boolean[] mark = new boolean[n + 1];
		Arrays.fill(mark, false);
		return dfs(1,n,mark);
	}
		

	private List<TreeNode> dfs(int low, int high, boolean[] mark) {
		 List<TreeNode> list = new ArrayList<TreeNode>();
		 //leaf, only one node
		if (low==high) {
			TreeNode root = new TreeNode(low);
			list.add(root);
			return list;
		}
		// When one son is null
		else if (low>high) {
			return null;
		}
		for (int i = low; i <= high; i++) {
			// If treeNode i hasn't been visited
			if (!mark[i]) {
				mark[i] = true;
				List<TreeNode> left = new ArrayList<TreeNode>();
				if (i>low) {
					left = dfs(low, i - 1,mark);
				}
				// A situation that doesn't add left leaf
				else left.add(null);
			
				List<TreeNode> right =  new ArrayList<TreeNode>();
				if (i<high) {
					right = dfs(i + 1, high,mark);
				}
				else right.add(null);
				// Keeping same root, but with different left son and right son
				// with the same range
				for (TreeNode x : left) {
					for (TreeNode y : right) {
						TreeNode root = new TreeNode(i);
						root.left = x;
						root.right = y;
						list.add(root);
					}
				}
				mark[i] = false;
			}
		}
		return list;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateTrees gt = new GenerateTrees();
		List<TreeNode> ans= gt.generateTrees(3);
		System.out.println();
		for (TreeNode x:ans) {
			System.out.print(x.val+" ");
		}
		System.out.println();
	}

}
