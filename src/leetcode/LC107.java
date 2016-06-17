package leetcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		TreeNode tree9=new TreeNode(9,null,null);
		TreeNode tree8=new TreeNode(8,null,null);
		TreeNode tree7=new TreeNode(7,null,null);
		TreeNode tree6=new TreeNode(6,null,null);
		TreeNode tree5=new TreeNode(5,null,null);
		TreeNode tree4=new TreeNode(4,tree8,tree9);
		TreeNode tree3=new TreeNode(3,tree6,tree7);
		TreeNode tree2=new TreeNode(2,tree4,tree5);
		TreeNode tree1=new TreeNode(1,tree2,tree3);
		List<List<Integer>> list=levelOrderBottom(tree1);
		
		
	}

	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		 if(root == null)
				return new LinkedList<>();
			List<List<Integer>> list=new LinkedList<>();
			LinkedList<TreeNode> quenue=new LinkedList<>();
			
			quenue.add(root);
			
			int cur=1;
			int next=0;
			
			while(!quenue.isEmpty()){
				LinkedList<Integer> list2=new LinkedList<>();
				for(int i=0;i<cur;i++){
					if(quenue.get(0).left != null){
						quenue.add(quenue.get(0).left);
						next++;
					}
					if(quenue.get(0).right != null){
						quenue.add(quenue.get(0).right);
						next++;
					}
					list2.add(quenue.poll().value);
				}
				list.add(0, list2);
				cur=next;
				next=0;
			}
			return list;
	}
	
//
//	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//		if(root == null)
//			return new LinkedList<>();
//		
//		List<List<Integer>> result=new ArrayList<List<Integer>>();
//		LinkedList<TreeNode> queue=new LinkedList<>();
//		TreeNode tem=root;
//		
//		queue.add(root);
//		int curr=1;
//		int next=0;
//		List<Integer> insert=new ArrayList<>();
//		while(!queue.isEmpty()){
//			tem=queue.poll();
//			curr--;
//			insert.add(tem.value);
//			
//			if(tem.left!=null){
//				queue.add(tem.left);
//				next++;
//			}
//			
//			if(tem.right != null){
//				queue.add(tem.right);
//				next++;
//			}
//			
//			if(curr == 0){
//				curr=next;
//				next=0;
//				result.add(0, insert);
//				insert=new ArrayList<>();
//			}
//		}
//		return result;

	
	}

