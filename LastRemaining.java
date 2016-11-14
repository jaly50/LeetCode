// 11/13/2016 Sun 4:51 PM Stanford Green Library
public class Solution {
    //首先，用模拟的做法。从左往右，每隔两个。从右往左，每隔4个。
    //有一点儿像是数学方法...你要通过判断发现每次loop之后，会剩下多少个，会从哪个数开始
    public int lastRemaining(int n) {
        //第一轮，两个数之间的间距是1
        int gap = 1;
        boolean toRight = true;
        int remain = n;
        int cur = 1;
        while (remain > 1) {
            if( toRight || remain % 2 ==1) {
                cur = cur + gap;
            }
            //每次loop完，数字都会少一半
            remain = remain / 2;
            toRight = !toRight;
            //每次loop完，数字之间的间距
            gap = gap * 2;
        }
        return cur;
        
    }
}
