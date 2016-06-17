package leetcode;

public class LC235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		TreeNode result=null;
		if(p.value<=root.value && q.value>=root.value  || p.value>=root.value && q.value<=root.value)
			return root;
		else{
			if(p.value>root.value && root != null){
				result=lowestCommonAncestor(root.right, p, q);
			}else if(p.value<root.value && root != null)
				result=lowestCommonAncestor(root.left, p, q);
		}
		return result;
	}
	

	
//public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//	while(root != null){
//		if(p.value>root.value && q.value>root.value)
//			root=root.right;
//		else if(q.value<root.value && p.value<root.value)
//			root=root.left;
//		else break;  
//	}
//	  return root;
//    }
}
