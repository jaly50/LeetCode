/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Scarlett Chen
 * 6/16/2015 Tue 2:47 pm
 * change node value, in this case , we can complete it in recursive way without helper function
 * Other thoughts: bfs, recursive+helper function
 */
public class Solution {
    
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null ) return root.val;
        int ans=0;
        if (root.left!=null) {
            root.left.val = root.val *10 +root.left.val;
            ans+=sumNumbers(root.left);
        }
        if (root.right!=null) {
            root.right.val = root.val *10+ root.right.val;
            ans +=sumNumbers(root.right);
        }
        return ans;
        
    }
}
