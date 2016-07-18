package com.graph;

import java.util.Scanner;

//有向图
public class FindTheNestWayOfCity {

	private static int descx = 0;
	private static int descy = 4;
	private static int min = Integer.MAX_VALUE;
	private static int N = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindTheNestWayOfCity test = new FindTheNestWayOfCity();
		int[][] arr = test.getInput();
		int num = arr.length;
		boolean[] book = new boolean[num];
		book[0] = true;
		test.dfs(arr, book, 0, 0);
		System.out.println(min);
	}

	public int[][] getInput() {
		Scanner scanner = new Scanner(System.in);
		String string = null;
		int m = 0;
		int n = 0;
		if (scanner.hasNextInt())
			m = scanner.nextInt();

		if (scanner.hasNextInt())
			n = scanner.nextInt();

		// m city n roads
		int[][] arr = new int[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i == j)
					arr[i][i] = 0;
				else
					arr[i][j] = -1;
			}
		}
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			if (scanner.hasNext()) {
				String string2 = scanner.nextLine();
				String[] strings = string2.split(" ");
				int[] way = new int[3];
				for (int j = 0; j < strings.length; j++) {
					way[j] = Integer.parseInt(strings[j]);
				}
				arr[way[0] - 1][way[1] - 1] = way[2];
			}
		}
		N = m;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		return arr;
	}

	private void dfs(int arr[][], boolean[] book, int cur, int count) {

		if (cur == descy) {
			if (count < min) {
				min = count;
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (arr[cur][i] > 0 && book[i] == false) {
				book[i] = true;
				count += arr[cur][i];
				dfs(arr, book, i, count);
				book[i] = false;
				count -= arr[cur][i];
			}
		}

	}

}
