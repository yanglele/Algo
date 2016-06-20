package alogo;

import java.util.ArrayList;
import java.util.List;

//公共序列可以不连续
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		int b = 11;
		String arr = "akqrshrengxqiyxuloqk";
		String arr1 = "tdzbujtlqhecaqgwfzbc";

		longestCommonSubSequenceDp(arr, arr1);
		// System.out.println(b);
		// System.out.println(0.06 + 0.01);
		// BigDecimal newa = new BigDecimal(a);
		// System.out.println(newa);
		// if (a == b)
		// System.out.println("a==b");
		// System.out.println(longestCommonSubSequence(arr, arr1));
		// traverse(arr, arr1);
	}

	// 暴力求解，先求出较小字符串的所有子串，然后求出另一字符串包含这些子串的最长子串，即为所求值，时间复杂度无法忍受
	// O(Z^N)
	public static int longestCommonSubSequence(String arr1, String arr2) {
		if (arr1 == null || arr2 == null)
			return Integer.MIN_VALUE;
		String newString1 = null;// duan
		String newString2 = null;// chang
		List<String> list = new ArrayList<>();
		int result = Integer.MIN_VALUE;
		if (arr1.length() < arr2.length()) {
			newString1 = arr1;
			newString2 = arr2;
		} else {
			newString1 = arr2;
			newString2 = arr1;
		}
		list = getAllSubSequence(newString1);
		for (String tmpList : list) {
			if (ifContainTheString(newString2, tmpList)) {
				int tmpListLength = tmpList.length();
				if (tmpListLength > result)
					result = tmpListLength;
				// System.out.println("tmpListLength=" + tmpListLength);
			}
		}
		return result;
	}

	// s1包含s2
	public static boolean ifContainTheString(String s1, String s2) {
		// U.p("s1: " + s1 + " s2: " + s2);
		int location = 0;
		int count = 0;
		int length = s2.length();
		for (int i = 0; i < s2.length(); i++) {
			while (location < s1.length() && s1.charAt(location) != s2.charAt(i))
				location++;
			if (location < s1.length() && s1.charAt(location) == s2.charAt(i)) {
				location++;
				count++;
			}
		}
		if (count == length)
			return true;
		else
			return false;
	}

	public static List<String> getAllSubSequence(String arr) {
		List<String> result = new ArrayList<>();
		int arrLength = arr.length();
		int count = (int) Math.pow(2, arr.length());

		for (int i = 1; i < count; i++) {

			String binary = Integer.toBinaryString(i);
			// System.out.println("binary=" + binary);
			int binaryLength = binary.length();
			char[] charArr = new char[arrLength];
			for (int n = 0; n < charArr.length; n++)
				charArr[n] = '0';
			// System.out.println("---");
			// System.out.println(charArr[0]);
			int needZeroNum = arrLength - binaryLength;
			StringBuilder resultString = new StringBuilder(); // 补齐位数
			for (int j = 0; j < needZeroNum; j++) {
				charArr[j] = 0;
			}
			for (int k = 0; k < binaryLength; k++) {
				charArr[needZeroNum + k] = binary.charAt(k);
			}
			for (int m = 0; m < arrLength; m++) {
				if (charArr[m] == '1')
					resultString.append(arr.charAt(m));
			}
			result.add(resultString.toString());
			// System.out.println(resultString);
		}
		return result;
	}

	// DP算法O(N*N)
	// http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
	public static void longestCommonSubSequenceDp(String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		int[][] arr = new int[length1 + 1][length2 + 1];// 数组默认付初值0；

		for (int i = 1; i < length1 + 1; i++) {
			for (int j = 1; j < length2 + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
			}
		}

		// 打印数组
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

		// 在填写过程中我们还是记录下当前单元格的数字来自于哪个单元格，以方便最后我们回溯找出最长公共子串。
		// 有时候左上、左、上三者中有多个同时达到最大，那么任取其中之一，但是在整个过程中你必须遵循固定的优先标准。在我的代码中优先级别是左上>左>上。

		while (length1 > 0 && length2 > 0) {
			if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
				System.out.print(s1.charAt(length1 - 1));
				length1--;
				length2--;
			} else if (arr[length1][length2 - 1] >= arr[length1 - 1][length2]) {
				length2--;
			} else {
				length1--;
			}
		}
	}
}
