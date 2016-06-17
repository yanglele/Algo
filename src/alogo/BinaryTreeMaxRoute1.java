package alogo;

import javax.xml.bind.ValidationEvent;

public class BinaryTreeMaxRoute1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Node node1=new Node(5);
//		node1.left=new Node(2);
//		node1.right=new Node(3);
//		node1.left.left=new Node(100);
//		node1.left.right=new Node(100);
		
		Node node1 = new Node(3);
		node1.left = new Node(5);
		node1.right = new Node(4);
		node1.left.left = new Node(1);
		node1.left.right = new Node(2);
		node1.right.left = new Node(7);
		node1.right.right = new Node(8);
		node1.right.left.left = new Node(2);
		getMaxSum(node1);
		System.out.println("Max= "+max);
	}

	private static int max=Integer.MIN_VALUE;
	 
	public static int getMaxSum(Node root){
		int result=root.val;
		int lmax=0,rmax=0;
		
		if(root.left != null){
			lmax=getMaxSum(root.left);
			if(lmax>0){
				result=root.val+lmax;
			}
			if(lmax > max)
				max=lmax;
		}
		
		if(root.right != null){
			rmax=getMaxSum(root.right);
			if(rmax+root.val > result)
				result=root.val+rmax;
			if(rmax > max)
				max=rmax;
		}
		
		if(result > max)
			max=result;
		if(lmax+rmax+root.val > max){
			max=lmax+rmax+root.val;
			System.out.println("val= "+root.val);
		}
			
		return result;
	}
}
