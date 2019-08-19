package com.ssaeeung.ds.Impl;

import java.util.Stack;

import com.ssaeeung.ds.base.BTNode;
import com.ssaeeung.util.ObjectBuilders;

public class BTPreOrderTraverse {
	static ObjectBuilders ob = new ObjectBuilders();
	
	public static void main(String[] args) {
		
		BTNode root = ob.createBTreeNodes();
		preOrderTraverseI(root);
	}

	private static void preOrderTraverse(BTNode root) {
		ob.print(root);
		if (root.left != null) {
			preOrderTraverse(root.left);
		} 
		if (root.right != null) {
			preOrderTraverse(root.right);
		}
	}
	
	private static void preOrderTraverseI(BTNode root) {
		BTNode n = root;
		Stack<BTNode> s = new Stack<>();
		s.push(n);
		while (!s.isEmpty()) {
			n = s.pop();
			ob.print(n); 	// n as ROOT	
			
			if(n.right != null) s.push(n.right);
			if(n.left != null) 	s.push(n.left);
		}
	}
}
