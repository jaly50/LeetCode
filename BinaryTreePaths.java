/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Aug 17th, 2015. Scarlett Chen 
 * 2 queue = width first search
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        Queue<String> strs = new LinkedList<String>();
        Queue<TreeNode> nodes= new LinkedList<TreeNode>();
        if (root==null) return res;
        nodes.add(root);
        strs.add(""+root.val);
        while (!nodes.isEmpty()) {
            root =nodes.remove();
            if (root.left==null && root.right==null) {
                res.add(strs.remove());
            }
            else {
                String curstr=strs.remove();
                if (root.left!=null) {
                    nodes.add(root.left);
                    strs.add(curstr+"->"+root.left.val);
                }
                if (root.right!=null) {
                    nodes.add(root.right);
                    strs.add(curstr+"->"+root.right.val);
                }
            }
        }
        return res;
        
    }
}
