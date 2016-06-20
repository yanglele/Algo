package alogo;

import java.util.ArrayList;
import java.util.List;

//公共子串需要连续
public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "cabcab";
		String s2 = "cab";
		getLongestCommonSubString2(s1, s2);
	}

	// for遍历 要求连续 O(N*N)-O(N*N*N)之间
	public static void traverse(String s1, String s2) {
		int aLength = s1.length();
		int bLength = s2.length();
		int maxLength = 0;
		int curLength = 0;
		List<String> result = new ArrayList<>();
		for (int i = 0; i < aLength; i++) {
			for (int j = 0; j < bLength; j++) {
				if (s1.charAt(i) != s2.charAt(j)) {
					curLength = 0;
					continue;
				} else {
					for (int m = i, n = j; m < aLength && n < bLength; m++, n++) {
						if (s1.charAt(m) == s2.charAt(n)) {
							curLength++;
							if (curLength > maxLength) {
								maxLength = curLength;
								result.clear();
								result.add(s1.substring(m, m + curLength));
								// System.out.println(result.get(0));
							}
						} else {
							curLength = 0;
							break;
						}
					}
				}
			}
		}
		System.out.println(maxLength);
		System.out.println(result.get(0));
	}

	// 通过构建二维数组记录比较值，进而优化为一维数组记录值O(N*N)
	public static void getLongestCommonSubString(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int max = 0;
		int index = 0;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0)
						arr[i][j] = arr[i - 1][j - 1] + 1;
					else
						arr[i][j] = 1;
					if (arr[i][j] > max) {
						max = arr[i][j];
						index = i;
					}
				}
			}

		}
		System.out.println("maxLength=" + max);

		for (int i = index + 1 - max; i <= max; i++) {
			System.out.print(s1.charAt(i) + " ");
		}
	}

	// 进而优化为一维数组记录值,并打印最长公共子串
	public static void getLongestCommonSubString1(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[] arr = new int[n];
		int maxLength = 0;
		int index = 0;
		for (int i = 0; i < m; i++) {

			for (int j = n - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0)
						arr[j] = arr[j - 1] + 1;
					else
						arr[j] = 1;
					if (arr[j] > maxLength) {
						maxLength = arr[j];
						index = j;
					}
				} else
					arr[j] = 0;
			}
		}

		System.out.println(maxLength);
		printSubString(index, s2, maxLength);

	}

	// 通过构建二维数组记录比较值，输出所有最长子序列
	public static void getLongestCommonSubString2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int max = 0;
		int index = 0;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0)
						arr[i][j] = arr[i - 1][j - 1] + 1;
					else
						arr[i][j] = 1;
					if (arr[i][j] > max) {
						max = arr[i][j];
						index = i;
					}
				}
			}

		}
		System.out.println("max=" + max);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == max)
					printSubString(j, s2, max);// 使用s2
			}
		}
	}

	public static void printSubString(int index, String s1, int max) {
		// System.out.println("index=" + index);
		// System.out.println("max=" + max);
		for (int i = index + 1 - max; i <= index; i++) {
			System.out.print(s1.charAt(i));
		}
		System.out.println();
	}
}