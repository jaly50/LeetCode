// 12/1/2016 6:46PM Redwood Shore; easy; Wednesday
public class Solution {
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
}
