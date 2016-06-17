package leetcode;

import java.util.Arrays;

public class LC226 {

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
			
			invertTree(tree1);
		}

//		Arrays
		 public static TreeNode invertTree(TreeNode root) {
		        if(root!=null){
		            TreeNode tem=root.right;
		            root.right=root.left;
		            root.left=tem;
		            invertTree(root.left);
		            invertTree(root.right);
		        }
		        return root;
		    }
		  
	}

//	class TreeNode{
//		int value=0;
//		TreeNode left=null;
//		TreeNode right=null;
//		
//		public TreeNode(int value,TreeNode left,TreeNode right){
//			this.value=value;
//			this.left=left;
//			this.right=right;
//		}
//	}

