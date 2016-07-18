package com.test;

public class TestThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A a = new A();
		TestThis testThis = new TestThis();
		testThis.tell();
		System.out.println(testThis);
	}

	public void tell() {
		System.out.println(this);// 打印当前对象的字符串表示
	}

}

class A {
	private int num = 1;

	public A() {
		new B(this).print();
	}

	public void print() {
		System.out.println("a num=" + num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class B {
	private int num = 2;

	public B(A a) {
		this.num = a.getNum();
	}

	public void print() {
		System.out.println("b num=" + num);
	}
}
