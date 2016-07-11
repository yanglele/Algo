package com.graph;

//无向图的邻接图，求是否为树
//思路，无向图邻接图对称，
//1.对角线为1则有环
//2.然后考虑右上角数组
public class GraphTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 } };
		GraphTree test = new GraphTree();
		System.out.println(test.isTree(arr));
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
}
