package com.graph;

public class LeastTreeOfGraph {

	// 边
	private static int[][] arr = { { 2, 4, 11 }, { 3, 5, 13 }, { 4, 6, 3 }, { 5, 6, 4 }, { 2, 3, 6 }, { 4, 5, 7 },
			{ 1, 2, 1 }, { 3, 4, 9 }, { 1, 3, 2 } };
	private static int nodeNum = 6;
	private static int edgeNum = 9;

	private static int resultWeight = 0;
	private static int edgeCount = 0;

	private static int[] mergeArr = new int[nodeNum + 1];// 并查集

	public static void main(String[] args) {

		quickSort();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][2] + "  ");
		}
		System.out.println();

		for (int i = 0; i < mergeArr.length; i++)
			mergeArr[i] = i;

		getResultWeightOfLeastTree();
		System.out.println(resultWeight);

	}

	public static void getResultWeightOfLeastTree() {
		for (int i = 0; i < edgeNum; i++) {
			if (merge(arr[i][0], arr[i][1]) == 0) {
				resultWeight += arr[i][2];
				edgeCount++;
			}
			if (edgeCount == nodeNum - 1)
				return;
		}
	}

	public static int findFather(int node) {
		if (node == mergeArr[node])
			return node;
		mergeArr[node] = findFather(mergeArr[node]);
		return mergeArr[node];
	}

	// 合并并查集,并查集用来判断是否有回路，若将要插入的边的两节点有相同父节点，则有回路；
	// result 1 相同父节点 0无相同父节点
	public static int merge(int node1, int node2) {
		int node1f = findFather(node1);
		int node2f = findFather(node2);

		if (node1f == node2f)
			return 1;
		else {
			mergeArr[node2f] = node1f;
			return 0;
		}
	}

	// quicksort arr[i][2],then exchange arr[i];
	public static void quickSort() {
		int left = 0;
		int right = arr.length - 1;
		quickSortSub(left, right);
	}

	public static void quickSortSub(int left, int right) {
		int tmp = arr[left][2];
		int[] tmpArr = arr[left];
		int l = left;
		int r = right;

		while (l < r) {
			while (arr[r][2] >= tmp && l < r)
				r--;
			arr[l] = arr[r];

			while (arr[l][2] <= tmp && l < r)
				l++;
			arr[r] = arr[l];
		}
		arr[r] = tmpArr;
		if (left < l - 1)
			quickSortSub(left, l - 1);
		if (l + 1 < right)
			quickSortSub(l + 1, right);
	}

}
