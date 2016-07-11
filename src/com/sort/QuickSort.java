package com.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 43, 6, 1, 3, -9, 77, 56, 3, 57 };
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(arr, 0, arr.length - 1);
		for (int tmp : arr)
			System.out.print(tmp + " ");
	}

	public void quickSort(int[] arr, int start, int end) {
		int tmp = arr[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (arr[j] >= tmp && i < j)
				j--;
			arr[i] = arr[j];
			while (arr[i] <= tmp && i < j)
				i++;
			arr[j] = arr[i];
		}
		arr[i] = tmp;
		if (start < i - 1)
			quickSort(arr, start, i - 1);
		if (i + 1 < end)
			quickSort(arr, i + 1, end);
	}
}
