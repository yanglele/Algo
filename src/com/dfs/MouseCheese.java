package com.dfs;

import java.util.ArrayList;
import java.util.List;

public class MouseCheese {

	// 9为奶酪
	// private static int[][] arr = { { 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0,
	// 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0 },
	// { 1, 0, 0, 0, 9, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1,
	// 1, 0, 1 },
	// { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };

	private static int[][] arr = { { 1, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 0 } };

	// 左右上下
	private static int[][] step1 = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	private static int min = Integer.MAX_VALUE;
	private static boolean[][] book = new boolean[arr.length][arr[0].length];
	private static int destx = 3;
	private static int desty = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseCheese test = new MouseCheese();
		int descx = 1;
		int descy = 1;
		tmppath.add(new Path(descx, descy));
		book[descx][descy] = true;
		// test.findTheCheese(0, 0, 0);
		test.findTheCheesePath(descx, descy, 0);
		System.out.println("min=" + min);
		for (Path tmp : path)
			System.out.println(tmp.getX() + ":" + tmp.getY());
	}

	// 求从起始点到奶酪最短步数
	// dfs
	private void findTheCheese(int x, int y, int step) {
		int tx = 0, ty = 0;

		// 如果找到，返回
		if (x == destx && y == desty) {
			if (step < min)
				min = step;
			return;
		}

		// 四个方向依次查找
		for (int i = 0; i < 4; i++) {
			// 下一步路径
			tx = x + step1[i][0];
			ty = y + step1[i][1];

			// 越界，继续
			if (tx < 0 || tx >= arr.length || ty < 0 || ty >= arr[0].length) {
				continue;
			}

			// 可行，标记，继续dfs，返回时记得将其路径标记为false；
			if (arr[tx][ty] != 1 && book[tx][ty] == false) {
				book[tx][ty] = true;
				findTheCheese(tx, ty, step + 1);
				book[tx][ty] = false;
			}

		}
		// 四个路径都走不通，返回
		return;
	}

	// 求从起始点到奶酪最短步数，输出路径
	// dfs
	private static List<Path> path = new ArrayList<>();
	private static List<Path> tmppath = new ArrayList<>();

	private void findTheCheesePath(int x, int y, int step) {
		int tx = 0, ty = 0;

		// 如果找到，返回
		if (x == destx && y == desty) {
			if (step < min) {
				min = step;
				path.clear();
				// 得到tmppath，若此路径较短，则更新path
				for (Path tmp : tmppath) {
					path.add(tmp);
				}
			}
			return;
		}

		// 四个方向依次查找
		for (int i = 0; i < 4; i++) {
			// 下一步路径
			tx = x + step1[i][0];
			ty = y + step1[i][1];

			// 越界，继续
			if (tx < 0 || tx >= arr.length || ty < 0 || ty >= arr[0].length) {
				continue;
			}

			// 可行，标记，继续dfs，返回时记得将其路径标记为false；
			if (arr[tx][ty] != 1 && book[tx][ty] == false) {
				Path tMap = new Path(tx, ty);
				tmppath.add(tMap);// 走到此点，加入tmppath
				book[tx][ty] = true;
				findTheCheesePath(tx, ty, step + 1);
				tmppath.remove(tMap);// 此点可用时删除此点
				book[tx][ty] = false;
			}

		}
		// 四个路径都走不通，返回
		return;
	}
}

class Path {
	int x;
	int y;

	public Path(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
