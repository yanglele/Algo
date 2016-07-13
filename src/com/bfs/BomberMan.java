package com.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BomberMan {

	// #墙 G敌人 .空地
	/*
	 * ############# #GG.GGG#GGG.# ###.#G#G#G#G# #.......#..G# #G#.###.#G#G#
	 * #GG.GGG.#.GG# #G#.#G#.#.#.# ##G...G.....# #G#.#G###.#G# #...G#GGG.GG#
	 * #G#.#G#G#.#G# #GG.GGG#G.GG# #############
	 */
	// 13*13
	private static char[][] arr = new char[13][13];
	private static int m = arr.length;
	private static int n = arr[0].length;

	private static boolean[][] book = new boolean[m][n];
	private static int maxDead = 0;

	private static int[][] next = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };// 下，上，右，左

	// 记录路径，用于打印路径
	private static List<Point> path = new ArrayList<>();
	private static Queue<Point> tmpList = new LinkedList<>();

	// 起始地址
	private static int sourx = 3;
	private static int soury = 3;

	// 目标炸弹地址
	private static int destx = 0;
	private static int desty = 0;

	private static int step = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = null;
		Scanner scanner = new Scanner(System.in);

		// 输入地图
		for (int i = 0; i < 13; i++) {
			string = scanner.nextLine();
			arr[i] = string.toCharArray();
		}

		BomberMan test = new BomberMan();
		test.bfs();
		System.out.println(maxDead);
		System.out.println("x=" + destx + "  y=" + desty);
		System.out.println("step=" + step);

		// 取最大炸弹处到达路径
		Stack<Point> stack = new Stack<>();
		Point tail = null;
		for (Point point : path) {
			if (point.x == destx && point.y == desty) {
				tail = point;
				break;
			}
		}
		while (tail != null) {
			stack.push(tail);
			tail = tail.parent;
		}

		while (!stack.isEmpty()) {
			Point point = stack.pop();
			System.out.println(point.x + ":" + point.y);
		}
	}

	public void bfs() {
		Point head = new Point(sourx, soury, null);
		tmpList.add(head);
		book[sourx][soury] = true;

		int curCount = 1;
		int nextCur = 0;

		// 为空时已经无路可走
		while (!tmpList.isEmpty()) {
			// 处理一层的结国
			while (curCount > 0) {
				Point tmp = tmpList.poll();
				path.add(tmp);
				curCount--;

				int x = tmp.getX();
				int y = tmp.getY();

				for (int i = 0; i < 4; i++) {
					int tx = x + next[i][0];
					int ty = y + next[i][1];

					// 越界 返回继续下个方向
					if (tx < 0 || tx >= m || ty < 0 || ty >= n)
						continue;

					// 为平地且没走过，可走
					if (arr[tx][ty] == '.' && book[tx][ty] == false) {
						book[tx][ty] = true;
						Point tmp1 = new Point(tx, ty, tmp);
						tmpList.add(tmp1);
						nextCur++;
						// 计算可行路径的最大杀敌数
						int deadNum = countMaxDead(tx, ty);
						if (deadNum > maxDead) {
							maxDead = deadNum;
							destx = tx;
							desty = ty;
						}
					}
				}
			}
			step++;
			curCount = nextCur;
			nextCur = 0;
		}
	}

	public int countMaxDead(int x, int y) {
		int num = 0;
		for (int i = 0; i < 4; i++) {
			int tx = x + next[i][0];
			int ty = y + next[i][1];

			while (arr[tx][ty] != '#') {
				if (arr[tx][ty] == 'G') {
					num++;
				}
				switch (i) {
				case 0:
					tx++;
					break;
				case 1:
					tx--;
					break;
				case 2:
					ty++;
					break;
				default:
					ty--;
				}
			}
		}
		return num;
	}
}
