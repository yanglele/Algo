package alogo;

//use recursion to FindTheMaxSubSum2 O(NLogN)
public class FindTheMaxSubSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, -3, 5, -2, 1 };
		int[] b = { -3, -2, -1 };
		FindTheMaxSubSum2 test = new FindTheMaxSubSum2();
		int result = test.findTheMaxSubSum(b);
		System.out.println("max=" + result);
	}

	// 对这个问题，有一个相对复杂的O(NlogN)的解法，就是使用递归。该方法我们采用“分治策略”（divide-and-conquer）。
	// 在我们例子中，最大子序列可能在三个地方出现，或者在左半部，或者在右半部，或者跨越输入数据的中部而占据左右两部分。
	// 前两种情况递归求解，第三种情况的最大和可以通过求出前半部分最大和（包含前半部分最后一个元素）以及后半部分最大和（包含后半部分的第一个元素）相加而得到。
	public int findTheMaxSubSum(int[] a, int left, int right) {
		// base case
		if (left == right)
			// if (a[left] > 0)
			return a[left];
		// else
		// return 0;

		int middle = (left + right) / 2;
		int leftMaxSum = findTheMaxSubSum(a, left, middle);
		int rightMaxSum = findTheMaxSubSum(a, middle + 1, right);
		int leftBorderSum = 0, maxLeftBorderSum = Integer.MIN_VALUE;
		for (int i = middle; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int rightBorderSum = 0, maxRightBorderSum = Integer.MIN_VALUE;
		for (int i = middle + 1; i <= right; i++) {
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return sum3(leftMaxSum, rightMaxSum, maxRightBorderSum + maxLeftBorderSum);
	}

	public int sum3(int a, int b, int c) {
		return ((a > b ? a : b) > c ? ((a > b ? a : b)) : c);
	}

	public int findTheMaxSubSum(int[] a) {
		return findTheMaxSubSum(a, 0, a.length - 1);
	}
}
