package com.dfs;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		// root.left.left.left = new TreeNode(8);
		// root.left.left.right = new TreeNode(9);
		// root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);

		// List<TreeNode> result = new ArrayList<>();
		// getAllNode(root, result);
		// for (TreeNode tmp : result)
		// System.out.println(tmp.val);

		List<Integer> list = new ArrayList<>();
		boolean[] print = new boolean[1];
		print[0] = true;
		getAllTreePath(root, list, print);

	}

	public static void getAllNode(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		result.add(root.val);
		getAllNode(root.left, result);
		getAllNode(root.right, result);
	}

	public static void getAllTreePath(TreeNode root, List<Integer> list, boolean[] print) {
		if (root == null) {
			if (print[0] == true) {
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.println();
				list.remove(list.size() - 1);
				print[0] = false;
			}
			return;
		}
		list.add(root.val);
		getAllTreePath(root.left, list, print);
		getAllTreePath(root.right, list, print);
		print[0] = true;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
