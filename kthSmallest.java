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
/*  preorder solution, using stack*/
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count=0;
        while (root!=null || !stack.isEmpty()) {
            if (root!=null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode p = stack.pop();
                count++;
                if (count==k) return p.val;
                if (p.right!=null) {
                    root = p.right;
                }
            }
        }
        return 0;
        
    }
}
