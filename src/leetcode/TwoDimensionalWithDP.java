package leetcode;

public class TwoDimensionalWithDP {
	
	public static int oneMaxSub(int[] a){
		int currMax=0;
		int allMax=a[0];
		for(int i=0;i<a.length;i++){
			currMax=Math.max(a[i], a[i]+currMax);   //currMax=a[i]>(a[i]+currMax)?a[i]:a[i]+currMax;
			allMax=Math.max(currMax, allMax);   //allMax=currMax>allMax?currMax:allMax;
		}
		return allMax;
	}
	
	public static int twoMaxSub(int[][] a){
		int n=a.length;
		int m=a[0].length;
		int result=oneMaxSub(a[0]);
		
		for(int i=0;i<n;i++){
			int subMax=0;
			for(int j=i+1;j<n;j++){
				for(int k=0;k<m;k++){
					a[i][k]+=a[j][k];
				}
				subMax=oneMaxSub(a[i]);
				if(subMax>result)
					result=subMax;
			}
		}
		return result;
	}
	

	/**
	 * 最大子阵，压缩矩阵为一维数组，转化为求最大字段和问题，运用动态规划求解。
	 * 转化为一位数组，求一维数组的最大字段和。时间复杂度O(N*M*Min(N,M))
	 */
//	public static int TwoMaxSum(int a[][], int n, int m) {
//		int minMax;
//		int Max = Integer.MIN_VALUE;
//		for (int i = 0; i < n; i++) {
//			minMax = OneMaxSum(a[i], m);
//			if (minMax > Max)
//				Max = minMax;
//			for (int j = i + 1; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					a[i][k] += a[j][k];
//				}
//				minMax = OneMaxSum(a[i], m);
//				if (minMax > Max)
//					Max = minMax;
//			}
//		}
//		return Max;
//	}

	/**
	 * 一维最大字段和
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
//	public static int OneMaxSum(int[] a, int m) {
//		int start, all;
//		start = all = a[0];
//		for (int i = 1; i < m; i++) {
//			start = Math.max(a[i], a[i] + start);
//			all = Math.max(start, all);
//		}
//		return all;
//	}

	public static void main(String[] args) {
		int[][] a = { { -1, -4, 3, 2 }, { 3, 4, -1, 7 }, { -5, -2, 8, 6 } };
		System.out.print(twoMaxSub(a));
	}
}
