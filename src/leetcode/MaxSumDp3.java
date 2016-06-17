package leetcode;

public class MaxSumDp3 {

	/*
	 * 解法一：时间复杂度为O(n^3) 求一个数组的最大子数组和，我想最直观最野蛮的办法便是，三个for循环三层遍历，求出数组中每一个子数组的和，
	 * 最终求出这些子数组的最大的一个值。 令currSum[i, …, j]为数组A中第i个元素到第j个元素的和（其中0 <= i <= j < n），
	 * maxSum为最终求到的最大连续子数组的和。
	 * 且当全是负数的情况时，我们可以让程序返回0，也可以让程序返回最大的那个负数，这里，我们让程序返回最大的那个负数。
	 */
	int MaxSubArray(int[] A, int n) {
		int maxSum = A[0]; // 全负情况，返回最大负数
		int currSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = i; k <= j; k++) {
					currSum += A[k];
				}
				if (currSum > maxSum)
					maxSum = currSum;

				currSum = 0; // 这里要记得清零，否则的话sum最终存放的是所有子数组的和。
			}
		}
		return maxSum;
	}

	/**
	 * 事实上，当我们令currSum为当前最大子数组的和，maxSum为最后要返回的最大子数组的和，当我们往后扫描时，
	 * 对第j+1个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素；
	 * 如果currSum加上当前元素a[j]后不小于a[j]，则令currSum加上a[j]，否则currSum重新赋值，置为下一个元素，
	 * 即currSum = a[j]。 同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
	 */
	int MaxSubArray2(int[] a, int n) {
		int currSum = 0;
		int maxSum = a[0]; // 全负情况，返回最大数

		for (int j = 0; j < n; j++) {
			currSum = (a[j] > currSum + a[j]) ? a[j] : currSum + a[j];
			maxSum = (maxSum > currSum) ? maxSum : currSum;

		}
		return maxSum;
	}
}
