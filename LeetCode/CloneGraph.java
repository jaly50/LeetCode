import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
 * LeetCode: 148 Clone Graph
 * @author:Scarlett Chen
 * @date: 12/21/2014 Sun 7:04 PM
 * clone一个无向图，用栈一个一个访问结点，用hashmap记录clone的结点
 * 最近写代码都是一次过，真是不好意思嘿嘿嘿~~ 不过还是用了ide,如果没有提示的话，常常记不得如stack or map 的method的name
 */

public class CloneGraph {
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		//To traverse the original nodes
	        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
	        //To record lable and its cloned Graph
	        Map<Integer,UndirectedGraphNode> clone = new HashMap<Integer,UndirectedGraphNode>();
	        if (node==null) return node;
	        stack.push(node);
	        clone.put(node.label, new UndirectedGraphNode(node.label));
	        while (!stack.isEmpty()) {
	           UndirectedGraphNode root = stack.pop();
	           UndirectedGraphNode cloneRoot = clone.get(root.label);
	           for (UndirectedGraphNode nei:root.neighbors) {
	        	   UndirectedGraphNode cloneNei;
	        	  
	        	   //说明该结点已加入栈中
	        	   if (clone.containsKey(nei.label)) {
	        		   cloneNei = clone.get(nei.label);
	        		   
	        	   }
	        	   else {
	        		   cloneNei = new UndirectedGraphNode(nei.label);
	        		   clone.put(nei.label, cloneNei);
	        		   stack.push(nei);
	        	   }
	        	   cloneRoot.neighbors.add(cloneNei);
	               
	           }
	           
	         
	        } 
	        return clone.get(node.label);
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
