package com.sort;

public class MergerSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 43, 6, 1, 3, -9, 77, 56, 3, 57 };
		int[] tmp = new int[arr.length];
		MergerSort mergerSort = new MergerSort();
		mergerSort.mergerSort(arr, tmp, 0, arr.length - 1);
		for (int tmp1 : arr)
			System.out.print(tmp1 + " ");
	}

	public void mergerArray(int[] arr, int[] tmp, int start, int middle, int end) {
		int i1 = start;
		int i2 = middle;

		int j1 = middle + 1;
		int j2 = end;

		int k = start;
		while (i1 <= i2 && j1 <= j2) {
			if (arr[i1] < arr[j1]) {
				tmp[k] = arr[i1];
				i1++;
			} else {
				tmp[k] = arr[i2];
				i2++;
			}
			k++;
		}
		while (i1 <= i2) {
			tmp[k] = arr[i1];
			k++;
			i1++;
		}
		while (j1 < j2) {
			tmp[k] = arr[j1];
			k++;
			j1++;
		}

		for (int i = start; i < k; i++)
			arr[i] = tmp[i];
	}

	public void mergerSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int middle = ((end - start) >> 1) + start;
			mergerSort(arr, tmp, start, middle);
			mergerSort(arr, tmp, middle + 1, end);
			mergerArray(arr, tmp, start, middle, end);
		}
	}
}
