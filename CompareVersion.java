/*
 * LeetCode 162 Compare Version Numbers 
 * @author :Scarlett Chen
 * @date: 12/28/2014
 * 这题需要注意的是 regex里 .是代表任意字符，所以要用转义
 * 另外注意一点，.可能有多个，且1.0.0是等同于1的
 */
public class CompareVersion {
	 public static  int compareVersion(String version1, String version2) {
	     if (version1.equals(version2)) return 0;
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.max(s1.length, s2.length);
        int count = 0;
        int v1,v2;
        while (count < len) {
        	if (count< s1.length)
        	v1 = Integer.parseInt(s1[count]);
        	else v1=0;
        	if (count<s2.length)
 	        v2 = Integer.parseInt(s2[count]);
        	else v2= 0;
 	       if (v1>v2) return 1;
	        else if (v1<v2) return -1;
	           count++;
        	
        }
       
     
       return 0;
        
    }
	 public static void main(String args[]) {
		System.out.println(compareVersion("32","33")); 
	 }
}
