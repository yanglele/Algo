package com.graph;

//Dijkstra
//单源最短路径问题
//只能求正权值
public class ShorestRoadOfOne2AllCity {

	private static int N = 6;
	private static int[][] arr = { { 0, 1, 12, 100, 100, 100 }, { 100, 0, 9, 3, 100, 100 },
			{ 100, 100, 0, 100, 5, 100 }, { 100, 100, 4, 0, 13, 15 }, { 100, 100, 100, 100, 0, 4 },
			{ 100, 100, 100, 100, 100, 0 } };
	private static int sourCity = 3;
	private static int[] result = new int[N];
	private static boolean[] book = new boolean[N];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getShorestRoadOfOne2AllCity();
		for (int i : result)
			System.out.print(i + " ");
	}

	private static void getShorestRoadOfOne2AllCity() {
		sourCity -= 1;
		book[sourCity] = true;

		// result数组赋值
		for (int i = 0; i < N; i++)
			result[i] = arr[sourCity][i];

		// 循环n-1次，对应n-1个点
		for (int i = 1; i < N; i++) {

			int min = Integer.MAX_VALUE;
			int baseNode = -1;

			// 获得离目标点最近的点baseNode
			for (int j = 0; j < N; j++) {
				if (result[j] < min && book[j] == false) {
					min = result[j];
					baseNode = j;
				}
			}
			book[baseNode] = true;

			// 更新baseNode的邻接点最短距离
			for (int j = 0; j < N; j++) {
				if (arr[baseNode][j] != 0 && arr[baseNode][j] < 100) {
					if (result[j] > result[baseNode] + arr[baseNode][j])
						result[j] = result[baseNode] + arr[baseNode][j];
				}
			}

		}

	}
}
