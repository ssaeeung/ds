package com.ssaeeung.ds.Impl;

import java.util.Stack;

import com.ssaeeung.ds.base.BTNode;
import com.ssaeeung.util.ObjectBuilders;

public class BTInOrderTraverse {
	static ObjectBuilders ob = new ObjectBuilders();
	
	public static void main(String[] args) {
		
		BTNode root = ob.createBTreeNodes();
		inOrderTraverseI(root);
	}

	// Recursive
	private static void inOrderTraverse(BTNode root) {
		if (root.left != null) {
			inOrderTraverse(root.left);
		}
		ob.print(root);
		if (root.right != null) {
			inOrderTraverse(root.right);
		}
		
	}
	
	// Iterative
	private static void inOrderTraverseI(BTNode root) {
		BTNode n = root;
		Stack<BTNode> s = new Stack<>();
		
		while ( n != null || !s.isEmpty()) {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			// n must be null at this point.
			n = s.pop();
			
			ob.print(n);
			
			n = n.right;
		}
	}
	
}
