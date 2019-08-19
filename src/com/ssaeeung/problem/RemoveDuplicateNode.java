package com.ssaeeung.problem;

import java.util.HashSet;
import java.util.Set;

import com.ssaeeung.ds.Impl.SinglyLinkedList;
import com.ssaeeung.ds.base.ListNode;

public class RemoveDuplicateNode {
	public static ListNode removeDuplicateNode(ListNode head) {
		Set<Integer> uniqueSet = new HashSet<>();
		ListNode n = head;
		uniqueSet.add((Integer) n.val);
		while (n.next != null) {
			
			if (!uniqueSet.add((Integer) n.next.val)) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
		return head;
	}
	public static ListNode removeDuplicateNode2(ListNode head) {
		
		ListNode slowN = head;
		ListNode runner = head;
		while (slowN != null) {
			int val = (int)runner.val;
			while (runner.next != null) {
				if (((Integer)runner.next.val).intValue() == val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			slowN = slowN.next;
			runner = slowN;
			
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(Integer.valueOf(1));
		ListNode b = new ListNode(Integer.valueOf(3));
		ListNode c = new ListNode(Integer.valueOf(3));
		ListNode d = new ListNode(Integer.valueOf(3));
		ListNode e = new ListNode(Integer.valueOf(3));
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		SinglyLinkedList sl = new SinglyLinkedList();
		
		System.out.println(sl.printList(a));
		removeDuplicateNode2(a);
		System.out.println(sl.printList(a));
	}
}
