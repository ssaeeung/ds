package com.ssaeeung.ds.Impl;

import java.util.Stack;

import com.ssaeeung.ds.base.BTNode;
import com.ssaeeung.util.ObjectBuilders;

public class BTPostOrderTraverse {
	static ObjectBuilders ob = new ObjectBuilders();
	
	public static void main(String[] args) {
		
		BTNode root = ob.createBTreeNodes();
		postOrderTraverseI(root);
	}

	private static void postOrderTraverse(BTNode root) {
		if (root.left != null) {
			postOrderTraverse(root.left);
		}		
		if (root.right != null) {
			postOrderTraverse(root.right);
		}
		ob.print(root);
	}
	
	private static void postOrderTraverseI(BTNode root) {
		Stack<BTNode> s = new Stack<>();
		BTNode prev = null;
		
		s.push(root);
		
		while (!s.isEmpty()) {
			BTNode current = s.peek();
		
			// Go down the tree in search of a leaf. Once found, process it and pop stack. Otherwise move down
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null) {
					s.push(current.left);
				}
				else if (current.right != null) {
					s.push(current.right);
				} else {
					ob.print(s.pop());
				}
			
			// go up the tree from left node, if the child is right push it onto stack otherwise process parent and pop  
//            stack 
       
			} else if (current.left == prev) { 
				if (current.right != null) 
					s.push(current.right); 
				else 
				{ 
						ob.print(s.pop());
				} 
            
         /* go up the tree from right node and after coming back 
          from right node process parent and pop stack */
			}  else if (current.right == prev) { 
				ob.print(s.pop());
			} 

			prev = current; 
		}
	}
}
