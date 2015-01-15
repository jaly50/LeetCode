
public class AddBinary {
	 public String addBinary(String a, String b) {
	        int i= a.length()-1;
	        int j= b.length()-1;
	        int remain = 0;
	        int x,y;
	        StringBuffer total= new StringBuffer();
	        while (i>=0 || j>=0) {
	           if (i>=0) {
	               x = a.charAt(i)-'0';
	               i--;
	           }
	           else x =0;
	           if (j>=0) {
	               y = b.charAt(j) - '0';
	               j--;
	           }
	           else y=0;
	            int ans = x+y+ remain;
	            if (ans>1) {
	                remain=1;
	                ans = 0;
	            }
	            else remain = 0;
	            total = total.insert(0, ans);
	            
	        }
	        if (remain>0) total= total.insert(0,remain); 
	        return total.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = args[0];
		String b = "123";
		System.out.println(a==b);
		//System.out.println(1l<<31);
		//AddBinary ad = new  AddBinary();
		//System.out.println(ad.addBinary("1111", "1111"));
	}

}
