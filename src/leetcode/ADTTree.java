package leetcode;

public class ADTTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean contains(TreeNode root, int value) {
		if (root == null) {
			return false;
		}
		if (value < root.value)
			return contains(root.left, value);
		else if (value > root.value)
			return contains(root.right, value);
		else
			return true;
	}

	public TreeNode findMin(TreeNode root) {

		if (root == null)
			return null;
		else if (root.left == null)
			return root;
		else
			return findMin(root.left);
	}

	public TreeNode findMax(TreeNode root) {
		if (root == null)
			return null;
		else if (root.right == null)
			return root;
		else {
			return findMax(root.right);
		}
	}

	public TreeNode insertNode(TreeNode root, int value) {
		if (root == null)
			return new TreeNode(value, null, null);
		else if (value < root.value)
			root.left = insertNode(root.left, value);
		else if (value > root.value)
			root.right = insertNode(root.right, value);
		else
			;
		return root;

	}

	public TreeNode deleteNode(TreeNode root, int value) {

		if (root == null)//找不到返回
			return root;
		if (value > root.value) {
			deleteNode(root.right, value);
		} else if (value < root.value) {
			deleteNode(root.left, value);
		}else if(root.left != null && root.right != null){//两个子节点
			root.value=findMin(root.right).value;
			root.right=deleteNode(root.right, root.value);
		}else root=root.left != null?root.left:root.right;//一个或者无子节点
		return root;
	}
}
