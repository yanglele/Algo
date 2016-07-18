package com.graph;

import java.util.LinkedList;
import java.util.Queue;

//无向图的邻接图，求是否为树
//思路，无向图邻接图对称，
//1.对角线为1则有环
//2.然后考虑右上角数组
public class GraphTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[][] arr = new int[][] { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1,
		// 0, 0 }, { 1, 0, 0, 0 } };
		int[][] arr = new int[][] { { 0, 1, 0, 1 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };
		GraphTree test = new GraphTree();
		// System.out.println(test.isTree(arr));
		System.out.println(isTreeBfs(arr));
	}

	public static int isTree(int[][] grid) {
		int length = grid.length;
		boolean[] visited = new boolean[length];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

		for (int i = 0; i < length; i++) {
			if (grid[i][i] == 1)
				return 0;
		}

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {

				if (grid[i][j] == 1 && visited[j] == true) {
					return 0;
				}
				if (grid[i][j] == 1 && visited[j] == false) {
					visited[j] = true;
				}

			}
		}
		return 1;
	}

	// 树不能有孤立，dfs能访问点数=n
	// 树不能有环，即边数为顶点数-1，因为要求是否有环，所以不能用book记录已访问的点，这样自动屏蔽环
	public static int isTreeBfs(int arr[][]) {
		int length = arr.length;
		Queue<Integer> queue = new LinkedList<>();
		int nodeNum = 0;
		int edgeNum = 0;

		queue.add(0);
		int curNum = 1;
		int nextNum = 0;

		while (!queue.isEmpty()) {
			while (curNum > 0) {

				int cur = queue.poll();
				curNum--;
				nodeNum++;

				for (int i = cur; i < length; i++) {
					if (arr[cur][i] == 1) {
						queue.add(i);
						edgeNum++;
						nextNum++;
					}
				}
			}
			curNum = nextNum;
			nextNum = 0;
		}
		if (nodeNum == length && edgeNum == (length - 1))
			return 1;
		else
			return 0;
	}

	private static boolean hasCircle = false;
	private static int countNode = 0;
	private static int N = 4;

	// dfs时 判定方法相同
	public static int isTreeDfs(int arr[][], int step) {

		boolean[] book = new boolean[N];
		dfs(arr, book, 0, -1);
		if (!hasCircle || countNode == N)
			return 1;
		else
			return 0;
	}

	// 判断是否有环，计算相连节点个数
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
