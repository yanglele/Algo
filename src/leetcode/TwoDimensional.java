package leetcode;

public class TwoDimensional {

	/**
	 * 暴力解法及其优化求解二维最大子段和。
	 * 
	 * @author DaiSong
	 * @Date 2013年12月2日
	 */
	static int MAX = 501;
	static int[][] ps = new int[MAX][MAX];

	/**
	 * 方法一，暴力求解，时间复杂度为O(N^3*M^3)
	 * 
	 * @param a
	 * @param m
	 * @param n
	 * @return
	 */
	public static int MaxSum1(int a[][], int m, int n) {

		int max = Integer.MIN_VALUE;
		int sum;
		for (int min_i = 0; min_i < n; min_i++) {
			for (int max_i = min_i; max_i < n; max_i++) {
				for (int min_j = 0; min_j < m; min_j++) {
					for (int max_j = min_j; max_j < m; max_j++) {
						// 求区域矩阵的和
						sum = 0;
						for (int i = min_i; i <= max_i; i++) {
							for (int j = min_j; j <= max_j; j++) {
								sum += a[i][j];
							}
						}
						if (sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		return max;
	}

	/**
	 * 方法二，改进：考虑到区域的和需要频繁计算，做了预处理。用ps[n][m]存放i=1..n,j=1..m区域和。 时间复杂度为O(N^2*M^2)
	 * 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public static int MaxSum2(int a[][], int n, int m) {

		int max = Integer.MIN_VALUE;
		int sum;
		PieceSum(a, n, m);
		for (int min_i = 1; min_i <= n; min_i++) {
			for (int max_i = min_i; max_i <= n; max_i++) {
				for (int min_j = 1; min_j <= m; min_j++) {
					for (int max_j = min_j; max_j <= m; max_j++) {
						// 求区域矩阵的和
						sum = ps[max_i][max_j] - ps[min_i - 1][max_j] - ps[max_i][min_j - 1] + ps[min_i - 1][min_j - 1];
						if (sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		return max;
	}

	/**
	 * 预处理求出区域和，时间复杂度为O(N*M)
	 * 
	 * @param a
	 * @param n
	 * @param m
	 */
	public static void PieceSum(int[][] a, int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + a[i][j];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { -1, -4, 3 }, { 3, 4, -1 }, { -5, -2, 8 } };
		System.out.println(MaxSum1(a, 3, 3));
		int b[][] = { { 0, 0, 0, 0 }, { 0, -1, -4, 3 }, { 0, 3, 4, -1 }, { 0, -5, -2, 8 } };
		System.out.println(MaxSum2(b, 3, 3));
	}
}
