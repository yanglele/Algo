package leetcode_1;

import java.util.ArrayList;

public class LC112 {

	private static boolean result = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC112 test=new LC112();
		TreeNode node1=test.new TreeNode(1);
		TreeNode node2=test.new TreeNode(2);
		TreeNode node3=test.new TreeNode(3);
		TreeNode node4=test.new TreeNode(4);
		TreeNode node5=test.new TreeNode(6);
		
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		System.out.println(hasPathSum(node1, 7));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;
		int cur = root.val;
		setResult(root, cur, sum);
		return result;
	}

	public static void setResult(TreeNode root, int cur, int sum) {

		if (result == false && root != null) {
			if (root.left == null && root.right == null && cur == sum) {
				result = true;
			}
			if(root.left != null)
			setResult(root.left, cur + root.left.val, sum);
			if(root.right != null)
			setResult(root.right, cur + root.right.val, sum);
		}

	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
