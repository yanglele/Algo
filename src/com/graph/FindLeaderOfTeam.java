package com.graph;

//根据线索，找n个人中团伙数量
public class FindLeaderOfTeam {

	private static int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 2 }, { 4, 6 }, { 2, 6 }, { 8, 7 }, { 9, 7 }, { 1, 6 },
			{ 2, 4 } };
	private static int peopleNum = 10;
	private static int clueNum = arr.length;// 9

	private static int[] result = new int[peopleNum + 1];// 11

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 赋初值，每个人老大是自己
		for (int i = 0; i < result.length; i++)
			result[i] = i;

		// 逐个线索合并result的boss
		for (int i = 0; i < clueNum; i++) {
			merge(arr[i][0], arr[i][1]);
		}

		// 计算团伙数量
		int num = 0;
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
			if (i == result[i])
				num++;
		}

		System.out.println("num=" + num);
	}

	public static int findFather(int node) {
		if (node == result[node])
			return node;
		// 递归调用，将递归的节点赋予走过的节点，即更新其boss。
		result[node] = findFather(result[node]);
		return result[node];
	}

	public static void merge(int node1, int node2) {
		int node1f = findFather(node1);
		int node2f = findFather(node2);
		if (node1f != node2f)
			result[node2f] = node1f;
	}
}
