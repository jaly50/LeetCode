public class Solution {
    public int strongPasswordChecker(String s) {
        int len = s.length();
        boolean upper=false, lower = false, digit = false;
        int[] delete = new int[3];
        char end='\n';
        int word = 0;
        int change=0;
        for (char ch: s.toCharArray()) {
            if (ch==end) word++;
            else {
                change += word / 3;
                if (word/3 >0) delete[word %3]++;
                end = ch;
                word =1;
                upper |= (ch >='A') && (ch<='Z');
                lower |= ch>='a' && ch <='z';
                digit |= ch>='0' && ch <='9';
            }
            
        }
        change += word/3;
        if (word/3 >0) delete[word %3]++;
        int required = (upper? 0:1) + (lower? 0:1) + (digit? 0:1);
        if (len > 20) {
            //当len大于20时，要采用delete 手法
            //一个replacement可以分别用 1次删掉，2次和3次等价取代
            int del = len-20;
            if (del <= delete[0]) change -= del;
            else if (del - delete[0] <= 2*delete[1]) change -= delete[0] + (del-delete[0])/2;
            else change -= delete[0] + delete[1] + (del - delete[0] - 2*delete[1])/3;
            return del + Math.max(change, required);
        }
        //当len在6到20之间的话，replacement是最有效率的
        return Math.max(6-len, Math.max(required, change));
        
        
    }
}
