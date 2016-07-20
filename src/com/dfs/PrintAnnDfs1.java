package com.dfs;

import java.util.ArrayList;
import java.util.List;

public class PrintAnnDfs1 {

	private static int N = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] book = new boolean[N];
		List<Integer> list = new ArrayList<>();
		dfs(0, book, list);
	}

	public static void dfs(int step, boolean book[], List<Integer> list) {

		if (step == N) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (book[i] == false) {
				book[i] = true;
				list.add(i + 1);
				dfs(step + 1, book, list);
				book[i] = false;
				list.remove(step);
			}
		}
	}
}
