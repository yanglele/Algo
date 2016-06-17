package leetcode_1;

import java.util.LinkedList;

public class LC111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;
		int count = 0;
		int cur = 0;
		int next = 1;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			
			count++;
			if (root.left == null && root.right == null) {
				return count;
			}
			for(int i=0;i<next;i++){
				
			}

		}

		return 0;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
