package alogo;

/*
 * 1. 从任意一个节点u开始做第一遍BFS，得到距离u最远的那个节点v 
 * 2. 从节点v开始做第二遍BFS，得到距离v最远的节点 e, 那 v 到 e 就是直径 。
 * */

public class BTDiameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node1 = new Node(3);
		node1.left = new Node(5);
		node1.right = new Node(4);
		node1.left.left = new Node(1);
		node1.left.right = new Node(2);
		node1.right.left = new Node(7);
		node1.right.right = new Node(8);
		node1.right.left.left = new Node(2);
		System.out.println(getBTDiameter(node1));
	}

	private static int max=Integer.MIN_VALUE;
	public static int getBTDiameter(Node root){
		if(root != null){
			int tmp=getSubTreeDiameter(root);
			//System.out.println("tmp= "+tmp);
			if(tmp > max)
				max=tmp;
			getBTDiameter(root.left);
			getBTDiameter(root.right);
		}
		return max;
	}
	
	public static int getSubTreeDiameter(Node root){
		
		return getMaxDeep(root.left)+getMaxDeep(root.right)+1;
	}
	
	public static int getMaxDeep(Node root){
		if(root == null)
			return 0;
		int i=getMaxDeep(root.left)+1;
		int j=getMaxDeep(root.right)+1;
		return i>j?i:j;
	}
}
