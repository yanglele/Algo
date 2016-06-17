package alogo;

public class FindTheLeastNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] d = new int[] { 3, 30, 34, 5, 9 };
		StringBuilder result = new StringBuilder();
		quicksort(d, 0, d.length - 1);
		// System.out.println(d.getClass().getName());
		for (int tmp : d) {
			result.append(Integer.toString(tmp));
		}
		System.out.println(result);
	}

	public static boolean isSmallerOrEqual(int a, int b) {
		if ((Integer.toString(a) + Integer.toString(b)).compareTo((Integer.toString(b)) + Integer.toString(a)) <= 0)
			return true;
		else {
			return false;
		}
	}

	public static void quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int point = quicksort1(arr, left, right);
			quicksort(arr, left, point - 1);
			quicksort(arr, point + 1, right);
		}
	}

	public static int quicksort1(int[] arr, int left, int right) {
		int tmp = arr[left];
		int i = left, j = right;
		while (i < j) {
			while (i < j && isSmallerOrEqual(tmp, arr[j]))
				j--;
			arr[i] = arr[j];
			while (i < j && isSmallerOrEqual(arr[i], tmp))
				i++;
			arr[j] = arr[i];
		}
		arr[i] = tmp;
		return i;
	}
}
