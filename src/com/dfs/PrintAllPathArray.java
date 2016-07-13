package com.dfs;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathArray {

	private static int n = 3;
	private static int destx = 2;
	private static int desty = 2;
	private static boolean[][] book = new boolean[n][n];
	private static int[][] step = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };// 左右上下

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path head = new Path(0, 0);
		tmppath.add(head);
		book[0][0] = true;
		dfs(0, 0);
		System.out.println("pathNum=" + pathNum);
		for (List<Path> list : path) {
			for (Path path : list) {
				System.out.print(path.x + ":" + path.y + "  ");
			}
			System.out.println();
		}
	}

	private static List<List<Path>> path = new ArrayList<>();
	private static List<Path> tmppath = new ArrayList<>();
	private static int pathNum = 0;

	public static void dfs(int x, int y) {

		if (x == destx && y == desty) {
			List<Path> cachePath = new ArrayList<>();
			for (Path path : tmppath)
				cachePath.add(path);
			path.add(cachePath);
			pathNum++;
			return;
		}

		int tx = 0;
		int ty = 0;

		for (int i = 0; i < 4; i++) {
			tx = x + step[i][0];
			ty = y + step[i][1];

			if (tx < 0 || tx >= n || ty < 0 || ty >= n)
				continue;

			if (book[tx][ty] == false) {
				book[tx][ty] = true;
				Path path = new Path(tx, ty);
				tmppath.add(path);
				dfs(tx, ty);
				book[tx][ty] = false;
				tmppath.remove(path);
			}
		}
		List<Path> cachePath = new ArrayList<>();
		for (Path path : tmppath)
			cachePath.add(path);
		path.add(cachePath);
		Path tag = new Path(-1, -1);
		cachePath.add(tag);
		return;
	}
}
