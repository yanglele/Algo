package com.works.characterRecognation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class CharacterRecognition {
	byte M, N, K, num[][], row[];
	public static final boolean DEBUG = true;

	public static void main(String[] args) {
		CharacterRecognition cr = new CharacterRecognition();

		cr.readDataDebug(2, 3, 6);

		// cr.readData();

		U.p("for your input, the minum is : " + cr.getMin());

	}

	public int getMin() {
		if (K == 2)
			return 1;
		if (K == 3)
			return 2;
		if (K == 4) {
			Integer[] col = FindDivColBy(2);
			if (col.length >= 2) {
				for (int i = 0; i < col.length; i++) {
					for (int j = i + 1; j < col.length; j++) {
						if (checkDividable(col[i], col[j]))
							return 2; // once found, stop searching
					}
				}
				return 3;
			} else {
				return 3;
			}
		}
		if (K == 5) {
			Integer[] col = FindDivColBy(3);
			// if we want min div point with 3, there must be at least 2 columns
			// with
			// sum=3
			if (col.length >= 2) {
				for (int i = 0; i < col.length; i++) { // first column
					for (int j = i + 1; j < col.length; j++) { // second column
						for (int t = 0; t < M * N; t++) { // enum third column
							if (t == col[i] || t == col[j])
								continue;
							if (checkDividable(col[i], col[j], t)) {
								return 3;
							}
						}
					}
				}
				return 4;
			}
			return 4;
		}
		if (K == 6) {
			Integer[] col_3 = FindDivColBy(3);
			Integer[] col_34 = FindDivColBy(3, 4);

			// if we want min div point with 3, sum must be 344 or 333 or 334
			if (col_3.length > 0 && col_34.length >= 3) { // first column must
															// be sum = 3
				for (int i : col_3) {
					for (int j = 0; j < col_34.length; j++) {// second column
																// sum = 3||4
						if (col_34[j] == i)
							continue;
						for (int k = j + 1; k < col_34.length; k++) {// third
																		// column
																		// sum =
																		// 3||4
							if (col_34[k] == i)
								continue;
							if (checkDividable(i, col_34[j], col_34[k])) {
								return 3;
							}
						}
					}
				}
				return enumAll();
			}
			return enumAll();
		}
		return 0;
	}

	// 最后一种做不出来了，暴力穷举
	public int enumAll() {
		for (int i = 0; i < M * N; i++) {
			for (int j = i + 1; j < M * N; j++) {
				for (int m = j + 1; m < M * N; m++) {
					for (int n = m + 1; n < M * N; n++) {
						if (checkDividable(i, j, m, n)) {
							return 4;
						}
					}
				}
			}
		}
		return 5;
	}

	public Integer[] FindDivColBy(int... divSum) {
		return FindDivPointBy(row, divSum);
	}

	public Integer[] FindDivPointBy(byte[] rows, int... divSum) {
		ArrayList<Integer> list = new ArrayList<>();
		int temp;

		for (int i = 0; i < N * M; i++) {
			temp = 0;
			for (byte k : rows) {
				temp += num[k][i];
			}
			if (DEBUG)
				U.p(temp);
			for (int d : divSum) {
				if (temp == d || temp == rows.length - d) {
					list.add(i);
				}
			}
		}
		Integer[] column = new Integer[list.size()];
		list.toArray(column);
		if (DEBUG) {
			System.out.print("find these div col: ");
			U.p(column);
		}

		return column;
	}

	// check whether these columns can separate rows
	public boolean checkDividable(int... col) {
		return checkDividable(row, col);
	}

	public boolean checkDividable(byte[] rows, int... col) {
		if (Math.pow(2, col.length) < rows.length) {
			if (DEBUG)
				U.p("dividable : false");
			;
			return false;
		}
		boolean dividable = false;

		TreeSet<Integer> set = new TreeSet<>();
		int sum;
		for (int i : rows) {
			sum = 0;
			for (int j = 0; j < col.length; j++) {
				sum += num[i][col[j]] * Math.pow(2, j);
			}
			set.add(sum);
		}
		if (set.size() == rows.length) { // No repeat arguments in two columns
			dividable = true;
		}

		if (DEBUG) {
			System.out.print("column: ");
			U.p(col);
			U.p(" dividable: " + dividable);
		}
		return dividable;
	}

	public void readData() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter:");
		N = s.nextByte();
		M = s.nextByte();
		K = s.nextByte();
		num = new byte[K][];
		row = new byte[K];
		for (int i = 0; i < K; i++) {
			num[i] = new byte[N * M]; // initialize array
		}
		String line;
		for (int k = 0; k < K; k++) {
			for (int n = 0; n < N; n++) {
				line = s.next(); // read next valid line
				for (int m = 0; m < M; m++) {
					num[k][m + n * M] = Byte.valueOf(line.substring(m, m + 1));
				}
			}
		}
		s.close();
		for (byte i = 0; i < K; i++) {
			row[i] = i;
			if (DEBUG)
				U.p(num[i]);
		}
	}

	// Debug Mode , random data
	public void readDataDebug(int N, int M, int K) {

		num = new byte[K][];
		row = new byte[K];
		this.N = (byte) N;
		this.M = (byte) M;
		this.K = (byte) K;
		for (int i = 0; i < K; i++) {
			num[i] = new byte[N * M]; // initialize array
		}
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N * M; j++) {
				num[i][j] = (byte) Math.round(Math.random());
			}
		}
		for (byte i = 0; i < K; i++) {
			row[i] = i;
			if (DEBUG)
				U.p(num[i]);
		}
	}

}
