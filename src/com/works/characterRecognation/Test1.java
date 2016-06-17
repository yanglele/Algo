package com.works.characterRecognation;

public class Test1 {

	private static Node1 node[] = new Node1[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 test1 = new Test1();
		node[0] = new Node1();
		if (node[0] == null)
			System.out.println("null");
		System.out.println(node[0]);
	}

}

class Node {
	int left;
	int right;

	public Node() {
	};
}