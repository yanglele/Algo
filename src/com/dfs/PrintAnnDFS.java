package com.dfs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintAnnDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = 4;
		Pattern pattern = Pattern.compile("[0-9]+");
		System.out.println("please enter the num of n:");
		String input = in.nextLine();
		while (!input.equals("q")) {
			Matcher matcher = pattern.matcher(input);
			boolean isMatcher = matcher.matches();
			if (isMatcher) {
				n = Integer.valueOf(input);
				System.out.println("n=" + n);
				int[] a = new int[n];
				int[] book = new int[n];
				dfs(0, a, book, n);
				System.out.println("please enter the num of n:");
			} else {
				System.out.println("please enter the int value!");
				System.out.println("please enter the num of n:");
			}
			input = in.nextLine();
		}
	}

	// dfs递归求全排列，step为计算到第几个数至
	public static void dfs(int step, int[] a, int[] book, int n) {

		if (step == n) {
			for (int tmp : a)
				System.out.print(tmp + " ");
			System.out.println();
			return;
		}

		// 对每一个位置都进行n次循环，分别求出所组成的数组
		for (int i = 0; i < n; i++) {
			if (book[i] == 0) {
				a[step] = i + 1;
				book[i] = 1;
				dfs(step + 1, a, book, n);
				book[i] = 0;
			}
		}
		return;
	}

}
