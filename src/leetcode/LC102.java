package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//   3
//  / \
// 9  20
//   /  \
//  15   7
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
public class LC102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public List<List<Integer>> levelOrder(TreeNode root) {
	     if(root == null)
	    	 return new ArrayList<>();
	     
	     List<List<Integer>> list=new ArrayList<>();
	     List<Integer> list1;
	     Queue<TreeNode> queue=new LinkedList<>();
	     int curr=1;
	     int next=0;
	     queue.add(root);
	     while(!queue.isEmpty()){
	    	 list1=new ArrayList<>();
	    	 while(curr != 0){
	    		 TreeNode tem=queue.poll();
	    		 curr--;
	    		 if(tem.left != null){
	    			 queue.add(tem.left);
	    			 next++;
	    		 }
	    		 if(tem.right != null){
	    			 queue.add(tem.right);
	    			 next++;
	    		 }
	    		 list1.add(tem.value);
	    	 }
	    	 curr=next;
	    	 next=0;
	    	 list.add(list1);
	     }
	     return list;
	    }
}
