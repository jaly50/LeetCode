import java.math.BigDecimal;
import java.util.Iterator;


public class FactorialTrailingZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans = 1;
        for (long i=1; i<=30; i++) {
        	 ans  = (ans * i) % 1000000000 ;
        	System.out.println(i+" "+ ans);
        }
        Iterator
	}

}
