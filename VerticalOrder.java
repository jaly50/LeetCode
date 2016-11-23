    // reference: False, Scarlett Chen, 10:19 Wed
    //要求要从上往下，所以必须用宽搜
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> poses = new LinkedList<Integer>();
        if (root ==null) return res;
        q.add(root);
        poses.add(0);
        int diff =0;
        int idx = 0;
        while (!q.isEmpty()) {
            root = q.remove();
            idx = poses.remove();
            if (idx+diff <0 || idx+diff >=res.size()) {
                if (idx+diff<0) diff++;
                List<Integer> path = new LinkedList<Integer>();
                path.add(root.val);
                res.add(idx+diff, path);
            }
            else {
                 List<Integer> path = res.get(idx+diff);
                 path.add(root.val);
            }
            if (root.left!=null) {
                q.add(root.left);
                poses.add(idx-1);
            }
            if (root.right!=null) {
                q.add(root.right);
                poses.add(idx+1);
            }
            
        }
       return res;
    }
