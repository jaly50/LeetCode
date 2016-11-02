
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length())
            return addStrings(num2, num1);
        int n = num1.length();
        int m = num2.length();
        int i = n-1, j=m-1;
        int carry = 0;
        StringBuilder  ans= new StringBuilder("");
        int y=0;
        while (i>=0) {
            int x = Character.getNumericValue(num1.charAt(i));
            if (j>=0)
               y = Character.getNumericValue(num2.charAt(j));
            else y = 0;
            int digit = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            ans = ans.insert(0,digit);
            i--;
            j--;
        }
        if (carry >0) ans = ans.insert(0, carry);
        return ans.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings as = new AddStrings();
		as.addStrings("0", "0");

	}

}
