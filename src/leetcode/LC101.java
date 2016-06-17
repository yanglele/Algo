package leetcode;

import org.omg.CORBA.FloatSeqHelper;

public class LC101 {
	
	static class StopMsgException extends RuntimeException{}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean isSymmetric(TreeNode root) {
			
			if(root == null || (root .left==null && root.right==null))
				return true;
		    else if(root.left == null)
		        return false;
		   else if(root.right == null)
		        return false;
			TreeNode tree1=root.left;
			TreeNode tree2=root.right;
			return isSymmetric1(tree1, tree2);
		}
		
		public boolean isSymmetric1(TreeNode tree1,TreeNode tree2){
			
			if(tree1 == tree2 && tree1==null)
				return true;
				else if(tree1==null)
				return false;
				else if(tree2==null)
				return false;
			else
			return tree1.value==tree2.value&&isSymmetric1(tree1.left, tree2.right)&&isSymmetric1(tree1.right, tree2.left);
		}
	

//	 public boolean isSymmetric(TreeNode root) {
//		 if(root == null)
//			 return true;
//		 else {
//			return isSymmetric1(root.left, root.right);
//		}
//	    }
//	 
//	 public boolean isSymmetric1(TreeNode left,TreeNode right){
//		 if(left == null && right == null)
//			 return true;
//		 else if(left == null)
//			 return false;
//		 else if(right == null)
//			 return false;
//		 else{
//			 if(left.value != right.value)
//				 return false;
//			 else{
//				 return isSymmetric1(left.left, right.right)&&isSymmetric1(left.right, right.left);
//			 }
//		 }
//		
//	 }
}


