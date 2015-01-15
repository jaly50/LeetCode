/*
 * LeetCode 88 Valid Palindrome 
 * date: 2014/10/20
 * 也不知道为什么，用char处理可以。但是用String处理就会超时
 * 简单题
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length()<=1) return true;
        int low=0, high=s.length()-1;
        char[] ch = s.toCharArray();
        String a,b;
        while (low<high) {
        	if (!isAlpha(ch[low])) low++;
        	else if (!isAlpha(ch[high])) high--;
        	else {
        		 a = String.valueOf(ch[low]);
        		 b = String.valueOf(ch[high]);
        		if (!a.equalsIgnoreCase(b)) return false;
        		else {low++; high--;}
        	}
        }
        /*  也不知道为什么用String就错了
        while (low<high) {
        	while ((low<=high) && (!s.substring(low,low+1).matches("[a-z|A-Z]"))) low++;
        	while ((low<=high) && (!s.substring(high,high+1).matches("[a-z|A-Z]"))) high--;
            if ((low<high) && (!s.substring(low, low+1).equalsIgnoreCase(s.substring(high,high+1)))) 
             return false;
            low++;
            high--;
        }
        */
        return true;
        
    }
	private static boolean isAlpha(char c) {
		// TODO Auto-generated method stub
		if (((c>='a') && (c<='z')) ||  (c>='A' && c<='Z')) return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('a'-'A');
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("1a2"));
	}

}
