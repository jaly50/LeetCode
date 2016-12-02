// Scarlett chen; 12/1/2016; 8:08pm, redwood shore; 248. Strobogrammatic Number III
//自己写哒 难嘛不难，代码有点长，corner case要考虑的比较多， 用了 strobogrammatic number 1 &2 的方法 beat 50%..优点是中间的长度们都用了math的方法，缺点是代码有点长
//我看到别人有直接dfs找到全部可能性的，挺简短的也不错
public class Solution {
        char[] ones = new char[]{'0', '1', '8'};
    String[] twos = new String[]{"00","11","88", "69","96"};
        public boolean isStrobogrammatic(String num) {
        int n = num.length();
        if (n<1) return true;
        for (int i=0, j=n-1; i<=j; i++, j--) {
            char v = num.charAt(i);
            char w = num.charAt(j);
            //System.out.println(v+" w: "+w);
            switch (v){
              case '1': case '0': case '8':
                  if (w!=v) return false;
                  break;
              case '6':
                  if (w!='9') return false;
                  break;
              case '9':
                  if (w!='6') return false;
                  break;
              default:
                return false;
            }
              
        }
        return true;
        
    }
    public int helper(String path, int n, String s) {
        int ans = 0;
        if (n<1) {
            return (path.compareTo(s) > 0) ? 1:0;
        }
        if (n==1) {
            int mid = path.length()/2;
            for (char one: ones) {
                String new_p = path.substring(0, mid)+String.valueOf(one)+path.substring(mid);
                //System.out.println("s: "+s+" path:"+path+" "+s.compareTo(path));
                ans+= (new_p.compareTo(s) > 0) ? 1:0;
                
            }
            return ans;
        }
        int mid=path.length()/2;
        for (String two: twos) {
            if (mid==0 && two.equals("00")) continue;
            ans += helper(path.substring(0, mid)+two+path.substring(mid), n-2, s);
        }
        return ans;
    }
    public int higher_strobogrammatic(int n, String s) {
        if (n<1) return 0;
        //System.out.println("n: "+n+" s: "+s);
        return helper("", n, s);
    }
    
    
    public int getStrogrammatic(int n) {
        if (n<1) return 0;
        if (n==1) return 3;
        if (n==2) return 4;
        if (n==3) return 12;
        return getStrogrammatic(n-2)*5;
    }
    public int strobogrammaticInRange(String low, String high) {
        //divide to 3 parts, for low, for high ,and numbers in the middle
        int lenl = low.length();
        int lenh = high.length();
        if (lenl > lenh) return 0;
        if (lenl== lenh && low.compareTo(high)>0) return 0;
        int ans= 0;
        ans += higher_strobogrammatic(low.length(), low);
        //System.out.println(ans);
        for (int i=low.length()+1; i<=high.length(); i++) ans+= getStrogrammatic(i); 
        ans -= higher_strobogrammatic (high.length(), high);
        if (isStrobogrammatic(low))  ans+=1;
        return ans;
        
    }
}
