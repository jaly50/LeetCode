/*
 * LeetCode 124  Flatten Binary Tree to Linked List
 * Author: Scarlett Chen
 * Date:11/26/2014 Wed 10:32 AM
 * in place的意思大概是不要clone tree吧
 *  如果我new TreeNode(root.val)，就会过不了（1,2)...虽然不知道为什么
 *  所以我就先把root的左右孩子先放栈里，然后脱离它与孩子们的关系，再让它放到我的树里。就不复制了。
 *  思路：栈，深搜
 */


import java.util.Stack;


public class Flatten {
    public void flatten(TreeNode root) {
    	double x = Math.pow(33, 5);
        TreeNode result;
        TreeNode head = new TreeNode(-1);
        result = head;
        Stack<TreeNode> tree = new Stack<TreeNode>();
        if (root!=null) tree.push(root);
        while (!tree.isEmpty()) {
         root = tree.pop();
        if (root.right!=null) tree.push(root.right);
        root.right = null;
        if (root.left!=null) tree.push(root.left);
        root.left = null;
        result.right = root;
        result.left = null;
        result = result.right;
        }
        root = head.right;
        
    }
}
