package com.graph;

public class ShortestRoadOfAnyTwoCity {

	// private static int[][] arr = { { 0, 2, 6, 4 }, { 100, 0, 3, 100 }, { 7,
	// 100, 0, 1 }, { 5, 100, 12, 0 } };
	// private static int[][] arr = { { 0, 5, 1, 20 }, { 100, 0, 100, 5 }, {
	// 100, 100, 0, 1 }, { 100, 100, 100, 0 } };
	private static int[][] arr = { { 0, 5, 100, 20 }, { 100, 0, 1, 5 }, { 100, 100, 0, 1 }, { 100, 100, 100, 0 } };

	private static int N = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getShortestRoadOfAnyTwoCity();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	// 每计算一次，数组里全部数值都是插入过节点后的最短路径，下次计算时复用上次结果。
	// 故最后的结果是插入节点（或不需要插入）后的最短路径
	public static void getShortestRoadOfAnyTwoCity() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
	}
}
