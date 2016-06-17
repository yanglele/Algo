package leetcode;

import org.omg.PortableInterceptor.IORInterceptor;

public class LC110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public boolean isBalanced(TreeNode root) {
		
		if(root == null )
			return true;
		if(Math.abs(treeHeight(root.left)-treeHeight(root.right))>1)
			return false;
		else
			return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	public int treeHeight(TreeNode root){
		if(root == null)
			return 0;
		int i=treeHeight(root.left)+1;
		int j=treeHeight(root.right)+1;
		return i>j?i:j;
	}
	

}
 class Solution {
    static class StopMsgException extends RuntimeException{}
    
	public boolean isBalanced(TreeNode root) {

		try{
			treeHeight(root);
		}catch(StopMsgException e){
			return false;
		}
		return true;
	}
	
	public int treeHeight(TreeNode root){
		if(root == null)
			return 0;
			int left=treeHeight(root.left)+1;
			int right=treeHeight(root.right)+1;
			if(Math.abs(left-right)>1)
				throw new StopMsgException();
			return left>right?left:right;
			
	}
}