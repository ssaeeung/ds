package com.ssaeeung.util;

import com.ssaeeung.ds.base.BTNode;

public class ObjectBuilders {

	public BTNode createBTreeNodes() {
		BTNode a = new BTNode(String.valueOf("a"));
		BTNode b = new BTNode(String.valueOf("b"));
		BTNode c = new BTNode(String.valueOf("c"));
		BTNode d = new BTNode(String.valueOf("d"));
		BTNode e = new BTNode(String.valueOf("e"));
		BTNode f = new BTNode(String.valueOf("f"));
		BTNode g = new BTNode(String.valueOf("g"));
		BTNode h = new BTNode(String.valueOf("h"));
		BTNode i = new BTNode(String.valueOf("i"));
		
		a.left = b;
		a.right = g;
		b.left = c;
		b.right = d;
		d.left = e;
		d.right = f;
		g.right = h;
		h.left = i;
		return a;
	}
	
	public void print(BTNode n) {
		System.out.print(n.val + "->");
	}
}
