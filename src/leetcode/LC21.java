package leetcode;

import java.util.Stack;

public class LC21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
		
        ListNode fakehead=new ListNode(-1);
        ListNode l3=fakehead;
        while(l1 != null && l2 != null){
        	if(l1.val>l2.val){
        		l3.next=l2;
        		l2=l2.next;
        		l3=l3.next;
        	}else{
        		l3.next=l1;
        		l1=l1.next;
        		l3=l3.next;
        	}
        }
        if(l1 == null)
        	l3.next=l2;
        if(l2 == null)
        	l3.next=l1;
        return fakehead.next;
	}
}
