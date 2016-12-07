/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //270. Closest Binary Search Tree Value 
 //在树里找到一个值最接近target
 // Scarlett Chen, 12/6/2016, 8:20 pm, easy
public class Solution {
    public int closestValue(TreeNode root, double target) {
        // avoid the case that the tree is empty
        double min = Math.abs(root.val - target);
        int value = root.val;
        int other_value;
        if (root.left !=null) {
            other_value = closestValue(root.left, target);
            double other_min = Math.abs(other_value - target);
            if (other_min < min) {
                min = other_min;
                value = other_value;
            }
        } 
        if (root.right !=null) {
            other_value = closestValue(root.right, target);
            double other_min = Math.abs(other_value - target);
            if (other_min < min) {
                min = other_min;
                value = other_value;
            }
        }
        return value;
    }
}
