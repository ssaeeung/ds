package com.ssaeeung.ds.Impl;

import com.ssaeeung.ds.base.ListNode;

public class SinglyLinkedList {
	
	public static void main(String[] args) {
		ListNode a = new ListNode(Integer.valueOf(1));
		ListNode b = new ListNode(Integer.valueOf(4));
		ListNode c = new ListNode(Integer.valueOf(9));
		ListNode d = new ListNode(Integer.valueOf(13));
		
		a.next = b;
		b.next = c;
		c.next = d;
		SinglyLinkedList sl = new SinglyLinkedList();
		
		System.out.println(sl.printList(a));
		
		sl.reverseList(a, null);
		
		System.out.println(sl.printList(d));
	}
	
	public ListNode reverseList(ListNode current, ListNode previous) {
		if (current == null) {
			return null;
		}
		
		ListNode p;
		
		if (current.next != null) {
			p = reverseList(current.next, current);
		}		
		
		// end condition, return new head
		current.next = previous;
		return current;
		
	}
	
	public String printList(ListNode head) {
		if (head == null) {
			return "";
		}
		
		ListNode current = head;
		StringBuilder sb = new StringBuilder();
		sb.append( ((Integer)current.val).toString() );
		while (current.next != null) {
			sb.append("->");
			sb.append( ((Integer)current.next.val).toString() );
			current = current.next;
		}
		return sb.toString();
	}
	
}
