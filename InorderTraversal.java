    public List<Integer> inorderTraversal(TreeNode root) {
        /*Scarlett Chen, Aug 23th, 2015; Sun 4:51 PM
           Recursive solution
        */
        List<Integer> res = new ArrayList<Integer>();
        if (root==null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
