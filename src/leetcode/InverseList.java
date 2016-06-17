package leetcode;

public class InverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public static ListNode inverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode pre=head;
		ListNode curr=head.next;
		pre.next=null;
		while(curr != null){
			ListNode tem=curr.next;
			curr.next=pre;
			pre=curr;
			curr=tem;
		}
		return pre;
	} 

}
