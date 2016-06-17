package leetcode;

import java.util.Arrays;

public class LC100 {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null)
			return false;
		else
			return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	
//	public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null || q==null)
//            return p==q;
//        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
//    }
}
