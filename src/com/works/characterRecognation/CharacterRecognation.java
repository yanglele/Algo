package com.works.characterRecognation;

import java.util.Scanner;

public class CharacterRecognation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CharacterRecognation sample = new CharacterRecognation();
		char[][] arrays = sample.getNums2Arrays();
		sample.showArrays(arrays);

	}

	public char[][] getNums2Arrays() {
		System.out.println("Please enter the nums of N,M,K:");
		int n = 0, m = 0, k = 0;
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			n = scanner.nextInt();
		}
		if (scanner.hasNextInt()) {
			m = scanner.nextInt();
		}
		if (scanner.hasNextInt()) {
			k = scanner.nextInt();
		}
		scanner.nextLine();
		int l = n * m;
		char[][] charArrays = new char[k][l];
		for (int i = 0; i < k; i++) {
			scanner.nextLine();
			StringBuffer sBuffer = new StringBuffer();
			for (int j = 0; j < n; j++) {
				sBuffer.append(scanner.nextLine());
			}
			String tmpString = sBuffer.toString();
			charArrays[i] = tmpString.toCharArray();
		}
		return charArrays;
	}

	public void showArrays(char[][] charArrays) {
		int k = charArrays.length;
		int l = charArrays[0].length;
		System.out.println("output:");
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < l; j++)
				System.out.print(charArrays[i][j]);
			System.out.println();
		}

	}

	public int getTheResult(char[][] arrays) {
		int m = arrays.length;
		int n = arrays[0].length;
		if (m == 2)
			return 1;
		else if (m == 3)
			return 2;
		else if (m == 4)
			return get4Result(arrays);
		else if (m == 5)
			return get5Result(arrays);
		else if (m == 6)
			return get6Result(arrays);
		else
			return -1;
	}

	public int get4Result(char[][] arrays) {
		int m = arrays.length;
		int n = arrays[0].length;
		for (int j = 0; j < n; j++) {
			for (int k = 1; k < n; k++) {
				char[] a = { arrays[0][j], arrays[0][k] };
				char[] b = { arrays[1][j], arrays[1][k + 1] };
				char[] c = { arrays[2][j], arrays[2][k] };
				char[] d = { arrays[3][j], arrays[3][k + 1] };
				if (compare2Nums(a, b)) {
					continue;
				} else {
					
					if (compare2Nums(c, d)) {
						continue;
					} else {
						
					}
				}
			}
		}

		return 0;
	}

	public int get5Result(char[][] arrays) {
		return 0;
	}

	public int get6Result(char[][] arrays) {
		return 0;
	}

	public boolean compare2Nums(char[] a, char[] b) {
		boolean result = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				result = true;
		}
		return result;
	}
}
