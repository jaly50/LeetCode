/*
 * LeetCode 55 LRU Cache 
 * Date: 2014/10/4
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * Some Tips: If the node is renewed, then the map should also be renewed.
 */
import java.util.*;


public class LRUCache {
	private int capacity;
	private DoublyLinkedList doubly;
	private HashMap<Integer,Node> map;
	private class DoublyLinkedList {
		Node first, last; //last is the most recent thing
		int size;
		int count; // count means the amount of caches has been used
		public DoublyLinkedList(int capacity) {
			first = null;
			last = null;
			this.size = capacity;
			count = 0;
		}
		public void insertLast(int key, int value) {
			// Which means it is an empty linkedlist
			count ++;
			if (last == null) {
				last = new Node(key, value, null,null);
				first = last;
			}
			// put the new value after the last; and the last become the new value
			else {
			   last.next = new Node(key, value, last, null);
			   last = last.next;
			}
			
		}
		public void delete(Node node) {
			count --;
			if (node.equals(first)) {
				deleteFirst();
				return;
			} 
			Node preNode, nextNode;
			preNode = node.pre;
			nextNode = node.next;
			if (preNode !=null) preNode.next =node.next;
			if (nextNode !=null) nextNode.pre = node.pre;
			
		}
		private void deleteFirst() {
			if (count >0 ) {
			first = first.next;
			first.pre = null;
			} 
			else {
				first = null;
				last = null;
			}
		}
		private void display() {
			Node node = first;
			while (node != null) {
				System.out.print("["+node.key +", "+node.val+"]");
				node = node.next;
			}
			System.out.println();
		}
	}
	private class Node {
		Node pre,next;
		int val;
		// When the doublyLinkedLIst is full, we really need the key to removde that one in the map
		int key;
		public Node(int key, int value, Node pre, Node next){
			this.key = key;  
			this.val = value;
			this.pre = pre;
			this.next = next;
			
			if (pre !=null ) pre.next = this;
			if (next != null) next.pre = this;
		}
		public void setValue(int value) {
			this.val = value;
			
		}
	}
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	doubly = new DoublyLinkedList(capacity);
    	map = new HashMap<Integer,Node>();
    }
    // After we get that value, we need to renew it to the last of the linkedlist
    public int get(int key) {
       if (map.containsKey(key)) {
    	  Node node = map.get(key);
    	  int value = node.val;
    	  if (!node.equals(doubly.last)) {
    		  doubly.delete(node);
  			doubly.insertLast(key, value);  
  			map.put(key, doubly.last);
    	  }
    	  return value;
       }
       else return -1;
       
    }
    
    public void set(int key, int value) {
    	Node node;
    	if (!map.containsKey(key)) {
    		if (doubly.count == this.capacity) {
    			Node dyingNode = doubly.first;
                map.remove(dyingNode.key);
    			doubly.delete(dyingNode);
    		}
    		doubly.insertLast(key, value);
    		map.put(key, doubly.last);
    	}
    	// if that value is already exist
    	// we need to get it, delete it in the linkedList, and reset it at the last
    	else {
    		node = map.get(key);
    		if (!node.equals(doubly.last)) {
    			doubly.delete(node);
    			doubly.insertLast(key, value);
    			map.put(key, doubly.last);
    		}
    		// even the key is already the last one of the doublyLinkedlist,
    		//but the value is different
    		else if (node.val !=value) {
    			node.setValue(value);
    		}
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      LRUCache cach = new LRUCache(2);
      cach.set(2, 1);
      cach.set(1, 1);
      cach.set(2, 3);
      cach.set(4,1);
      cach.doubly.display();
      System.out.println (cach.get(1));
      //cach.doubly.display();
      //cach.set(1,1);
    
      cach.doubly.display();
      System.out.println (cach.get(2));
     // cach.doubly.display();
    //  System.out.println (cach.get(2));
     // cach.doubly.display();
	}

}
