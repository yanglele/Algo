package leetcode;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test={1,2,3,4,5,6,7};
		System.out.println(binarySearch(test, 6));
		System.out.println(binarySearch(test, 8));
	}

	public static int binarySearch(int[] array,int des){
		int low=0;
		int high=array.length-1;
		while(low<=high && high<=array.length-1){
			int middle=(low+high)>>1;
			if(des == array[middle])
				return middle;
			else if(des>array[middle])
				low=middle+1;
			else if(des<array[middle])
				high=middle-1;
		}
		return -1;
	} 
}
