package leetcode;

import javax.print.attribute.standard.RequestingUserName;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1={1,2,3};
		Test1 test1=new Test1();
		nums1=test1.change(nums1);
		for(int i=0;i<nums1.length;i++)
			System.out.println(" "+nums1[i]);
	}
	
	public int[] change(int[] nums){
		int[] nums2=new int[]{4,5,6};
		return nums2;
	}

}
