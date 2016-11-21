/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 11/21/2016 Scarlett Chen
 * 449. Serialize and Deserialize BST
 * Mon 8:50 AM 写了45分钟
 * 要注意的地方： split(要用string),  结尾的空字符会被丢掉
 */
 //使用层级便历
 // 加个逗号，因为int可能超过1位数
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      if (root==null) return "";
      StringBuilder ans = new StringBuilder();
      q.offer(root);
      while (!q.isEmpty()) {
          int size = q.size();
          for (int i=0; i<size; i++) {
              TreeNode cur = q.remove();
              if (cur==null) {
                  ans = ans.append(",");
                  continue;
              }
              ans = ans.append(cur.val+",");
              q.offer(cur.left);
              q.offer(cur.right);
              
          }
      }
      //System.out.println(ans.toString());
      return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] orig = data.split(",");
        //System.out.println(Arrays.toString(orig));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int idx = 0;
        TreeNode head = new TreeNode(Integer.parseInt(orig[0]));
        q.offer(head);
        while (!q.isEmpty() && idx < orig.length) {
            TreeNode cur = q.remove();
            if (idx >= orig.length-1) break;
            String left = orig[++idx];
            if (!left.isEmpty()) {
                TreeNode lnode = new TreeNode(Integer.parseInt(left));
                cur.left  = lnode;
                q.offer(lnode);
            }
             if (idx >= orig.length-1) break;
            String right = orig[++idx];
            if (!right.isEmpty()) {
                TreeNode rnode = new TreeNode(Integer.parseInt(right));
                cur.right  = rnode;
                q.offer(rnode);
            }
        }
        
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
