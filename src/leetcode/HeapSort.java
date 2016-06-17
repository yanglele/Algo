package leetcode;

public class HeapSort {
	private static int[] sort = new int[] { 1, 34, 10, 43, 55, 42, 6, 23, 9, 8, 12, 17, 34, 11, 12, 13 ,5};

	public static void main(String[] args) {
		buildMaxHeapify(sort);// 首先创建大顶堆
		heapSort(sort);// 开始堆排序
		print(sort);
	}

	private static void buildMaxHeapify(int[] arry) {
		int startIndex = getParentIndex(arry.length - 1);
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(arry, arry.length, i);
		}
	}

	private static void maxHeapify(int[] arry, int length, int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		int largest = index;
		if (leftIndex < length && arry[index] < arry[leftIndex])
			largest = leftIndex;
		if (rightIndex < length && arry[largest] < arry[rightIndex])
			largest = rightIndex;
		if (largest != index) {
			arry[index] ^= arry[largest];
			arry[largest] ^= arry[index];
			arry[index] ^= arry[largest];
			maxHeapify(arry, length, largest);
		}
	}

	private static void heapSort(int[] arry) {
		int length = arry.length;
		for (int i = 0; i < length; i++) {
			arry[0] ^= arry[length - 1 - i];
			arry[length - 1 - i] ^= arry[0];
			arry[0] ^= arry[length - 1 - i];
			maxHeapify(arry, length - 1 - i, 0);
		}
	}

	private static int getParentIndex(int index) {
		return (index - 1) >> 1;
	}

	private static int getLeftChildIndex(int index) {
		return (index << 1) + 1;
	}

	private static int getRightChildIndex(int index) {
		return (index << 1) + 2;
	}

	// private static void buildMaxHeapify(int[] data) {
	// // 从最后一个父节点开始，倒序开始创建大顶堆
	// int startIndex = getParentIndex(data.length - 1);
	// // 从尾端开始创建最大堆，每次都是正确的堆
	// for (int i = startIndex; i >= 0; i--) {
	// maxHeapify(data, data.length, i);
	// }
	// }
	//
	// /**
	// * 创建最大堆
	// *
	// * @param data
	// * @param heapSize需要创建最大堆的大小，一般在sort的时候用到，因为最大值放在末尾，末尾就不再归入最大堆了
	// * @param index在index节点下创建大顶堆
	// */
	// private static void maxHeapify(int[] data, int heapSize, int index) {
	// // 当前点与左右子节点比较
	// int left = getChildLeftIndex(index);
	// int right = getChildRightIndex(index);
	//
	// int largest = index;
	// if (left < heapSize && data[index] < data[left]) {
	// largest = left;
	// }
	// if (right < heapSize && data[largest] < data[right]) {
	// largest = right;
	// }
	// // 得到最大值后可能需要交换，交换父节点与两个子节点。如果交换了，其子节点可能就不是最大堆了，需要重新调整
	// if (largest != index) {
	// int temp = data[index];
	// data[index] = data[largest];
	// data[largest] = temp;
	// maxHeapify(data, heapSize,
	// largest);//交换后index子堆顺序可能变化，需重新排序其子堆，只需拍最大分支，另一分支没变
	// }
	// }
	//
	// /**
	// * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
	// *
	// * @paramdata
	// */
	// private static void heapSort(int[] data) {
	// // 末尾与头交换，交换后调整最大堆
	// for (int i = data.length - 1; i > 0; i--) {
	// int temp = data[0];
	// data[0] = data[i];
	// data[i] = temp;
	// maxHeapify(data, i, 0);
	// }
	// }
	//
	// private static int getParentIndex(int current) {
	// return (current - 1) >> 1;
	// }
	//
	//
	// private static int getChildLeftIndex(int current) {
	// return (current << 1) + 1;
	// }
	//
	//
	// private static int getChildRightIndex(int current) {
	// return (current << 1) + 2;
	// }
	//
	private static void print(int[] data) {
		int pre = -2;
		for (int i = 0; i < data.length; i++) {
			if (pre < (int) getLog(i + 1)) {
				pre = (int) getLog(i + 1);
				System.out.println();
			}
			System.out.print(data[i] + "|");
		}
	}

	//
	// /**
	// * 以2为底的对数
	// */
	private static double getLog(double param) {
		return Math.log(param) / Math.log(2);
	}
}