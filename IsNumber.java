
public class IsNumber {
	  public static boolean isNumber(String s) {
	        s =s.trim();
	        if (s.length() <1) return false;
	        boolean sign = false, e = false, point = false;
	        if ((s.substring(0,1).matches("[+-]")) && (!sign)) {
	             sign = true;
	             s =s.substring(1);
	        }
	         int i = 0;
	        while (i<s.length()) {
	        if (s.substring(i,i+1).matches("[0-9]")) i++;
	        else {
	         if (s.length() <=1) return false;
	           if ((s.charAt(i)=='e') && (!e)) {
	            if ((i == (s.length()-1)) ||(i == 0))  return false;
	             e = true;
	             i++;
	             if((i<s.length()-1) && ((s.substring(i,i+2).matches("[+-][0-9]")))) i=i+2;
	        }
	        else
	        if ((s.charAt(i)=='.') && (!point)&& (!e)) {
	        	 if ((i==0) && (s.charAt(i+1)=='e')) return false;
	             point = true;
	             i++;
	        }
	        else return false;
	        }
	        }
	      return true;  
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1e. is false: "+ isNumber("1e."));
		System.out.println("46.e3 is true: "+ isNumber("46.e3"));
		System.out.println(".e1 is false: "+ isNumber(".e1"));
		System.out.println(" 005047e+6 is true: "+ isNumber(" 005047e+6"));
		System.out.println("4e+ is false: "+ isNumber("4e+"));

	}

}
