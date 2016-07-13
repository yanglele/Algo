package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindAllNode {

	private static int n = 5;
	private static int[][] arr = { { 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 0 }, { 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 },
			{ 1, 0, 1, 0, 0 } };
	private static int[] value = { 1, 2, 3, 4, 5 };

	private static boolean[] book = new boolean[n];
	private static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		book[0] = true;
		// dfs(0);
		System.out.println("--------------");
		bfs();
	}

	// cur为第cur个数下标
	public static void dfs(int cur) {

		// 输出此下标对应的值
		System.out.println(value[cur]);
		sum++;// 已访问的点数

		// 已访问所有点，返回
		if (n == sum) {
			return;
		}

		// 访问其邻接点
		for (int i = 0; i < n; i++) {
			if (arr[cur][i] == 1 && book[i] == false) {
				book[i] = true;
				dfs(i);
			}
		}
		// 所有邻接点访问完毕，返回
		return;
	}

	private static Queue<Integer> queue = new LinkedList<>();

	private static void bfs() {
		// 初始化
		queue.add(0);
		book[0] = true;
		int curNum = 1;
		int nextNum = 0;
		int sum = 1;
		System.out.println(value[0]);

		while (!queue.isEmpty()) {
			while (curNum > 0) {
				int cur = queue.poll();
				curNum--;
				for (int i = 0; i < n; i++) {
					if (arr[cur][i] == 1 && book[i] == false) {
						System.out.println(value[i]);
						sum++;
						if (sum == n)
							return;
						nextNum++;
						queue.add(i);
					}
				}
			}
			curNum = nextNum;
			nextNum = 0;
		}
	}
}
