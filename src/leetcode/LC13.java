package leetcode;

public class LC13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		node3.next=null;
		System.out.println(node1.next.val);
//		ListNode head=inverseList(node1);
//		while(head != null){
//			System.out.println(head.val);
//			head=head.next;
//		}
	}

	public static ListNode inverseList(ListNode head){
		if(head == null || head.next==null)
			return head;
		ListNode thisNode=head;
		while(thisNode.next != null){
			thisNode.next=null;
			thisNode.next.next=thisNode;
			thisNode=thisNode.next;
		}
		return thisNode;
	}
	
}

