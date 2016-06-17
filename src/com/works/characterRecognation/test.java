package com.works.characterRecognation;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string="ab";
		char[] a=null;
		char a1='1';
		char a2='2';
		char a3=(char) (a1+a2);
		System.out.println("result="+a3);
		a=string.toCharArray();
		for(int i=0;i<a.length;i++)
		System.out.println(a[i]+" ");
	}

}
