/*
 * 341. Flatten Nested List Iterator
 * Scarlett Chen
 * 10/17/2016 Mon 11:47
 * 打开list层层包装的一道题，用stack从后往前装 
 */
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
     // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
public class NestedIterator implements Iterator<Integer> {
	// Note: initialize the original Stack
	Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public NestedIterator(List<NestedInteger> nestedList) {
      for (int i=nestedList.size()-1; i>=0; i--) {
          stack.push(nestedList.get(i));
      }
    }

    @Override
    public Integer next() {
      return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger value = stack.peek();
            if (value.isInteger()) return true;
            //This is a list, we need to decompose it and re-push it to the stack.
            stack.pop();
            List<NestedInteger> list = value.getList();
            for (int i=list.size()-1; i>=0; i--) {
            stack.push(list.get(i));
             }
        }
        return false;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}