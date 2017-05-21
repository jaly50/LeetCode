//592. Fraction Addition and Subtraction
//Scarlett Chen 5/20/2017 LeetCode weekly Contest 33
//直观的思维，但String处理有点麻烦，应该可以再简化。
public class Solution {
    class Fraction {
        int num;
        int denom;
        Fraction(String exp) {
            System.out.println(exp);
            int d = exp.indexOf("/");
            this.num = Integer.parseInt(exp.substring(0,d));
            this.denom = Integer.parseInt(exp.substring(d+1));
        }
    }
    public String fractionAddition(String expression) {
        //最小公倍数 最大公约数
        StringBuilder sb = new StringBuilder();
        String[] exps = expression.split("[+,-]");
        if (expression.charAt(0) == '-') {
            exps = expression.substring(1).split("[+,-]");
            exps[0] = "-"+exps[0];
        }
        int n = exps.length;
        int count = 0;
        int start = 0;
        for (int i=1; i<expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                count++;
                exps[count] = "-" +exps[count];
                
            }
            else if (expression.charAt(i) == '+') count++;
        }
        if (n<1) return "";
        if (n==1) return exps[0];
        Fraction cur = new Fraction(exps[0]);
        for (int i=1; i<n; i++) {
            Fraction next = new Fraction(exps[i]);
            int com = mincom(cur.denom, next.denom);
            //System.out.println(com);
            cur.num = cur.num*(com/cur.denom) + next.num*(com/next.denom);
            //System.out.println(cur.num);
            cur.denom = com;
            int gcd = gcd(Math.abs(cur.num), Math.abs(cur.denom));
            //System.out.println(gcd);
            cur.num /= gcd;
            cur.denom /= gcd;
        }
        return String.valueOf(cur.num)+"/"+String.valueOf(cur.denom);
        
    }
    int gcd(int a, int b) {
        if (b==0) return a;
        if (a<b) return gcd(b,a);
        return gcd(b, a%b);
    }
    int mincom(int a, int b) {
        int gcd = gcd(a,b);
        return a*b/gcd;
    }
}
