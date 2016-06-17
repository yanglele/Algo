package alogo;

//Java求二叉树的最大路径和
/*
 * 如下图所示：
最大路径为2 - 5 - 3 - 4 - 7 -2 ，则最大路径和为23。

在寻求最大路径时需要注意的是对于二叉树
    v
   /  \
  v1 v2

只有v，v+v1，v+v2这三个值的最大者才能返回给上一级。
 * */
// http://www.voidcn.com/blog/sinat_26888717/article/p-4439626.html

public class BinaryTreeMaxRoute {
	public static void main(String[] args) {
		Node node1 = new Node(3);
		node1.left = new Node(5);
		node1.right = new Node(4);
		node1.left.left = new Node(1);
		node1.left.right = new Node(2);
		node1.right.left = new Node(7);
		node1.right.right = new Node(8);
		node1.right.left.left = new Node(2);
		// Node node1=new Node(5);
		// node1.left=new Node(2);
		// node1.right=new Node(3);
		// node1.left.left=new Node(100);
		// node1.left.right=new Node(100);
		BinTree bt = new BinTree();
		int n = bt.maxPathSum(node1);
		System.out.println(n);
	}
}

class Node {
	int val;
	Node left;
	Node right;

	public Node(int x) {
		this.val = x;
	}
}

class BinTree {
	public BinTree() {

	}

	// max为每次递归之后的最大路径和
	private int max;

	// travel函数递归执行子树并求子树的最大路径
	private int travel(Node node) {
		int val = node.val;
		// lval,rval分别为左子树和右子树的最大路径值
		int lval = 0, rval = 0;
		// result是可以返回给上一级树的路径值
		int result = val;
		/*
		 * 每次的travel函数中max是该级子树的最大路径值（该级子树最大路径值并不一定可以返回给上一级）
		 * 只有val,val+lval,val+rval其中之一才可以返回给上一级。 关键的是，max用来保存所有子树的最大路径值
		 */
		// 逐级寻找应该返回到上一级的result和当前最大max
		// result为val,val+lval,val+rval三者最大值
		// max为lval,rval,result, val + lval + rval中最大值，即为所求结果。
		if (node.left != null) {
			lval = travel(node.left);
			if (lval > 0) {
				result = val + lval;
			}
			if (max < lval) {
				max = lval;
			}
		}

		if (node.right != null) {
			rval = travel(node.right);
			if (result < val + rval) {
				result = val + rval;
			}
			if (max < rval) {
				max = rval;
			}
		}

		if (max < result) {
			max = result;
		}

		if (max < val + lval + rval) {
			max = val + lval + rval;
		}

		return result;
	}

	public int maxPathSum(Node root) {
		max = Integer.MIN_VALUE;
		travel(root);
		return max;
	}
}