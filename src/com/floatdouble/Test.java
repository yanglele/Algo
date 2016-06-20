package com.floatdouble;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a = 1;
		double b = 9999.99999832231;
		float c = 2.2f;
		System.out.println(Float.floatToIntBits(c));
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(c)));
		System.out.println(c);
		System.out.println("---" + (3.3f - 1.1f));

		System.out.println(0.06 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(303.1 / 1000);

		// 使用bigdecimal时必须用string构造
		// http://www.cnblogs.com/chenfei0801/p/3672177.html
		BigDecimal bg1 = new BigDecimal(0.9);
		BigDecimal bg2 = new BigDecimal(1.0);
		System.out.println(bg2.subtract(bg1));// 输出0.09999999999999997779553950749686919152736663818359375

		BigDecimal bg3 = new BigDecimal("0.9");
		BigDecimal bg4 = new BigDecimal("1.0");
		System.out.println(bg4.subtract(bg3));// 输出0.1
	}

}
