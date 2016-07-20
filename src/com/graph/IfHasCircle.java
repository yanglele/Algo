package com.graph;

public class IfHasCircle {

	private static int descx = 0;
	private static int N = 5;// number of city
	private static boolean hasCircle = false;
	private static int countNode = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[][] arr = new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1,
		// 0, 0 }, { 1, 0, 0, 0 } };
		int[][] arr = new int[][] { { 0, 1, 1, 0, 0 }, { 1, 0, 0, 1, 0 }, { 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 } };
		boolean[] book = new boolean[N];
		dfs(arr, book, descx, -1);
		System.out.println(hasCircle);
		System.out.println(countNode);
	}

	// 判断是否有环，计算相连节点个数
	// 同样适合于有向图
	public static void dfs(int[][] arr, boolean book[], int cur, int lastNode) {

		// 若此点已访问则说明有环，返回
		if (book[cur] == true) {
			hasCircle = true;
			return;
		}

		book[cur] = true;
		countNode++;
		for (int i = 0; i < N; i++) {
			// 若有边且不是与父节点的边，则继续，若是，因为是无向图，不处理
			if (arr[cur][i] == 1 && i != lastNode) {
				dfs(arr, book, i, cur);
			}
		}
		return;
	}

}
