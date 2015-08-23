    //Iterative solution, without stack. left, root, right
    //http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
    //Morris Traversal Solution == for inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null) return res;
        while (root!=null) {
            if (root.left==null) { // It means all parent has turn to right, and the current root is the leftest node
                res.add(root.val);
                root = root.right;
            }
            else {
                TreeNode pre = root.left;
                TreeNode nextroot = pre;
                while (pre.right!=null) {
                    pre = pre.right;
                }
                pre.right = root;
                root.left = null;
                root = nextroot;
            }
        }
       return res; 
    }
