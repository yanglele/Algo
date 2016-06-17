package alogo;
/*
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum up to that value. 
 * Note that it can be any path in the tree - it does not have to start at the root.
 * http://www.lai18.com/content/746242.html
 * */
public class FindThePathOfGivenNum {

//	public static void findSum(TreeNode root, int sum) {
//		int depth = depth(root);
//		int[] path = new int[depth]; // 建一个path数组，存放每一层的值
//		findSum(root, sum, path, 0);
//	}
//
//	// 递归打印所有可能
//	// path数组保存当前走过的路线，level表示当前到达的层
//	public static void findSum(TreeNode root, int sum, int[] path, int level) {
//		if (root == null) {
//			return;
//		}
//
//		path[level] = root.val; // 先为当前层赋值
//
//		// 统计从level（当前层）往上走，能否凑到sum
//		// 重要思想！
//		int t = 0;
//		for (int i = level; i >= 0; i--) {
//			t += path[i];
//			if (t == sum) {
//				print(path, i, level); // i: start, level: end
//			}
//		}
//
//		findSum(root.left, sum, path, level + 1);
//		findSum(root.right, sum, path, level + 1);
//
//		path[level] = Integer.MIN_VALUE; // 撤销当前层赋值
//	}
//
//	// 求高度
//	public static int depth(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		return 1 + Math.max(depth(root.left), depth(root.right));
//	}
//
//	public static void print(int[] path, int start, int end) {
//		for (int i = start; i <= end; i++) {
//			System.out.print(path[i] + " ");
//		}
//		System.out.println();
//	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		findSum(root, 8);
	}
	
	public static void findSum(TreeNode root,int sum){
		int deep=getDeep(root);
		int[] data=new int[deep];
		if(deep>0){
			findSum(root, sum,0,data);
		}else{
			System.out.println("null");
		}
			
	}
	
	public static void findSum(TreeNode root,int sum,int level,int[] data){
		if(root == null)
			return;
		data[level]=root.val;
		int t=0;
		for(int i=level;i>=0;i--){
			t+=data[i];
			if(t == sum){
				printPath(data, level, i);
				System.out.println();
			}		
		}
		findSum(root.left, sum,level+1,data);
		findSum(root.right, sum,level+1,data);
		data[level]=Integer.MIN_VALUE;
	}
	
	public static int getDeep(TreeNode root){
		if(root == null)
			return 0;
		int i=getDeep(root.left)+1;
		int j=getDeep(root.right)+1;
		return i>j?i:j;
	}
	
	public static void printPath(int[] data,int begin,int end){
		for(int i=begin;i>=end;i--)
			System.out.print(data[i]+" ");
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		this.val = x;
	}
}
