package leetcode;

import java.util.HashMap;

public class TheMaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=1;
		while(n<Integer.MAX_VALUE/2){
			n*=2;
		}
		System.out.println(n);
	}

}
