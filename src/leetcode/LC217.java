package leetcode;

import java.util.Arrays;

public class LC217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test={1,2,3,4};
		int[] test2={1,2,3,1};
		LC217 testObj=new LC217();
		System.out.println("1."+testObj.containsDuplicate(test));
		System.out.println("2."+testObj.containsDuplicate(test2));
	}

	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
        	if(nums[i] == nums[i+1])
        		return true;
        }
         return false;
    }
}
