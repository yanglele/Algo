package leetcode;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test = { 4, 2, 1, 55, 78, 22, 4 };
		quickSort(test, 0, test.length - 1);
		for (int a : test) {
			System.out.println(a + " ");
		}
	}

	public static void quickSort(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int key = arr[start];
		while (i < j) {
			while (arr[j] >= key && j > i)
				j--;
			arr[i] = arr[j];
			while (arr[i] <= key && i < j)
				i++;
			arr[j] = arr[i];
		}
		arr[i] = key;

		if (i - 1 > start)
			quickSort(arr, start, i - 1);
		if (i + 1 < end)
			quickSort(arr, i + 1, end);
	}

	public static void quickSort1(int[] data, int start, int end) {
		// ���ùؼ�����keyΪҪ��������ĵ�һ��Ԫ�أ�
		// ����һ�������key�ұߵ���ȫ����key��key��ߵ���ȫ����keyС
		int key = data[start];
		// ����������ߵ������������ƶ���key�����
		int i = start;
		// ���������ұߵ������������ƶ���keyС����
		int j = end;
		// �������������ұ�����С����������û������
		while (i < j) {
			while (data[j] >= key && j > i) {
				j--;
			}
			data[i] = data[j];

			while (data[i] <= key && i < j) {
				i++;
			}
			data[j] = data[i];
		}
		// ��ʱ i==j
		data[i] = key;

		// �ݹ����
		if (i - 1 > start) {
			// �ݹ���ã���keyǰ����������
			quickSort(data, start, i - 1);
		}
		if (i + 1 < end) {
			// �ݹ���ã���key������������
			quickSort(data, i + 1, end);
		}
	}
}
