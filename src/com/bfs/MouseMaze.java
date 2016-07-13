package com.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MouseMaze {

	private static int[][] arr = { { 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };

	// private static int[][] arr = { { 0, 1, 1 }, { 0, 0, 0 }, { 0, 1, 0 } };
	// 左右上下
	private static int[][] step = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	private static boolean[][] book = new boolean[arr.length][arr[0].length];

	private static List<Point> path = new ArrayList<>();
	private static Queue<Point> tmpQueue = new LinkedList<>();

	private static int stepNum = 0;

	public static void main(String[] args) {
		MouseMaze test = new MouseMaze();
		test.findTheWay(6, 6);
		System.out.println(stepNum);
		Point point = path.get(path.size() - 1);
		Stack<Point> stack = new Stack<>();
		while (point.parent != null) {
			stack.push(point);
			point = point.parent;
		}
		stack.push(point);
		while (!stack.isEmpty()) {
			Point tmPoint = stack.pop();
			System.out.println(tmPoint.getX() + ":" + tmPoint.getY());
		}

	}

	// bfs 每次走一步，将此步所有可到达的点装入tmpQueue，然后依次取出放入path中，取到则输出路径
	public void findTheWay(int xx, int yy) {

		// 初始化元素
		Point head = new Point(0, 0);
		head.parent = null;
		book[0][0] = true;
		tmpQueue.add(head);

		// tmpqueue缓冲，主要用于计算步数
		int curNumNum = tmpQueue.size();
		int nextNumNum = 0;

		// 为空时，说明无路可走
		while (!tmpQueue.isEmpty()) {
			// 将tmpQueue中上一步所有点依次取出
			while (curNumNum > 0) {
				Point tmp = tmpQueue.poll();
				curNumNum--;
				path.add(tmp);
				int x = tmp.getX();
				int y = tmp.getY();

				// 结果，返回
				if (x == xx && y == yy) {
					return;
				}

				// 求下一步点，并将合适的点写入tmpQueue
				for (int i = 0; i < 4; i++) {
					int tx = x + step[i][0];
					int ty = y + step[i][1];

					if (tx < 0 || tx >= arr.length || ty < 0 || ty >= arr[0].length)
						continue;

					if (arr[tx][ty] == 0 && book[tx][ty] == false) {
						book[tx][ty] = true;
						Point listPoint = new Point(tx, ty, tmp);
						tmpQueue.add(listPoint);
						nextNumNum++;
					}
				}
			}
			stepNum++;
			curNumNum = nextNumNum;
			nextNumNum = 0;
		}

	}
}

class Point {
	int x;
	int y;
	Point parent;// 记录父节点，用于输出路径

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Point parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
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
