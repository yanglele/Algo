package alogo;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode r1 = new TreeNode(6);
		TreeNode r2 = new TreeNode(4);
		TreeNode r3 = new TreeNode(7);
		TreeNode r4 = new TreeNode(1);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(8);

		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.right = r6;

		// Integer aInteger = new Integer(968);
		// getNum(aInteger);
		// System.out.println("aInteger=" + aInteger);

		int[] a = { 1, 2 };
		getNum(a);
		System.out.println(a[0]);
	}

	public static void getNum(Integer a) {
		a = new Integer(998);
		System.out.println("a=" + a);
	}

	public static void getNum(int[] a) {
		a[0] = 100;
	}
}
