package com.graph;

//Bellman-Ford
//单源最短路径问题
//解决正负权值
public class ShorestRoadOfOne2AllCityN {

	private static int vertex = 5;// 顶点数
	private static int edge = 5;// 边数
	private static int max = 1000;

	private static int[] sour = { 2, 1, 1, 4, 3 };
	private static int[] dest = { 3, 2, 5, 5, 4 };
	private static int[] weight = { 2, -3, 5, 2, 3 };
	private static int[] dis = { 0, max, max, max, max };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getShorestRoadOfOne2AllCityN();
		for (int tmp : dis)
			System.out.println(tmp);
	}

	public static void getShorestRoadOfOne2AllCityN() {
		for (int i = 1; i < vertex; i++)
			for (int j = 0; j < edge; j++)
				if (dis[dest[j] - 1] > dis[sour[j] - 1] + weight[j])
					dis[dest[j] - 1] = dis[sour[j] - 1] + weight[j];

		// 以下用于计算是否有回路
		int flag = 0;
		for (int j = 0; j < edge; j++) {
			if (dis[dest[j] - 1] > dis[sour[j] - 1] + weight[j])
				flag = 1;
		}
		if (flag == 1)
			System.out.println("有回路！");
	}
}
