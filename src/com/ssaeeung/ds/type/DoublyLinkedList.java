package com.ssaeeung.ds.type;

public class DoublyLinkedList {
	
	public static void main(String[] args) {
		DoubleListNode a = new DoubleListNode(new Integer(1));
		DoubleListNode b = new DoubleListNode(new Integer(4));
		DoubleListNode c = new DoubleListNode(new Integer(9));
		DoubleListNode d = new DoubleListNode(new Integer(13));
		
		a.next = b;
		b.next = c;
		b.previous = a;
		c.next = d;
		c.previous = b;
		d.previous = c;
		
		DoublyLinkedList sl = new DoublyLinkedList();
		
		System.out.println(sl.printListForward(a));
		System.out.println(sl.printListBackward(d));
		
		System.out.println("Reverse DLL");
		sl.reverseList(a, null);
		
		System.out.println(sl.printListForward(d));
		System.out.println(sl.printListBackward(a));
	}
	
	public DoubleListNode reverseList(DoubleListNode current, DoubleListNode previous) {
		if (current == null) {
			return null;
		}
		
		DoubleListNode p;
		
		if (current.next != null) {
			p = reverseList(current.next, current);
		}		
		
		if (current.next != null && current.previous == null) { // original Head node
			p = current.next;
			current.next = null;
			current.previous = p;
			return p;	// final stop condition for original head, to no tread this as tail node.
		}
		
		if (current.next == null && current.previous != null) { // original Tail node
			current.next = previous;
			current.previous = null;
		}
		
//		if (current.next != null && current.previous == null) { // original Head node
//			current.next = previous;
//			current.previous = null;
//		}
		
		
		if (current.next != null && current.previous != null) {
			p = current.previous;
			current.previous = current.next;
			current.next = p;
		} 
		
//		if (previous != null) {	// check for the original head not to cyclic
//			current.next = previous;
//		}
		return current;	
	}
	
	public String printListForward(DoubleListNode head) {
		if (head == null) {
			return "";
		}
		
		DoubleListNode current = head;
		StringBuilder sb = new StringBuilder();
		sb.append( ((Integer)current.val).toString() );
		while (current.next != null) {
			sb.append("->");
			sb.append( ((Integer)current.next.val).toString() );
			current = current.next;
		}
		return sb.toString();
	}
	
	public String printListBackward(DoubleListNode tail) {
		if (tail == null) {
			return "";
		}
		
		DoubleListNode current = tail;
		StringBuilder sb = new StringBuilder();
		sb.insert(0, ((Integer)current.val).toString() );
		while (current.previous != null) {
			sb.insert(0, "<-");
			sb.insert(0, ((Integer)current.previous.val).toString() );
			current = current.previous;
		}
		return sb.toString();
	}

	public static class DoubleListNode extends Node{
		DoubleListNode next;
		DoubleListNode previous;
		
		public DoubleListNode(Object val) {
			super(val);
		}
	}
	
}
