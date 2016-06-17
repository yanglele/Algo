package alogo;

public class FindTheMaxSubSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 1, 2, 3, -10, 5, 7, 9 };
		FindTheMaxSubSum test = new FindTheMaxSubSum();
		int result = test.findTheMaxSubSum(a);
		System.out.println("MaxSubSum=" + result);
	}

	// 穷举法，复杂度O(n^2)
	public int findTheMaxSubSum(int[] a) {
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

}
