//删掉连续递增的最后一个数 
/*
 * Scarlett Chen
 *  Wed 11:10 PM 10/19/2016
 *  402. Remove K Digits
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {

        StringBuilder st = new StringBuilder(num);
        int pos = 0;
        for (int i=0; i<k; i++) {
          while (pos< st.length()-1 && st.charAt(pos) <= st.charAt(pos+1)) pos++;
          st = st.deleteCharAt(pos);
          pos--;
          if (pos<0) pos=0;
        }
        while (st.length()>0 && st.charAt(0)=='0') st = st.deleteCharAt(0);
        if (st.length()==0) return "0";
        else return st.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
