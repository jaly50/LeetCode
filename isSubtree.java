
/*
* LeetCode Weekly Contest 31
* Scarlett Chen, Sat 7:43, Ranking 145
* 572. Subtree of Another Tree
*Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // s and t both not empty
        if (s.val == t.val && same(s,t)) return true;
        if (s.left !=null && isSubtree(s.left, t)) return true;
        if (s.right !=null && isSubtree(s.right, t)) return true;
        return false;
        
    }
    public boolean same(TreeNode s, TreeNode t) {
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.val != t.val) return false;
        return same(s.left, t.left) && same(s.right, t.right);
        
    }
}
