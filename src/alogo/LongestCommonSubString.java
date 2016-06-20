package alogo;

import java.util.ArrayList;
import java.util.List;

//公共子串需要连续
public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "caba";
		String s2 = "bab";
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
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0)
						arr[i][j] = arr[i - 1][j - 1] + 1;
					else
						arr[i][j] = 1;
				}
			}

		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	// 进而优化为一维数组记录值
	public static void getLongestCommonSubString2(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[] arr = new int[n];
		for (int i = 0; i < m; i++) {

			for (int j = n - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0)
						arr[j] = arr[j - 1] + 1;
					else
						arr[j] = 1;
				} else
					arr[j] = 0;
			}
		}

		int max = 0;
		for (int tmp : arr) {
			if (tmp > max)
				max = tmp;
		}
		System.out.println(max);
	}
}