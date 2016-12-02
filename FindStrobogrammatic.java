
//要注意return value和corner case
public class Solution {
    char[] ones = new char[]{'0', '1', '8'};
    String[] twos = new String[]{"00","11","88", "69","96"};
    public void helper(List<String> res, String path, int n) {
        if (n<1) {
            res.add(path);
            return;
        }
        if (n==1) {
            int mid = path.length()/2;
            for (char one: ones) {
                //if (one=='0' && mid<1) continue;
                res.add(path.substring(0, mid)+String.valueOf(one)+path.substring(mid));
            }
            return;
        }
        int mid=path.length()/2;
        for (String two: twos) {
            if (mid==0 && two.equals("00")) continue;
            helper(res,path.substring(0, mid)+two+path.substring(mid), n-2 );
        }
    }
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if (n<1) return res;
        helper(res, "", n);
        return res;
    }
}
