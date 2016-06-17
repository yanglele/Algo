package com.works.characterRecognation;

public class U {
	public static <T> void p(T arg) {
		System.out.println("" + arg);
	}

	public static void p(int[] arg) {
		for (int i : arg) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void p(byte[] arg) {
		for (int i : arg) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void p(Integer[] arg) {
		for (int i : arg) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
