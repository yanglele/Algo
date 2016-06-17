package com.inout.test;

import java.util.Scanner;

public class GetInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int[] arr = null;
		if (scanner.hasNext()) {
			int n = scanner.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
		}
		scanner.close();
		for (int i : arr)
			System.out.println(i);
	}

}
