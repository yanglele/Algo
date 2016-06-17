package leetcode;

public class LC104 {

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
		
		int result=maxDepth(tree1);
		System.out.println("result="+result);
	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int i = maxDepth(root.left) + 1;
		//System.out.println("i=  "+i);
		int j = maxDepth(root.right) + 1;
		//System.out.println("j=  "+j);
		int c=i > j ? i : j;
		return c;
	}

}

class TreeNode{
	int value=0;
	TreeNode left=null;
	TreeNode right=null;
	
	public TreeNode(int value,TreeNode left,TreeNode right){
		this.value=value;
		this.left=left;
		this.right=right;
	}
}
