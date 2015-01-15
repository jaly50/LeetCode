import java.util.ArrayList;
import java.util.List;
/*
 * LeetCode 140 Restore IP Addresses
 * Author: Scarlett chen
 * Date: 12/12/2014 Fri 11:48 PM
 * 完成今天5题刷题任务：D
 * 这题用搜索...比较经典简单直接~
 * 第一次没有过：是少考虑了 不能“00”的情况
 * 其他情况要考虑的是： 每个field不能多于3位数，也不能少于1位数； 数字必须在0到255之间。
 */



public class RestoreIP {
	List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<String>();
        int len = s.length();
        if (len >12 || len<4) {
            return ans;
        }
        search(1,len,s,"");
        return ans;
    }
    private void search(int curField, int digitsLeft, String s, String path) {  
    	int fieldsLeft = 4 - curField;
    	if (fieldsLeft <0 ) {
    		ans.add(path.substring(0, path.length()-1));
    	}
        for (int i=1; i<=3; i++) {
            //Make the leftDigits is enough for leftFields,but not too much
          if (digitsLeft-i < fieldsLeft) {
              break;
          } 
          else
          if (3 * fieldsLeft + i < digitsLeft) {
              continue;
          }
          else {
              String fieldValue = s.substring(0, i);
              if (fieldValue.length()>1) {
            	  if (fieldValue.charAt(0)=='0') continue;
              }
              int value = Integer.parseInt(fieldValue);
              if (value >=0 && value <=255)
              search(curField+1,digitsLeft-i, s.substring(i), path+fieldValue+".");
          }
        }
          
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIP ri = new RestoreIP();
		System.out.println(ri.restoreIpAddresses("2502510035"));
	}

}
