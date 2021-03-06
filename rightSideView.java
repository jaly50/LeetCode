/*
Binary Tree Right Side View
2015.04.17
深搜比广搜好。
list.size == currentDepth 是一个很棒的想法

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightSideView(root, list, 0);
        return list;
    }
    public void rightSideView(TreeNode root, List<Integer> list, int depth) {
        if (root ==null) return;
        if (depth ==list.size()) {
            list.add(root.val);
        }
        rightSideView(root.right, list, depth+1);
        rightSideView(root.left, list, depth+1);
    }
    
}
