package com.works.characterRecognation;

import java.util.Scanner;

public class XorResult {

	final static int N = 100005;
	private static int tot = 0;
	private static Node1 tree[] = new Node1[41 * N];

	public long max(long a, long b) {
		return a > b ? a : b;
	}

	public void init(int x) {
		for (int i = 0; i < 10000; i++)
			tree[i] = new Node1();
		tree[x].left = -1;
		tree[x].right = -1;
	}

	public void insert(long x) {
		int i, u = 0;
		for (i = 40; i >= 0; i--) {
			if ((x & ((1l) << i)) > 0) {
				if (tree[u].right == -1) {
					init(tot);
					tree[u].right = tot++;
					u = tree[u].right;
				}
			} else {
				if (tree[u].left == -1) {
					init(tot);
					tree[u].left = tot++;
					u = tree[u].left;
				}
			}
		}
	}

	public long find(long x) {
		int i, u = 0, id;
		long res = 0l;
		for (i = 40; i >= 0; i--) {
			if ((x & ((1l) << i)) == 1)
				id = 0;
			else
				id = 1;

			if (id == 0) {
				if (tree[u].left == -1)
					id ^= 1;
			} else {
				if (tree[u].right == -1)
					id ^= 1;
			}
			res = res * 2 + id;
			if (id == 0)
				u = tree[u].left;
			else
				u = tree[u].right;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long a[] = new long[N];

		XorResult test = new XorResult();
		Scanner scanner = new Scanner(System.in);
		int n, i;
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			System.out.println("n=" + n);
			scanner.nextLine();
			scanner.nextLine();
			long cur = 0l;
			for (i = 0; i < n; i++) {
				a[i] = scanner.nextLong();
				cur ^= a[i];
			}
			test.init(0);
			tot = 1;
			long ins = 0l, ans = 0l;
			test.insert(0l);
			for (i = 0; i < n; i++) {
				ins ^= a[i];
				cur ^= a[i];
				test.insert(ins);
				ans = test.max(ans, test.find(cur) ^ cur);
			}
			System.out.println(ans);
		}
	}

}

class Node1 {
	int left;
	int right;
}
