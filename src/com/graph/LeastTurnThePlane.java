package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeastTurnThePlane {

	private static int descx = 0;
	private static int descy = 4;
	private static int min = Integer.MAX_VALUE;
	private static int N = 0;// number of city

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeastTurnThePlane test = new LeastTurnThePlane();
		int[][] arr = test.getInput();
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		boolean[] book = new boolean[N];
		test.bfs(arr, book, queue, 0);
		System.out.println(min);
	}

	public void bfs(int[][] arr, boolean[] book, Queue<Integer> queue, int step) {
		queue.add(descx);
		book[descx] = true;
		int curNum = 1;
		int nextNum = 0;
		while (!queue.isEmpty()) {
			while (curNum > 0) {
				int cur = queue.poll();
				if (cur == descy) {
					min = step;
					return;
				}
				curNum--;
				for (int i = 0; i < N; i++) {
					if (arr[cur][i] == 1 && book[i] == false) {
						book[i] = true;
						queue.add(i);
						nextNum++;
					}
				}
			}
			step++;
			curNum = nextNum;
			nextNum = 0;
		}

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
				int[] way = new int[2];
				for (int j = 0; j < strings.length; j++) {
					way[j] = Integer.parseInt(strings[j]);
				}
				arr[way[0] - 1][way[1] - 1] = 1;
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

}
