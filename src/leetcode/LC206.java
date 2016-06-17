package leetcode;

import java.util.ArrayList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class LC206 implements Comparable<ListNode> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		n1.next=n2;
		n2.next=n3;
		n3.next=null;

		ListNode head=reverseList(n1);
        System.out.println(head.val);
        System.out.println(head.next.val);
	}

	
	
	 public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode pre=head;
		ListNode curr=head.next;
		pre.next=null;
		while(curr != null){
			ListNode tmp=curr.next;
			curr.next=pre;
			pre=curr;
			curr=tmp;
		}
		return pre;
		 
	 }

	@Override
	public int compareTo(ListNode o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}