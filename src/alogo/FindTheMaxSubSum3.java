package alogo;

//http://www.cnblogs.com/CCBB/archive/2009/04/25/1443455.html
public class FindTheMaxSubSum3 {

	// 线性的算法O(N)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 4, -3, 5, -2, 1 };
		int[] b = { -3, -2, -1 };
		FindTheMaxSubSum3 test = new FindTheMaxSubSum3();
		int result = test.findTheMaxSubSum3(b);
		System.out.println("max=" + result);
	}

	// maxNum用于记录最大的元素，当数组全负时输出此值
	public int findTheMaxSubSum3(int[] a) {
		int maxSum = 0, thisSum = 0, maxNum = Integer.MIN_VALUE, maxNumIndex = 0;
		int left = 0, savedLeft = 0, savedRight = 0;// 用于记录最大最小值边界
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxNum) {
				maxNum = a[i];
				maxNumIndex = i;
			}
			thisSum += a[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
				savedLeft = left;
				savedRight = i;
			}
			if (thisSum < 0) {
				thisSum = 0;
				left = i + 1;
			}
		}
		if (maxNum <= 0) {
			System.out.println("maxNumIndex=" + maxNumIndex);
			return maxNum;
		} else {
			System.out.println("left=" + savedLeft + " right=" + savedRight);
			return maxSum;
		}
	}
}
