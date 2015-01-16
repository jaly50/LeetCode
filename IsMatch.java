/*
 * LeetCode 48  Regular Expression Matching 
 * Date:2014/9/30
 * �߽����Ҫ�ر�ע�⣡ *���ж��������Ҫ�����жϣ��������������
 * ���˵ݹ顣��Ϊ*�ſ��Դ�������ĸ��ÿ�ֿ����Զ�Ҫ���ԣ�ֻҪ��һ�ֳɹ�����ô�ͷ���true.
 * ��������ȣ� ���������������߳���
 * true��false������������Ԥ֪����Ҫֱ�ӷ��ء�
 */
public class IsMatch {
	private static String top, low;
	 public static boolean isMatch(String s, String p) {
	     top = s;
	     low = p;
	     return isMatch(0,0);
	    
	 }
    private static boolean isMatch(int i, int j) {
		if ((i==top.length()) && (j == low.length())) return true;
		if (j == low.length()) return false;

		 if ((j+1 < low.length()) && (low.charAt(j+1)=='*')) {
			 if (isMatch(i,j+2))  return true; // when * is zero.
			 while ((i < top.length()) && 
				 ((top.charAt(i) == low.charAt(j)) || (low.charAt(j)=='.')) )
			    if (isMatch(++i,j+2)) 
			    	return true;
		 }
		 if (i< top.length())
		 if  (((j+1 < low.length()) && (low.charAt(j+1)!='*')) ||
		   (j+1 == low.length()))
		 if ((top.charAt(i) == low.charAt(j)) || (low.charAt(j)=='.')) 
			 return isMatch(i+1,j+1);
		 return false;
	}
	public static boolean isMatch2(String s, String p) {
        if ((s.length() ==0) && (p.length() == 0)) return true;
        if ((s.length() ==0) || (p.length() == 0)) return false;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j>=p.length()) return false;
            if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j)=='.'))  {
                i++;
                j++;
                continue;
            }
            if ((j+2 <p.length()) &&
                  (s.charAt(i) != p.charAt(j)) && (p.charAt(j+1)=='*')) {
                j += 2;
                continue;
            }
            if (p.charAt(j) == '*') {
                while ((i<s.length()) && 
                		((p.charAt(j-1)=='.')|| (s.charAt(i) == p.charAt(j-1)))) i++;
                j++;
                continue; 
            }
            return false;
        }
       return true;
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dsfds";
		s.indexOf("s");
        System.out.println(isMatch("a","ab*"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b") + "   new");
        System.out.println(isMatch("dcaab", "dc*a*b"));
        System.out.println(isMatch( "ab", "dc*a*b"));
        System.out.println(isMatch("db", "dc*a*b"+ "  the next"));
        System.out.println(isMatch("ab", ".*c"));
	}

}
