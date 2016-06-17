package leetcode;

public class LC26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {
	       if (nums.length<2)
				return nums.length;
			int newLocation = 1;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] != nums[i + 1]) {
					nums[newLocation]=nums[i+1];
					newLocation++;
				}
			}
			return newLocation;
	}
	
//	public int removeDuplicates(int[] nums) {	
//	if (nums == null)
//		return 0;
//	if (nums.length == 1)
//		return 1;
//	int curr = 0;
//	int next = 0;
//	int length =1;
//	for (int i = 0; i < nums.length - 1; i++) {
//		if (nums[i] != nums[i + 1]) {
//			curr++;
//			next++;
//			nums[curr] = nums[next];
//			length++;
//		} else if (nums[i] == nums[i + 1]) {
//			next++;
//		}
//	}
//	return length;
//	}
//}
}
