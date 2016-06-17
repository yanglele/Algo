package com.dfs;

public class prinkCnkRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int k = 3;
		int[] a = new int[n];
		int[] newA = new int[k];
		for (int i = 0; i < n; i++)
			a[i] = i + 1;

		Rec(n, k, a, newA, 1, 0);
	}

	// level 1
	public static void Rec(int n, int k, int a[], int newA[], int level, int begin) {
		if (0 == k) {
			for (int tmp : newA)
				System.out.print(tmp + " ");
			System.out.println();
			return;
		}

		if (n < k)
			return;

		newA[level - 1] = a[begin];
		Rec(n - 1, k - 1, a, newA, level + 1, begin + 1);
		Rec(n - 1, k, a, newA, level, begin + 1);
	}
}
