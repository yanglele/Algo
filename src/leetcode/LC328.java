package leetcode;

import java.util.List;

public class LC328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		//node6.next = null;
		System.out.println("===");
		ListNode h1=oddEvenList(node1);
		System.out.println("...");
		for (int i = 0; i < 5; i++) {
			System.out.println("  " + h1.val);
			h1 = h1.next;
		}
	}
	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next==null)
			return head;
		ListNode list1=head;
		ListNode list2=head.next;
		ListNode node=list2;
		while( list1.next!= null && list2.next != null){
			list1.next=list1.next.next;
			list2.next=list2.next.next;
			list1=list1.next;
			list2=list2.next;
		}
		list1.next=node;
		return list1;
	}
	
	
	
	
//	public static ListNode oddEvenList(ListNode head) {
//		if (head == null || head.next == null || head.next.next == null)
//			return head;
//		ListNode head1 = head;
//		ListNode head2 = head.next;
//		ListNode node = head.next;
//		while(head1.next != null && head2.next != null){
//			head1.next=head1.next.next;
//			head2.next=head2.next.next;
//			head1=head1.next;
//			head2=head2.next;
//		}
//			head1.next=node;
//		return head;
//	}
}
