package leetcode;

import java.util.ArrayList;

public class LC27 {

	public int removeElement(int[] nums, int val) {
		int newLocation = 0;
		for (int i = 0; i < nums.length; i++) {
			if (val != nums[i]){
				nums[newLocation]=nums[i];
				newLocation++;
			}
		}
		return newLocation;

	}
}
