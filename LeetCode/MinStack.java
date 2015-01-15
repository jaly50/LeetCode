import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 会发现这个代码只用了1个stack,stack里存的是当前value与当前最小值之间的差~
 * 用了较少的空间，非常巧妙，但比较难懂
 */
public class MinStack {
    Stack<Integer> list = new Stack<Integer>();
    int min= Integer.MAX_VALUE;
    public void push(int x) {
        if (list.isEmpty()) {
            min = x;
            list.push(0);
        }
        else {
            list.push(x-min);
            if (x-min<0) min=x;
        }
        
    }
    
    //Removes the element on top of the stack.
    public void pop() {
      list.pop();
    }

    public int top() {
     int top = list.peek();
     if (top>=0) {
         top = top +min;
     }
     else {
         top = min;
         min = min - top;
     }
     return top;

    }

    public int getMin() {
      return min;
    }
    public static void main(String[] args) {
    	MinStack ms = new MinStack();
    	ms.push(-2);
    	ms.push(0);
    	ms.push(-1);
    	System.out.println(ms.getMin());
    	System.out.println(ms.top());
        ms.pop();
    	System.out.println(ms.getMin());
    }
}
