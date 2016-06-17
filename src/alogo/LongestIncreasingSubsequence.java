package alogo;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1, 4, 5, 6, 8, 2, 5, 11 };
		// int result = binarySearch1(arr, 0, 0, arr.length - 1);
		// System.out.println(result);
		int length = arr.length;
		int result = getLongestIncreasingSubsequence2(arr, length);
		System.out.println(result);
	}

	// 只计算最长子数组数目
	// 动态规划 O（N*N）
	// 即求以每个数组元素为结尾的数组的最大子升序数组长度，然后求其最大值
	// 第i个数的最大升序子数组=其前i-1个数的最大升序子数组+1
	// 前i-1个数的最大升序子数组求法：求出0--i-1中以每个数字结尾的最大子数组长度，若rr[j] < arr[i] &&longest[j] +
	// 1 > longest[i]，
	// 则更新longest[i]的值
	public static int getLongestIncreasingSubsequence(int[] arr, int length) {
		int[] longest = new int[length];
		int maxResult = 0;

		// 赋初值
		for (int i = 0; i < length; i++)
			longest[i] = 1;

		if (length == 0 || length == 1)
			return length;

		// DP
		for (int i = 1; i < length; i++)
			for (int j = 0; j < length - 1; j++) {
				if (arr[j] < arr[i] && longest[j] + 1 > longest[i])
					longest[i] = longest[j] + 1;
			}

		// 遍历求最大子数组值
		for (int tmp : longest)
			if (tmp > maxResult)
				maxResult = tmp;

		return maxResult;
	}

	// DP
	// 只计算最长子数组数目，并记录其子数组值
	public static int getLongestIncreasingSubsequence1(int[] arr, int length) {
		int[] longest = new int[length];
		int maxResult = 0;
		int[][] resultArr = new int[length][length];

		// 赋初值
		for (int i = 0; i < length; i++)
			longest[i] = 1;

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				resultArr[i][j] = Integer.MIN_VALUE;

		if (length == 0 || length == 1)
			return length;

		resultArr[0][0] = arr[0];
		// DP
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (arr[j] < arr[i] && longest[j] + 1 > longest[i]) {
					longest[i] = longest[j] + 1;

					for (int m = 0; m < length; m++)
						resultArr[i][m] = resultArr[j][m];

					for (int k = 0; k < length; k++) {
						if (resultArr[i][k] == Integer.MIN_VALUE) {
							resultArr[i][k] = arr[i];
							break;
						}

					}

				}
			}

		}

		int index = 0;
		// 遍历求最大子数组长度并记录其下标
		for (int i = 0; i < length; i++) {
			if (longest[i] > maxResult) {
				maxResult = longest[i];
				index = i;
			}
		}

		// 打印对应下标处的最长子数组的值
		for (int i = 0; i < resultArr[index].length; i++)
			if (resultArr[index][i] != Integer.MIN_VALUE)
				System.out.print(resultArr[index][i] + " ");
		System.out.println();
		return maxResult;
	}

	// O(N*LgN)算法
	// 原始数组arr【】
	// 建立一个数组arrLength[]，记录最长LIS时最小的数组arr元素，length记录当前最长数组值
	// arrlength【】建立过程：放入首元素，下一个元素大于当前元素时，将其放入arrlength数组，length+1，
	// 当其小于当前元素时，从小到大按顺序找到其位置，更新arrlength【】的值。
	// arrlength【】不是LIS，它只是存储的对应长度LIS的最小末尾。有了这个末尾，我们就可以一个一个地插入数据
	// 因为当需要替换arrlength[]中的值时，longestResult不变，即此替换不影响longestResult长度，但替换后longestResult数组为有序的，可以方便下次查找替换
	// 不需替换时，直接加数据到数组尾部，长度+1；
	public static int getLongestIncreasingSubsequence2(int[] arr, int length) {
		int[] arrLeastNum = new int[length];

		if (length == 0 || length == 1)
			return length;

		for (int i = 0; i < length; i++)
			arrLeastNum[i] = Integer.MIN_VALUE;

		int longestResult = 1;
		arrLeastNum[0] = arr[0];

		for (int i = 1; i < length; i++) {
			// boolean changed = false;
			// for (int j = 0; j < longestResult; j++) {
			// if (arrLeastNum[j] > arr[i]) {
			// arrLeastNum[j] = arr[i];
			// changed = true;
			// break;
			// }
			// }
			// if (!changed) {
			// arrLeastNum[longestResult] = arr[i];
			// longestResult++;
			// }

			// 使用二分查找降低时间复杂度
			int index = binarySearch1(arrLeastNum, arr[i], 0, longestResult - 1);
			arrLeastNum[index] = arr[i];
			if (index >= longestResult)
				longestResult++;
		}

		return longestResult;
	}

	// 二分查找 循环
	public static int binarySearch(int[] arr, int num, int left, int right) {

		while (left <= right) {
			int middle = left + ((right - left) >> 1);//// 防止溢出，移位也更高效。同时，每次循环都需要更新。

			// 可能会有读者认为刚开始时就要判断相等，但毕竟数组中不相等的情况更多
			// 如果每次循环都判断一下是否相等，将耗费时间
			if (arr[middle] < num)
				left = middle + 1;
			else if (arr[middle] > num)
				right = middle - 1;
			else
				return middle;
		}
		return -1;
	}

	// 二分查找 递归
	public static int binarySearchRec(int[] arr, int num, int left, int right) {

		if (left > right)
			return -1;

		int middle = left + ((right - left) >> 1);
		if (arr[middle] == num)
			return middle;
		else if (arr[middle] > num) {
			return binarySearchRec(arr, num, left, middle - 1);
		} else
			return binarySearchRec(arr, num, middle + 1, right);

	}

	// 修改的二分法，找到时返回下标，没找到时返回数组中大于num最小数的下标
	//
	public static int binarySearch1(int[] arr, int num, int left, int right) {
		while (left <= right) {
			int middle = left + ((right - left) >> 1);//// 防止溢出，移位也更高效。同时，每次循环都需要更新。

			if (arr[middle] < num)
				left = middle + 1;
			else if (arr[middle] > num)
				right = middle - 1;
			else
				return middle;
		}
		return left;// 找不到时返回数组中大于num最小数的下标，若大于数组最大值，返回arr.length
		// return right;// 找不到时返回数组中小于num最小数的下标，若小于数组最小值，返回-1
	}

}
