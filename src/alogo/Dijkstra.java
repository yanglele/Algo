package alogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.tools.Diagnostic;

public class Dijkstra {

	private static int nums = 7;
	final private static int Max = Integer.MAX_VALUE;

	private int a[][] = { { Max, 2, Max, 1, Max, Max, Max }, { Max, Max, Max, 3, 10, Max, Max },
			{ 4, Max, Max, Max, Max, 5, Max }, { Max, Max, 2, Max, 2, 8, 4 }, { Max, Max, Max, Max, Max, Max, 6 },
			{ Max, Max, Max, Max, Max, Max, Max }, { Max, Max, Max, Max, Max, 1, Max } };// 边的长度

	private int dist[] = new int[nums];// 到某点最短路径长度
	private int prev[] = new int[nums];// 某点前一个路径点
	private boolean visited[] = new boolean[nums];// 标记某点是否已求出最短路径

	private static int notVisted = nums;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dijkstra dijkstra = new Dijkstra();
		dijkstra.Dijkstra(0);
		for (int i = 0; i < dijkstra.nums; i++) {
			System.out.print(dijkstra.dist[i] + "  ");
			System.out.print(dijkstra.prev[i]);
			System.out.println();
		}

	}

	
	public void Dijkstra(int v1) {// 顶点v1
		// 初始化
		for (int i = 0; i < nums; i++) {
			prev[i] = 0;
			visited[i] = false;
			dist[i] = Max;
		}
		dist[v1] = 0;// 顶点v1

		// 初始化v1临点
		visited[v1] = true;
		notVisted--;
		// v1的prev为0，故i从1开始
		for (int i = 1; i < nums; i++) {
			if (a[v1][i] != Max) {
				dist[i] = a[v1][i];
				prev[i] = v1 + 1;
				// cur.add(i);
			}
		}

		while (notVisted > 0) {
			int tmp = findNearestNode(visited, dist);
			for (int i = 0; i < nums; i++) {
				if (a[tmp][i] != Max && visited[i] == false) {
					if (dist[i] > dist[tmp] + a[tmp][i]) {
						dist[i] = dist[tmp] + a[tmp][i];
						prev[i] = tmp + 1;
					}
				}

			}
		}
	}

	public static int findNearestNode(boolean visited[], int dist[]) {
		List<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < nums; i++) {
			if (visited[i] == false && dist[i] != Max && dist[i] != 0) {
				tmp.add(dist[i]);
			}
		}
		if (!tmp.isEmpty()) {
			Collections.sort(tmp);
			int result = tmp.get(0);
			int index = 0;
			tmp.remove(0);
			for (int i = 0; i < nums; i++) {
				if (result == dist[i]) {
					index = i;
					visited[index] = true;
					notVisted--;
				}
			}
			return index;
		}
		return -1;
	}
}
